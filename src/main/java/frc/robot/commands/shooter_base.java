// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.shooter;

public class shooter_base extends CommandBase {
  /** Creates a new shooter_base. */

/////////////////////////////////////////////////////////////////////////////////////
  // Changed private final shooter = shooter_subsystem; to below, this should work now
  private shooter shooter_subsystem  = new shooter();
/////////////////////////////////////////////////////////////////////////////////////

SparkMaxPIDController top_controller;
SparkMaxPIDController bottom_controller;

private CANSparkMax top_shooter = new CANSparkMax(Constants.TOP_SHOOTER, MotorType.kBrushless);
private CANSparkMax bottom_shooter = new CANSparkMax(Constants.BOTTOM_SHOOTER, MotorType.kBrushless);
  XboxController driverController = new XboxController(Constants.JOYSTICK_NUMBER);

  public shooter_base(shooter s_s) {
    // Use addRequirements() here to declare subsystem dependencies.
    shooter_subsystem = s_s;
    addRequirements(shooter_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    top_controller = top_shooter.getPIDController();
    bottom_controller = bottom_shooter.getPIDController();
     // PID coefficients
     
     top_shooter.restoreFactoryDefaults();
     bottom_shooter.restoreFactoryDefaults();
  
     // set PID coefficients
     top_controller.setP(Constants.KP);
     top_controller.setI(Constants.KI);
     top_controller.setD(Constants.KD);
     top_controller.setIZone(0);
     top_controller.setFF(0);
     top_controller.setOutputRange(-1, 1);
  
     bottom_controller.setP(Constants.KP);
     bottom_controller.setI(Constants.KI);
     bottom_controller.setD(Constants.KD);
     bottom_controller.setIZone(0);
     bottom_controller.setFF(0);
     bottom_controller.setOutputRange(-1, 1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
//////////////////////////////////////////////////////////////////////////
    // Changed shooter.setRPM to shooter_subsystem.setRPM
    if(driverController.getRawButtonPressed(Constants.XBOX_LB)){
      shooter_subsystem.setRPMShooter(3000);
    } else {
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