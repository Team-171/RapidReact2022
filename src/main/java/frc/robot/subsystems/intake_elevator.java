// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class intake_elevator extends SubsystemBase{
  /** Creates a new intake_elevator. */
  /*Spark intake_motor;
  Spark elevator_motor;
  Solenoid intake_piston;
  Solenoid block_piston;*/

  // Constructor
  public intake_elevator() {
    /*intake_motor = new Spark(Constants.INTAKE);
    elevator_motor = new Spark(Constants.ELEVATOR);
    intake_piston = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.INTAKE_PISTON);
    block_piston = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.BLOCK_PISTON);*/
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // Turns on/activates the intake
  // XBOX_A
  public void intake_piston_set(XboxController controller) {
  if (controller.getRawButtonPressed(Constants.XBOX_ACC_XB)) {
    Robot.intake_piston.set(true);
  } // end if controller.getRawButtonPressed

  if (controller.getRawButtonReleased(Constants.XBOX_ACC_BB)) {
    Robot.intake_piston.set(false);
  } // end if controller.getRawButtonReleased

  // Out
  if (controller.getLeftTriggerAxis() > 0)
    Robot.intake_motor.set(controller.getLeftTriggerAxis());

  // In
  if (controller.getRightTriggerAxis() > 0)
    Robot.intake_motor.set(controller.getRightTriggerAxis());

  // Elevator up
  if (controller.getRawAxis(Constants.XBOX_ACC_LJ) > 0)
    Robot.elevator_motor.set(controller.getRawAxis(Constants.XBOX_ACC_LJ));
  
  // ELevator Down
  if (controller.getRawAxis(Constants.XBOX_ACC_LJ) < 0)
    Robot.elevator_motor.set(controller.getRawAxis(Constants.XBOX_ACC_LJ));

  //equal to zero??
  
  // XBOX_A
  } // end intake_piston_set
}
