package frc.robot.commands;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootCmd extends Command{

    private final ShooterSubsystem shooterSubsystem;
    private final double speed;
    private final SlewRateLimiter filter;
    private int counter = 0;
    private int target = 0;


    public ShootCmd(ShooterSubsystem shooterSubsystem, double speed, double filter, double seconds) {
        this.shooterSubsystem = shooterSubsystem;
        this.speed = speed;
        this.filter = new SlewRateLimiter(filter);
        target = (int) (seconds * 50);
        addRequirements(shooterSubsystem);
    }

    @Override
    public void initialize() {
        counter = 0;

    }

    @Override
    public void execute() {
        counter++;
        if (counter < target) {
            shooterSubsystem.setShooterMotors(filter.calculate(speed), 0);
        } else if (counter >= target) {
            shooterSubsystem.setShooterMotors(filter.calculate(speed), filter.calculate(speed));
        } 
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
