// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.IntakeCmd;
import frc.robot.commands.ShootCmd;
import frc.robot.commands.TankDriveCmd;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {

  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  public CommandXboxController controller = new CommandXboxController(0);

  public RobotContainer() {
    driveSubsystem.setDefaultCommand(new TankDriveCmd(driveSubsystem, () -> controller.getLeftY(), () -> controller.getRightY()));
    configureBindings();
  }

  private void configureBindings() {
    controller.y().whileTrue(new ShootCmd(shooterSubsystem, 1, 0.7, 1)); 
    controller.a().whileTrue(new IntakeCmd(shooterSubsystem, 1, 0.5));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
