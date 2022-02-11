/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.drive_train;

public class drive_base extends CommandBase {
  /**
   * Creates a new drive_base.
   */
  private final drive_train Drive_Train;
  XboxController driverController = new XboxController(Constants.JOYSTICK_NUMBER);

  public drive_base(drive_train dt) {
    // Use addRequirements() here to declare subsystem dependencies.
    Drive_Train = dt;
    addRequirements(Drive_Train);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Drive_Train.drive_with_controller(driverController, Constants.DRIVETRAINSPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
