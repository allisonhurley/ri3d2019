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
 * Hatch Collector - used to place Hatch Covers in their respective places on the field
 */
public class HatchCollector extends Subsystem {

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  public void extendHatchSolenoid() {
    Robot.oi.hatchSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void retractHatchSolenoid() {
    Robot.oi.hatchSolenoid.set(DoubleSolenoid.Value.kReverse);
  }
  
  public void stopHatchSolenoid() {
    Robot.oi.hatchSolenoid.set(DoubleSolenoid.Value.kOff);
  }
}
