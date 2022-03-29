// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;
import frc.robot.Robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class shooter extends SubsystemBase {
  /** Creates a new shooter. */
  //SparkMaxPIDController top_controller;
  //SparkMaxPIDController bottom_controller;
  
  //private CANSparkMax top_shooter = new CANSparkMax(Constants.TOP_SHOOTER, MotorType.kBrushless);
  //private CANSparkMax bottom_shooter = new CANSparkMax(Constants.BOTTOM_SHOOTER, MotorType.kBrushless);

  @Override
  public void periodic() {
    Robot.top_controller = Robot.top_shooter.getPIDController();
    Robot.bottom_controller = Robot.bottom_shooter.getPIDController();
     // PID coefficients
     
     Robot.top_shooter.restoreFactoryDefaults();
     Robot.bottom_shooter.restoreFactoryDefaults();
  
     // set PID coefficients
     Robot.top_controller.setP(Constants.KP);
     Robot.top_controller.setI(Constants.KI);
     Robot.top_controller.setD(Constants.KD);
     Robot.top_controller.setIZone(0);
     Robot.top_controller.setFF(0);
     Robot.top_controller.setOutputRange(-1, 1);
  
     Robot.bottom_controller.setP(Constants.KP);
     Robot.bottom_controller.setI(Constants.KI);
     Robot.bottom_controller.setD(Constants.KD);
     Robot.bottom_controller.setIZone(0);
     Robot.bottom_controller.setFF(0);
     Robot.bottom_controller.setOutputRange(-1, 1);
  }

  public void setRPMShooter(double RPM) {
    Robot.top_controller.setReference(RPM - 500, CANSparkMax.ControlType.kVelocity);
    Robot.bottom_controller.setReference(RPM, CANSparkMax.ControlType.kVelocity);
  }
}

