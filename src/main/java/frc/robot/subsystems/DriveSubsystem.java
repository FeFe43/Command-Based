// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveSubsystem extends SubsystemBase {

   private WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(5);
   private WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(4);  
   private WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(7);
   private WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(6);
   
  public DriveSubsystem() {
    rightMotor2.follow(rightMotor1);
    leftMotor2.follow(leftMotor1);
    rightMotor1.setInverted(true);
    rightMotor2.setInverted(true);
  }

  @Override
  public void periodic() {}

  public void setMotors(double leftSpeed, double rightSpeed) {
    leftMotor1.set(TalonSRXControlMode.PercentOutput, leftSpeed);
    rightMotor1.set(TalonSRXControlMode.PercentOutput, rightSpeed);
  }
}
