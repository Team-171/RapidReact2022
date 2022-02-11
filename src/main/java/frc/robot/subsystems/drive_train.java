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
import frc.robot.Constants;

public class drive_train extends SubsystemBase {

  /**
   * Creates a new drive_base.
   */

   CANSparkMax left_front;
   CANSparkMax right_front;
   CANSparkMax left_back;
   CANSparkMax right_back;

   MotorControllerGroup left_motors;
   MotorControllerGroup right_motors;

   DifferentialDrive drive;

  public drive_train() {

   left_front = new CANSparkMax(Constants.LEFT_FRONT, MotorType.kBrushless); 
   left_front.setInverted(false); 
   right_front = new CANSparkMax(Constants.RIGHT_FRONT, MotorType.kBrushless); 
   right_front.setInverted(true); 
   left_back = new CANSparkMax(Constants.LEFT_BACK, MotorType.kBrushless); 
   left_back.setInverted(false); 
   right_back = new CANSparkMax(Constants.RIGHT_BACK, MotorType.kBrushless); 
   right_back.setInverted(true); 
 
   left_motors = new MotorControllerGroup(left_front, left_back); 
   right_motors = new MotorControllerGroup(right_front, right_back); 

   drive = new DifferentialDrive(left_motors, right_motors);
 
  } 
 
  @Override 
  public void periodic() { 
    // This method will be called once per scheduler run 
    
  }

  public void drive_with_controller( XboxController controller , double speed) {
      drive.arcadeDrive((controller.getRawAxis(Constants.XBOX_RT)-controller.getRawAxis(Constants.XBOX_LT))*speed,
              controller.getRawAxis(Constants.XBOX_LX)*speed);
  } 
}
