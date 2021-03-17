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

//CANbus
  //right motors
  public static final int CANDeviceID1 = 16;
  public static final int CANDeviceID2 = 17;
  public static final int CANDeviceID3 = 18;
  //left motors
  public static final int CANDeviceID4 = 19;
  public static final int CANDeviceID5 = 20;
  public static final int CANDeviceID6 = 21;

  //USB
  public static final int joystickPort1 = 0;
  //public static final int joystickPort2 = 1;

  public static final int aButtonPort = 1;
  public static final int bButtonPort = 2;

  public static final int povBackward = 0;
  public static final int povForward = 180;
  public static final int povLeft = 90;
  public static final int povRight = 270;

  //Pneumatics
  public static final int compressor = 0;
  public static final int solenoidA = 1;
  public static final int solenoidB = 2;

  //Constants
  //public static int wheelDiameter = 6;

}
