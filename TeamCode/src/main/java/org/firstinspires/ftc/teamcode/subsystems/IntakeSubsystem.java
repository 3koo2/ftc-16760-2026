package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.subsystems.constants.IntakeConstants;

import java.security.PrivateKey;

public class IntakeSubsystem {
    private DcMotor intakeMotor;
    private Servo door0;
    private Servo door1;
    private Servo door2;

    public enum Door{
        DOOR0,
        DOOR1,
        DOOR2
    };

    public IntakeSubsystem(HardwareMap hwmap){
        this.intakeMotor = hwmap.get(DcMotor.class, "intake");
        this.door0 = hwmap.get(Servo.class, "door0");
        this.door1 = hwmap.get(Servo.class, "door1");
        this.door2 = hwmap.get(Servo.class, "door2");

        this.intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void closeAllDoors(){
        this.door0.setPosition(IntakeConstants.DOOR_0_CLOSED);
        this.door1.setPosition(IntakeConstants.DOOR_1_CLOSED);
        this.door2.setPosition(IntakeConstants.DOOR_2_CLOSED);
    }

    public void openDoor(Door door){
       switch (door){
           case DOOR0:
               this.door0.setPosition(IntakeConstants.DOOR_0_OPEN);
               break;
           case DOOR1:
               this.door1.setPosition(IntakeConstants.DOOR_1_OPEN);
               break;
           case DOOR2:
               this.door2.setPosition(IntakeConstants.DOOR_2_OPEN);
               break;
           default:
               // ....?
       }
    }

    public void closeDoor(Door door){
        switch (door){
            case DOOR0:
                this.door0.setPosition(IntakeConstants.DOOR_0_CLOSED);
                break;
            case DOOR1:
                this.door1.setPosition(IntakeConstants.DOOR_1_CLOSED);
                break;
            case DOOR2:
                this.door2.setPosition(IntakeConstants.DOOR_2_CLOSED);
                break;
            default:
                // ....?
        }
    }
}
