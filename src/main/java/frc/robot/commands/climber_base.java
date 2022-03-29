/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.climber;

// UP - Right bumper button
//down - left bumper button
//piston true - x button
//two motors

public class climber_base extends CommandBase{
  /**
   * Creates a new climber_base.
   */
  private climber climber_subsystem  = new climber();
  XboxController driverController = new XboxController(Constants.JOYSTICK_NUMBER);
  private final RelativeEncoder climb_left_motor_encoder = Robot.left_climber.getEncoder();
  private final RelativeEncoder climb_right_motor_encoder = Robot.right_climber.getEncoder();

  public climber_base(climber climber) {
    // Use addRequirements() here to declare subsystem dependencies.
    climber_subsystem = climber;
    addRequirements(climber_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      if(driverController.getRawButtonPressed(Constants.XBOX_RB)){
        Robot.climber.setGoUpClimberSpeed();
      }

      if(driverController.getRawButtonReleased(Constants.XBOX_RB)){
        Robot.climber.setStopClimberSpeed();
      }

      if(driverController.getRawButtonPressed(Constants.XBOX_LB)){
        Robot.climber.setGoDownClimberSpeed();
      }

      if(driverController.getRawButtonReleased(Constants.XBOX_LB)){
        Robot.climber.setStopClimberSpeed();
      }

      //for piston - don't know what piston is for
      if(driverController.getRawButtonPressed(Constants.XBOX_DRIVE_XB)){

      }
      //for piston - don't know what piston is for
      if(driverController.getRawButtonReleased(Constants.XBOX_DRIVE_XB)){

      }
  }

  public boolean inLimits(double speed)
  {
      if (speed >= 0){
          if (getAvgEncoderPosition() < Constants.MAX_HEIGHT){
              return true;
          }
      }
      else{
        if(getAvgEncoderPosition() > Constants.MIN_HEIGHT){
            return true;
        }
      }
      return false;
  }

  public double getAvgEncoderPosition()
  {
      return ((climb_left_motor_encoder.getPosition() + climb_right_motor_encoder.getPosition()) / 2);
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

