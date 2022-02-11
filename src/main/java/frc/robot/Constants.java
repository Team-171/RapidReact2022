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
    public static final int LEFT_FRONT = 4;
    public static final int RIGHT_FRONT = 1;
    public static final int LEFT_BACK = 2;
    public static final int RIGHT_BACK = 3;

    //Xbox Controller
    public static final int XBOX_LY = 1;
    public static final int XBOX_LX = 0;
    public static final int XBOX_LT = 2;
    public static final int XBOX_RT = 3;
    public static final int XBOX_RB = 5;
    public static final int XBOX_LB = 4;
    

	public static final double DRIVETRAINSPEED = 0.75;
	public static final int JOYSTICK_NUMBER = 0;
    public static final int TOP_SHOOTER = 5;  
    public static final int BOTTOM_SHOOTER = 6; 
    public static final double KP = 0.1;
    public static final double KI = 0.0001;
    public static final double KD = 1;

//PWM Channels
    public static final int INTAKE = 0; //Not assigned
    public static final int ELEVATOR = 0; //Not assigned
    public static final int INTAKE_PISTON = 0; //Not assigned
	public static final int BLOCK_PISTON = 0;
    public static final int XBOX_A = 0;
}
