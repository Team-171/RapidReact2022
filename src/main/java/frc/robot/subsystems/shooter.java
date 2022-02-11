// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class shooter extends SubsystemBase {
  /** Creates a new shooter. */
  private final CANSparkMax top_shooter;
  private final CANSparkMax bottom_shooter;

  SparkMaxPIDController top_controller;
  SparkMaxPIDController bottom_controller;

  public shooter() {
    top_shooter = new CANSparkMax(Constants.TOP_SHOOTER, MotorType.kBrushless);
    bottom_shooter = new CANSparkMax(Constants.BOTTOM_SHOOTER, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
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

  public void setRPMShooter(double RPM) {
    top_controller.setReference(RPM - 500, CANSparkMax.ControlType.kVelocity);
    bottom_controller.setReference(RPM, CANSparkMax.ControlType.kVelocity);
  }
}

