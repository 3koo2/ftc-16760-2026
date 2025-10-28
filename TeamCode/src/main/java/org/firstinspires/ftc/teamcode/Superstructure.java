package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.TurretSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

public class Superstructure{
    public TurretSubsystem turret;
    public IntakeSubsystem intake;
    public DriveSubsystem drive;
    public Superstructure(HardwareMap hwmap){
        this.turret = new TurretSubsystem(hwmap);
        this.intake = new IntakeSubsystem(hwmap);
        this.drive = new DriveSubsystem(hwmap);
    }
}