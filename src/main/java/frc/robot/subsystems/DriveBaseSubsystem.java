/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Compressor;



public class DriveBaseSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveBaseSubsystem.
   */

     // instantiate new motor controller objects
  //right motors
  public CANSparkMax motorA = new CANSparkMax(Constants.CANDeviceID1, MotorType.kBrushless);
  public CANSparkMax motorB = new CANSparkMax(Constants.CANDeviceID2, MotorType.kBrushless);
  public CANSparkMax motorC = new CANSparkMax(Constants.CANDeviceID3, MotorType.kBrushless);

  //left motors
  public CANSparkMax motorD = new CANSparkMax(Constants.CANDeviceID4, MotorType.kBrushless);
  public CANSparkMax motorE = new CANSparkMax(Constants.CANDeviceID5, MotorType.kBrushless);
  public CANSparkMax motorF = new CANSparkMax(Constants.CANDeviceID6, MotorType.kBrushless);

  //fix motors to a speed controller group
  SpeedControllerGroup spc_right = new SpeedControllerGroup(motorA, motorB, motorC);
  SpeedControllerGroup spc_left = new SpeedControllerGroup(motorD, motorE, motorF);
  
// instantiate a new DifferentialDrive object pass motor controllers as arguments
public DifferentialDrive drivetrain = new DifferentialDrive(spc_left, spc_right);

//Compressor
Compressor compressor = new Compressor(Constants.compressor);

// add manualDrive() method
public void manualDrive(double getLeftStick, double getRightStick) {

  drivetrain.tankDrive(getLeftStick,getRightStick);

}

public void compressor(boolean compressorValue) {

  compressor.setClosedLoopControl(compressorValue);

}

  public DriveBaseSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
