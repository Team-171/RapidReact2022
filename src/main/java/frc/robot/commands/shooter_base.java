// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.shooter;

import frc.robot.Robot;

public class shooter_base extends CommandBase {
  /** Creates a new shooter_base. */

/////////////////////////////////////////////////////////////////////////////////////
  // Changed private final shooter = shooter_subsystem; to below, this should work now
  private shooter shooter_subsystem  = new shooter();
/////////////////////////////////////////////////////////////////////////////////////

SparkMaxPIDController top_motors_controller;
SparkMaxPIDController bottom_motors_controller;

//private CANSparkMax top_shooter = new CANSparkMax(Constants.TOP_SHOOTER, MotorType.kBrushless);
//private CANSparkMax bottom_shooter = new CANSparkMax(Constants.BOTTOM_SHOOTER, MotorType.kBrushless);
XboxController driverController = new XboxController(Constants.JOYSTICK_NUMBER);

  //initialize the shooter base
  public shooter_base(shooter s_s) {
    // Use addRequirements() here to declare subsystem dependencies.
    shooter_subsystem = s_s;
    addRequirements(shooter_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    top_motors_controller = Robot.top_shooter.getPIDController();
    bottom_motors_controller = Robot.bottom_shooter.getPIDController();

     // reset PID coefficients
     Robot.top_shooter.restoreFactoryDefaults();
     Robot.bottom_shooter.restoreFactoryDefaults();
  
     // set PID coefficients
     top_motors_controller.setP(Constants.KP);
     top_motors_controller.setI(Constants.KI);
     top_motors_controller.setD(Constants.KD);
     top_motors_controller.setIZone(0);
     top_motors_controller.setFF(0);
     top_motors_controller.setOutputRange(-1, 1);
  
     bottom_motors_controller.setP(Constants.KP);
     bottom_motors_controller.setI(Constants.KI);
     bottom_motors_controller.setD(Constants.KD);
     bottom_motors_controller.setIZone(0);
     bottom_motors_controller.setFF(0);
     bottom_motors_controller.setOutputRange(-1, 1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
//////////////////////////////////////////////////////////////////////////
    // Changed shooter.setRPM to shooter_subsystem.setRPM
    // Set RPM according to a button being pressed
    if(driverController.getRawButtonPressed(Constants.XBOX_LB)){
      shooter_subsystem.setRPMShooter(Constants.SHOOT_SPEED);
    } 

    if (driverController.getRawButtonReleased(Constants.XBOX_LB)) {
      shooter_subsystem.setRPMShooter(0);
    }
//////////////////////////////////////////////////////////////////////////
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
/*
      WEEGEE
  ____     ___
   ___\   /___
  /   \   /   \
  | * |   | * |
  \___/   \___/
        |
       /_\
   _  _____  _
   \_/  _  \_/
    
    */