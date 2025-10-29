package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcontroller.external.samples.UtilityOctoQuadConfigMenu;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.LauncherSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.LimelightSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.TurretSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

public class Superstructure{
    public TurretSubsystem turret;
    public IntakeSubsystem intake;
    public DriveSubsystem drive;
    public LauncherSubsystem launcher;
    public LimelightSubsystem limelightSubsystem;
    public Follower pedro;

    private Telemetry telemetry;
    public Superstructure(HardwareMap hwmap, Telemetry tele){
        this.telemetry = tele;

        this.turret = new TurretSubsystem(hwmap, tele);
        this.intake = new IntakeSubsystem(hwmap, tele);
        this.drive = new DriveSubsystem(hwmap, tele);
        this.launcher = new LauncherSubsystem(hwmap, tele);
        this.limelightSubsystem = new LimelightSubsystem(hwmap, tele);
        this.pedro = Constants.createFollower(hwmap);
    }
}