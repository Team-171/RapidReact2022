/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import frc.robot.Constants;
import frc.robot.Robot;

// UP - Right bumper button
//down - left bumper button
//piston true - x button
//two motors

// extends SubsystemBase
public class climber {
    public climber(){
        
    }

    public void setGoUpClimberSpeed(){
        Robot.left_climber.set(Constants.CLIMB_SPEED);
        Robot.right_climber.set(Constants.CLIMB_SPEED);
    }

    public void setGoDownClimberSpeed(){
        Robot.left_climber.set(-Constants.CLIMB_SPEED);
        Robot.right_climber.set(-Constants.CLIMB_SPEED);
    }

    public void setStopClimberSpeed(){
        Robot.left_climber.set(0);
        Robot.right_climber.set(0);
    }


}
