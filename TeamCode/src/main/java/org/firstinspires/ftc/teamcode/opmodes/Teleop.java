package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Superstructure;

@TeleOp(name="16760 Teleop")
public class Teleop extends LinearOpMode {
    private Superstructure struct;

    public void runOpMode(){
        //initialize
        this.struct = new Superstructure(hardwareMap, telemetry);

        waitForStart();

        //start

        while (opModeIsActive()){
            //loop
            //drive teleop
            this.struct.drive.teleopDrive(gamepad1);

            // other player controls:
            this.struct.intake.operateIntake(gamepad2);

        }
    }
}
