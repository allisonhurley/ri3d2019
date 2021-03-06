/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.TankDrive;
import frc.robot.commands.ArcadeDrive;
import frc.robot.Robot;

/**
 * Drivetrain - controls the drivetrain motors and allows for controlling with
 * both Arcade Drive and Tank Drive
 */
public class Drivetrain extends Subsystem {
  private SpeedControllerGroup driveLeft = new SpeedControllerGroup(Robot.oi.driveLeftFront, 
                                                                    Robot.oi.driveLeftMiddle,
                                                                    Robot.oi.driveLeftBack);

  private SpeedControllerGroup driveRight = new SpeedControllerGroup(Robot.oi.driveRightFront, 
                                                                    Robot.oi.driveRightMiddle,
                                                                    Robot.oi.driveRightBack);

  private DifferentialDrive drive = new DifferentialDrive(driveLeft, driveRight);

  @Override
  public void initDefaultCommand() {
    // setDefaultCommand(new TankDrive());
    setDefaultCommand(new ArcadeDrive());
  }

  public void arcadeDrive(double speed, double rotation) {
    drive.arcadeDrive(speed, rotation);
  }

  public void tankDrive(double left, double right) {
    drive.arcadeDrive(left, right);
  }

  public void timedDrive(double speed, double rotation, double time) {
    drive.arcadeDrive(speed, rotation);
  }

  public void stop() {
    drive.stopMotor();
  }
}
