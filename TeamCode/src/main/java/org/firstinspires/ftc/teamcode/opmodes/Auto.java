package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Superstructure;

@Autonomous(name = "16760 Auto")
public class Auto extends LinearOpMode {
    private Superstructure superstructure;

    enum AutoStates{
        READ_TAG,
        LINE_UP_FIRST_SHOTS,
        FIRST_SHOOT,
        LINE_UP_INTAKE,
        INTAKE_LINE,
        POSITION_FOR_SHOOT,
        SECOND_SHOOT,
        END
    }

    AutoStates state;
    double obeliskID = 0;

    @Override
    public void runOpMode() {
        this.superstructure = new Superstructure(hardwareMap, telemetry);
        state = AutoStates.READ_TAG;

        waitForStart();

        while (opModeIsActive()){
            switch (state) {
                case READ_TAG:
                    double read = superstructure.limelightSubsystem.getTagId();
                    if (read != 0){
                        obeliskID = read;
                        state = AutoStates.FIRST_SHOOT;
                    }
                case FIRST_SHOOT:
                    //TODO: Shoot out the starting balls
                case LINE_UP_FIRST_SHOTS:
                    //TODO: Line up to shoot the starting balls
                case INTAKE_LINE:
                    //TODO: Go to the line of the obelisk (setpoint?)
                //TODO: Intake the line
                //
            }
        }
    }
}
