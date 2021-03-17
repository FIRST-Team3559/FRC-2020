/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.CloseHatchGrabberCommand;
import frc.robot.commands.ManualDriveCommand;
import frc.robot.commands.OpenHatchGrabberCommand;
import frc.robot.subsystems.DriveBaseSubsystem;
import frc.robot.subsystems.HatchGrabberSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveBaseSubsystem driveBaseSubsystem = new DriveBaseSubsystem();
  private final ManualDriveCommand manualDriveCommand = new ManualDriveCommand(driveBaseSubsystem);

  private final HatchGrabberSubsystem hatchGrabberSubsystem = new HatchGrabberSubsystem();
  private final OpenHatchGrabberCommand openHatchGrabberCommand = new OpenHatchGrabberCommand(hatchGrabberSubsystem);
  private final CloseHatchGrabberCommand closeHatchGrabberCommand = new CloseHatchGrabberCommand(hatchGrabberSubsystem);

  public static Joystick stick1 = new Joystick(Constants.joystickPort1);
  public static JoystickButton aButton = new JoystickButton(stick1, Constants.aButtonPort);
  public static JoystickButton bButton = new JoystickButton(stick1, Constants.bButtonPort);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    driveBaseSubsystem.setDefaultCommand(manualDriveCommand);

  }

  public static double getLeftStick() {
    return stick1.getRawAxis(1);
  }

  public static double getRightStick() {
  return stick1.getRawAxis(5);
  }

  public static int pov() {
    return stick1.getPOV();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    //HatchGrabber Opperation
    aButton.whenPressed(openHatchGrabberCommand);
    bButton.whenPressed(closeHatchGrabberCommand);
  
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return manualDriveCommand;
  }
}
