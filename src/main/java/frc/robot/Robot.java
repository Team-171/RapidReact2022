/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
//package org.usfirst.frc.team171.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
//import frc.robot.Autonomous.*;
//import frc.robot.subsystems.*;
//import frc.robot.commands.*;
/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  // Drive train
  public static CANSparkMax left_front;
  public static CANSparkMax right_front;
  public static CANSparkMax left_back;
  public static CANSparkMax right_back;

  public static MotorControllerGroup left_motors;
  public static MotorControllerGroup right_motors;

  public static DifferentialDrive drive;

  // Intake, Elevator
  public static Spark intake_motor;
  public static Spark elevator_motor;
  public static Solenoid intake_piston;
  public static Solenoid block_piston;

  // Shooter
  public static SparkMaxPIDController top_controller;
  public static SparkMaxPIDController bottom_controller;
  public static CANSparkMax top_shooter;
  public static CANSparkMax bottom_shooter;

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
    intake_motor = new Spark(Constants.INTAKE);
    intake_piston = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.INTAKE_PISTON);

    // This was originally going to be used to keep the balls lined up before intake, 
    // switched to color sensor, so for now we are not using it. 
    //block_piston = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.BLOCK_PISTON);

    // Elevator
    elevator_motor = new Spark(Constants.ELEVATOR);

    // Shooter
    top_shooter = new CANSparkMax(Constants.TOP_SHOOTER, MotorType.kBrushless);
    bottom_shooter = new CANSparkMax(Constants.BOTTOM_SHOOTER, MotorType.kBrushless);

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
