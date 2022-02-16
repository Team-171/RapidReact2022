// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*
Auto to shoot the ball and then move back 5ft

Note: An encoder does 1120 ticks per rotation
*/

package frc.robot.Autonomous;

import edu.wpi.first.wpilibj.Encoder;
import frc.robot.subsystems.drive_train;

/** Add your docs here. */
public class ShootMove extends drive_train {
{

    int currentStep = 0;

    try (Encoder encode = new Encoder(0, 1)) {
        drive_train move = new drive_train();
        // Do we need to do 2 separate methods, one for red and one for blue? Will this apply to teleop as well?
        switch(currentStep) {
            case 0: // Get current location
                encode.reset();
                currentStep++;
                break;
            case 1: // Shoot the ball
                // Use a color sensor to tell when the ball has left the
                currentStep++;
                break;
            case 2:
                if (encode.getDistance() < 5) {
                    move.autoMove(true);
                }
                else {
                    move.autoMove(false);
                }
                currentStep++;
                break;
            default: //Nothing goes here, this just takes you out of the loop
                break;
        }
    }
}
}

