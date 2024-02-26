package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class TankDriveCmd extends Command{

    private final DriveSubsystem driveSubsystem;
    private final Supplier<Double> leftFunction, rightFunction;

    public TankDriveCmd(DriveSubsystem driveSubsystem, Supplier<Double> leftFunction, Supplier<Double> rightFunction) {
        this.driveSubsystem = driveSubsystem;
        this.leftFunction = leftFunction;
        this.rightFunction = rightFunction;
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        double left = leftFunction.get() * -0.3;
        double right = rightFunction.get() * -0.3;
        driveSubsystem.setMotors(left, right);
    }

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return false;
    }
}
