package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.constants.LauncherConstants;

public class LauncherSubsystem {
    private DcMotorEx flywheel;
    private DcMotorEx aim;
    private int aimSetpoint = 0;

    private double flywheelVelocity = 0;

    public LauncherSubsystem(HardwareMap hwmap, Telemetry t){
        this.flywheel = hwmap.get(DcMotorEx.class, Constants.MOTOR_NAME_FLYWHEEL);
        this.aim = hwmap.get(DcMotorEx.class, Constants.MOTOR_NAME_AIM);

        this.flywheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        this.aim.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void aimLauncher(int setpoint){
        // use PID
        this.aimSetpoint = 0;
    }

    public void goToAim(){
        //use pid controller
    }

    public void enableFlywheel(double velocity){
        this.flywheelVelocity = velocity;
    }

    public void stopFlywheel(){
        this.flywheelVelocity = 0;
    }

    public void moveFlywheel(){
        // do something with motor and PID maybe?
    }

    public void controlLauncher(Gamepad gamepad2){

        //controls
        boolean sp0 = gamepad2.dpad_down;
        boolean sp1 = gamepad2.dpad_up;

        if (sp0){
            aimLauncher(LauncherConstants.SETPOINT_0);
        }
        if (sp1){
            aimLauncher(LauncherConstants.SETPOINT_1);
        }
        int speed = 10;
        double factor = gamepad2.right_stick_y;

        aimLauncher(this.aimSetpoint - (int)(factor*speed));

        // do stuff:
        moveFlywheel();
        goToAim();
    }
}
