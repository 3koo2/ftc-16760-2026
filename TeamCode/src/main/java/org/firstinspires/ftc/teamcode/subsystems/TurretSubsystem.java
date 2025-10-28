package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;

public class TurretSubsystem {
    private DcMotor turret;
    public TurretSubsystem(HardwareMap hwmap, Telemetry tele){
        this.turret = hwmap.get(DcMotor.class, Constants.MOTOR_NAME_TURRET);
    }

    public void setRawPower(double power){
        this.turret.setPower(power);
    }

    public int getTurretPosition(){
        return this.turret.getCurrentPosition();
    }

    public void getTurretPositionInSpace(){
        //define later (field-centric, maybe idk)
    }

    public void goToPosition(int position){
        // something with pid, maybe. or not, idk.

    }

}
