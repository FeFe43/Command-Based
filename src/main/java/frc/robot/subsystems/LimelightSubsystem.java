package frc.robot.subsystems;

import edu.wpi.first.networktables.DoubleSubscriber;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimelightSubsystem extends SubsystemBase{

    private NetworkTableInstance instance = NetworkTableInstance.getDefault();
    private NetworkTable table = instance.getTable("limelight");

    private DoubleSubscriber tx = table.getDoubleTopic("tx").subscribe(0);
    private DoubleSubscriber ty = table.getDoubleTopic("ty").subscribe(0);
    private DoubleSubscriber ta = table.getDoubleTopic("ta").subscribe(0);
    private DoubleSubscriber tz = table.getDoubleTopic("tz").subscribe(0);
    private DoubleSubscriber tv = table.getDoubleTopic("tv").subscribe(0);

    public LimelightSubsystem() {}

    public void periodic() {}

    public double getX() {
        return table.getEntry("tx").getDouble(0);
    }

    public double getY() {
        return table.getEntry("tx").getDouble(0);
    }

    public boolean tagFound() {
        return table.getEntry("tv").getBoolean(false);
    }
}
