package frc.robot.commands;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class IntakeCmd extends Command{

    private final ShooterSubsystem shooterSubsystem;
    private final double speed;
    private final SlewRateLimiter filter;

    public IntakeCmd(ShooterSubsystem shooterSubsystem, double speed, double limit) {
        this.shooterSubsystem = shooterSubsystem;
        this.speed = -speed;
        this.filter = new SlewRateLimiter(limit);
        addRequirements(shooterSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        shooterSubsystem.setShooterMotors(filter.calculate(speed), filter.calculate(speed));
    }
    @Override
    public void end(boolean interrupted) {
        shooterSubsystem.setShooterMotors(0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
