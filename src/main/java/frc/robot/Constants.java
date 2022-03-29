/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //CAN Motors
    public static final int LEFT_FRONT = 9;
    public static final int RIGHT_FRONT = 7;
    public static final int LEFT_BACK = 8;
    public static final int RIGHT_BACK = 6;

    public static final int INTAKE = 5; 
    public static final int ELEVATOR = 4; 
    public static final int LEFT_CLIMBER = 10; 
    public static final int RIGHT_CLIMBER = 3; 
    public static final int TOP_SHOOTER = 2;  
    public static final int BOTTOM_SHOOTER = 1;

    //Xbox Controller Driver
    public static final int XBOX_LY = 1;
    public static final int XBOX_LX = 0;
    public static final int XBOX_LT = 2;
    public static final int XBOX_RT = 3;
    public static final int XBOX_RB = 6;
    public static final int XBOX_LB = 5;
    public static final int XBOX_DRIVE_RJ = 5;
    public static final int XBOX_DRIVE_LJ = 1;
    public static final int XBOX_DRIVE_XB = 3;

    //Xbox Controller Accessories
    public static final int XBOX_ACC_LT = 2;
    public static final int XBOX_ACC_RT = 3;
    public static final int XBOX_ACC_XB = 3;
    public static final int XBOX_ACC_BB = 2;
    public static final int XBOX_ACC_LJ = 1;
    public static final int XBOX_ACC_DPAD = 5;  //fix
    
    // ??
	public static final int JOYSTICK_NUMBER = 0;
    //public static final int TOP_SHOOTER = 8;  
    //public static final int BOTTOM_SHOOTER = 9; 
    public static final double KP = 0.1;
    public static final double KI = 0.0001;
    public static final double KD = 1;

    //PWM Channels
    //public static final int INTAKE = 4; 
    //public static final int ELEVATOR = 6; 
    public static final int INTAKE_PISTON = 0; 
	//public static final int LEFT_CLIMBER = 7; 
    //public static final int RIGHT_CLIMBER = 10; 
    //public static final int XBOX_A = 0;

    //set speeds
    public static final int SHOOT_SPEED = 3500;
    public static final double DRIVETRAINSPEED = 0.75;
    public static final int CLIMB_SPEED = 1;        //ask someone what a good speed is

    //Elevator Constants
    public static final int MAX_HEIGHT = 10000;
    public static final int MIN_HEIGHT = 0;
}
