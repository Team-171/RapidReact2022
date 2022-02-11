// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class intake_elevator extends SubsystemBase {
  /** Creates a new intake_elevator. */
  Spark intake_motor;
  Spark elevator_motor;
  Solenoid intake_piston;
  Solenoid block_piston;

  public intake_elevator() {
    intake_motor = new Spark(Constants.INTAKE);
    elevator_motor = new Spark(Constants.ELEVATOR);
    intake_piston = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.INTAKE_PISTON);
    block_piston = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.BLOCK_PISTON);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void intake_piston_set(XboxController controller) {
    if (controller.getRawButton(Constants.XBOX_A) == true) {
      intake_piston.set(true);
      intake_motor.set(0.5);
    } else {}
  } 


}
