package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveSubsystem {
    private DcMotor front_left;
    private DcMotor front_right;
    private DcMotor back_left;
    private DcMotor back_right;

    public DriveSubsystem(HardwareMap hwmap){
        this.front_left = hwmap.get(DcMotor.class, "fl");
        this.front_right = hwmap.get(DcMotor.class, "fr");
        this.back_left = hwmap.get(DcMotor.class, "bl");
        this.back_right = hwmap.get(DcMotor.class, "br");

        this.front_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.front_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.back_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.back_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void set(double fl, double fr, double bl, double br){
        this.front_left.setPower(fl);
        this.front_right.setPower(fr);
        this.back_left.setPower(bl);
        this.back_right.setPower(br);
    }

    public void teleopDrive(Gamepad gamepad1){
        //copied from template mecanum drive
        // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
        double axial   = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
        double lateral =  gamepad1.left_stick_x;
        double yaw     =  gamepad1.right_stick_x;

        // Combine the joystick requests for each axis-motion to determine each wheel's power.
        // Set up a variable for each drive wheel to save the power level for telemetry.
        double frontLeftPower  = axial + lateral + yaw;
        double frontRightPower = axial - lateral - yaw;
        double backLeftPower   = axial - lateral + yaw;
        double backRightPower  = axial + lateral - yaw;

        double max = Math.max(Math.abs(frontLeftPower), Math.abs(frontRightPower));
        max = Math.max(max, Math.abs(backLeftPower));
        max = Math.max(max, Math.abs(backRightPower));

        if (max > 1.0) {
            frontLeftPower  /= max;
            frontRightPower /= max;
            backLeftPower   /= max;
            backRightPower  /= max;
        }

        this.set(frontLeftPower, frontRightPower, backLeftPower, backRightPower);
    }

}
