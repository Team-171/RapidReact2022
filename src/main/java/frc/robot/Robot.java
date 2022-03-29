/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
//package org.usfirst.frc.team171.robot;

import javax.lang.model.util.ElementScanner6;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import frc.robot.Autonomous.ShootMove;
import frc.robot.commands.shooter_base;
import frc.robot.commands.climber_base;
import frc.robot.subsystems.drive_train;
import frc.robot.subsystems.intake_elevator;
import frc.robot.subsystems.shooter;
import frc.robot.subsystems.climber;
import edu.wpi.first.wpilibj.XboxController;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  // Color Sensor
  /*private final I2C.Port sensor_port = I2C.Port.kOnboard;
  private final ColorSensorV3 color_sensor = new ColorSensorV3(sensor_port);
  private final ColorMatch color_match = new ColorMatch();

  private final Color color_blue = new Color(0.143, 0.427, 0.429); // Temp values, CHANGE THIS
  private final Color color_red = new Color(0.561, 0.232, 0.114); // Temp values, CHANGE THIS*/

  // Drive train
  public static CANSparkMax left_front;
  public static CANSparkMax right_front;
  public static CANSparkMax left_back;
  public static CANSparkMax right_back;

  public static MotorControllerGroup left_motors;
  public static MotorControllerGroup right_motors;

  public DifferentialDrive drive;

  // Intake, Elevator
  public static CANSparkMax intake_motor;
  public static CANSparkMax elevator_motor;
  public static Solenoid intake_piston;
  public static Solenoid block_piston;

  // Shooter
  public static SparkMaxPIDController top_controller;
  public static SparkMaxPIDController bottom_controller;
  public static CANSparkMax top_shooter;
  public static CANSparkMax bottom_shooter;

  // Climber
  public static CANSparkMax left_climber;
  public static CANSparkMax right_climber;

  // Controller One
  public static XboxController drive_control;
  public static double speed;
  public static drive_train drive_train;

  // Controller Two
  public static XboxController accessory_controller;

  // Other
  public static ShootMove shoot_move;
  public static shooter shooter_subsystem;
  public static shooter_base shoot_base;
  public static intake_elevator intake_ele;
  public static climber climber;
  public static climber_base climber_base;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.

    // Drive train
    left_front = new CANSparkMax(Constants.LEFT_FRONT, MotorType.kBrushless); 
    left_front.setInverted(false); 
    right_front = new CANSparkMax(Constants.RIGHT_FRONT, MotorType.kBrushless); 
    right_front.setInverted(true); 
    left_back = new CANSparkMax(Constants.LEFT_BACK, MotorType.kBrushless); 
    left_back.setInverted(false); 
    right_back = new CANSparkMax(Constants.RIGHT_BACK, MotorType.kBrushless); 
    right_back.setInverted(true); 
  
    left_motors = new MotorControllerGroup(left_front, left_back); 
    right_motors = new MotorControllerGroup(right_front, right_back); 
 
    drive = new DifferentialDrive(left_motors, right_motors);

    // Intake
    intake_motor = new CANSparkMax(Constants.INTAKE,  MotorType.kBrushless);
    intake_piston = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.INTAKE_PISTON);

    // This was originally going to be used to keep the balls lined up before intake, 
    // switched to color sensor, so for now we are not using it. 
    //block_piston = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.BLOCK_PISTON);

    // Elevator
    elevator_motor = new CANSparkMax(Constants.ELEVATOR,  MotorType.kBrushless);

    // Shooter
    top_shooter = new CANSparkMax(Constants.TOP_SHOOTER, MotorType.kBrushless);
    bottom_shooter = new CANSparkMax(Constants.BOTTOM_SHOOTER, MotorType.kBrushless);
    shooter_subsystem = new shooter();
    shoot_base = new shooter_base(shooter_subsystem);

    // Climber
    left_climber = new CANSparkMax(Constants.LEFT_CLIMBER, MotorType.kBrushless);
    right_climber = new CANSparkMax(Constants.RIGHT_CLIMBER, MotorType.kBrushless);

    // Color sensor
    //color_match.addColorMatch(color_blue);
    //color_match.addColorMatch(color_red);

    drive_control = new XboxController(1);
    accessory_controller = new XboxController(2);

    m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();

    //String color_string;
    //Color color_detected = color_sensor.getColor();
    //ColorMatchResult color_match_result = color_match.matchClosestColor(color_detected);

    //SmartDashboard.putNumber("Red", color_detected.red);
    //SmartDashboard.putNumber("Blue", color_detected.blue);

    // This stays commented out until we are able to calibrate the sensor
    /*if(color_match_result.color == color_blue)
      color_string = "Blue";
    else if(color_match_result.color == color_red)
      color_string = "Red";
    else
      color_string = "Unknown";
      
    SmartDashboard.putString("Color: ", color_string);*/
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    //shoot_move.run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    //drive according to controller triggers and joystick
    //drive_train.drive_with_controller(drive_control, Constants.DRIVETRAINSPEED);
    drive.tankDrive(drive_control.getLeftY(), drive_control.getRightY());
    
    //run shooter motors according to button press
    //shoot_base.execute();
    
    //change intake position according to button
    //intake_ele.intake_piston_set(accessory_controller);
    
    //change elevator position according to button
    //climber_base.execute();
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
