/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveBaseSubsystem;

public class ManualDriveCommand extends CommandBase {
  private final DriveBaseSubsystem driveBaseSubsystem;

  /**
   * Creates a new ManualDriveCommand.
   * 
   */

  public ManualDriveCommand(final DriveBaseSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveBaseSubsystem = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    int pov = RobotContainer.pov();
    
    int povForward = Constants.povForward;
    int povBackward = Constants.povBackward;
    int povLeft = Constants.povLeft;
    int povRight = Constants.povRight;

    double leftDrive;
    double rightDrive;

    boolean compressorValue = true;

    if( pov == povForward ) {
      leftDrive = 0.42;
      rightDrive = 0.42;
    }
    else if( pov == povBackward ) {
      leftDrive = -0.42;
      rightDrive = -0.42;
    }
    else if( pov == povLeft ) {
      leftDrive = -0.42;
      rightDrive = 0.42;
    }
    else if( pov == povRight ) {
      leftDrive = 0.42;
      rightDrive = -0.42;
    }
    else {
      leftDrive = RobotContainer.getLeftStick();
      rightDrive = RobotContainer.getRightStick();
    }

    driveBaseSubsystem.manualDrive(-leftDrive, -rightDrive);

    //sets compressor to run until full
    driveBaseSubsystem.compressor(compressorValue);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
