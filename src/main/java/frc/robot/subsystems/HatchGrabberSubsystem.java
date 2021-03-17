/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Solenoid;

public class HatchGrabberSubsystem extends SubsystemBase {
  /**
   * Creates a new HatchGrabberSubsystem.
   */

   //Pneumatics
   Solenoid clawA = new Solenoid(Constants.solenoidA);
   Solenoid clawB = new Solenoid(Constants.solenoidB);

  public HatchGrabberSubsystem() {
    
  }

  public void setHatchGrabber(boolean solenoidA, boolean solenoidB) {

    clawA.set(solenoidA);
    clawB.set(solenoidB);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
