/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

/**
 * Cargo Collector - controls the intake motors and the solenoid "kicker" for
 * Cargo manipulation
 */
public class CargoCollector extends Subsystem {

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  public void extendCargoSolenoid() {
    Robot.oi.cargoSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void retractCargoSolenoid() {
    Robot.oi.cargoSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void stopSolenoid() {
    Robot.oi.cargoSolenoid.set(DoubleSolenoid.Value.kOff);
  }
}
