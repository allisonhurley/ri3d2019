/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PlaceHatch extends CommandGroup {
  /**
   * Used to place Hatch Covers by extending the Hatch solenoid and drives 
   * backwards at the same time to ensure Hatch Covers stay in place
   */
  public PlaceHatch() {
    addSequential(new ExtendHatchSolenoid());
    addSequential(new TimedDriveBackwards(0.5));
  }
}
