package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase{

    private  CANSparkMax shooterMotor1 = new CANSparkMax(2, MotorType.kBrushed);
    private  CANSparkMax shooterMotor2 = new CANSparkMax(3, MotorType.kBrushed);

    public ShooterSubsystem() {
        shooterMotor2.setInverted(true);
        shooterMotor1.setInverted(true);
    }

    @Override
    public void periodic() {}

    public void setShooterMotors(double speed1, double speed2) {
        shooterMotor1.set(speed1);
        shooterMotor2.set(speed2);
    }
}
