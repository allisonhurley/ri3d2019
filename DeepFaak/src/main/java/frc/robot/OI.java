/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.commands.PlaceCargo;
import frc.robot.commands.PlaceHatch;
import frc.robot.commands.RetractCargoSolenoid;
import frc.robot.commands.RetractHatchSolenoid;
import frc.robot.utils.Gamepad;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  /* Motor Controllers */
  public WPI_TalonSRX driveLeftFront = new WPI_TalonSRX(7);
  public WPI_TalonSRX driveLeftMiddle = new WPI_TalonSRX(6);
  public WPI_TalonSRX driveLeftBack = new WPI_TalonSRX(5);
  public WPI_TalonSRX driveRightFront = new WPI_TalonSRX(0);
  public WPI_TalonSRX driveRightMiddle = new WPI_TalonSRX(1);
  public WPI_TalonSRX driveRightBack = new WPI_TalonSRX(2);
  public WPI_TalonSRX cargoCollectorOne = new WPI_TalonSRX(3);
  public WPI_TalonSRX cargoCollectorTwo = new WPI_TalonSRX(4);
  
  /* Solenoids */
  public DoubleSolenoid cargoSolenoid = new DoubleSolenoid(0, 1);
  public DoubleSolenoid hatchSolenoid = new DoubleSolenoid(2, 3);

  /* Controllers */
  Gamepad driverGamepad = new Gamepad(RobotMap.driverGamepadPort);
  Gamepad operatorGamepad = new Gamepad(RobotMap.operatorGamepadPort);

  /* Allowing robot to access controls */
  public OI() {
    bindControls();
  }

  /* Gamepad buttons */
  private void bindControls() {
    operatorGamepad.getButtonA().whenPressed(new PlaceHatch());
    operatorGamepad.getButtonB().whenPressed(new RetractHatchSolenoid());
    operatorGamepad.getButtonX().whenPressed(new PlaceCargo());
    operatorGamepad.getButtonY().whenPressed(new RetractCargoSolenoid());
  }

  /* Gamepad sticks */
  public double getDriverGamepadLeftY() {
    double y = driverGamepad.getLeftY();
    return y;
  }

  public double getDriverGamepadRightY() {
    double y = driverGamepad.getRightY();
    return y;
  }

  public double getDriverGamepadRightX() {
    double x = driverGamepad.getRightX();
    return x;
  }
}
