package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.constants.TurretConstants;

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
        // this should do something.
    }

    public void operateTurret(Gamepad gamepad2){
        double rawPower = gamepad2.left_stick_x;
        if (Math.abs(rawPower)>Constants.TRIGGER_TOLERANCE){
            setRawPower(rawPower);
        }

        boolean sp0 = gamepad2.dpad_down;
        boolean sp1 = gamepad2.dpad_left;
        boolean sp2 = gamepad2.dpad_up;
        boolean sp3 = gamepad2.dpad_right;
        // i doubt i'll keep many of these. probably one to reset to normal 0 position, and the others are
        // auto-aligned towards the basket.
        if (sp0){
            goToPosition(TurretConstants.SETPOINT_0);
        }
        if (sp1){
            // in the future: autotarget left depot
            goToPosition(TurretConstants.SETPOINT_1);
        }
        if (sp2){
            goToPosition(TurretConstants.SETPOINT_2);
        }
        if (sp3){
            // in the future autotarget right depot (near ftuure, hopefully)
            goToPosition(TurretConstants.SETPOINT_3);
        }
    }

}
