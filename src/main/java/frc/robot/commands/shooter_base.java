// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.shooter;

public class shooter_base extends CommandBase {
  /** Creates a new shooter_base. */
  private final shooter shooter_subsystem;
  XboxController driverController = new XboxController(Constants.JOYSTICK_NUMBER);

  public shooter_base(shooter s_s) {
    // Use addRequirements() here to declare subsystem dependencies.
    shooter_subsystem = s_s;
    addRequirements(shooter_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if(driverController.getRawButtonPressed(Constants.XBOX_LB)){
      shooter.setRPMShooter(3000);
    } else {
      shooter.setRPMShooter(0);
    }

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
