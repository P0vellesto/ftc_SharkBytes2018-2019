/*
 * This started on 10/1/2018 by Albert H, following a swerve robotics tutorial:
 * https://www.youtube.com/watch?annotation_id=annotation_2218718323&feature=iv&src_vid=sAZ2yJfJj4Q&v=OT_PGYIFBGE (to get the base)
 * https://www.youtube.com/watch?v=kOapppDNlSA (actual tutorial)
 */


package org.firstinspires.ftc.teamcode;
//https://www.youtube.com/watch?annotation_id=annotation_2218718323&feature=iv&src_vid=sAZ2yJfJj4Q&v=OT_PGYIFBGE

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//our vars
double turnModifier = 1; //This used to modify turning from degrees to power, used in auto.turn


@Autonomous(name="FirstAuto");
public class Auto extends LinearOpMode
{

    //declare hardware
        //declare motors (drive)
        public DcMotor mDrv_l; //will change from null to the actual names when we get phones working (-alb, 10/1/2018)
        public DcMotor mDrv_r;

        //declare motors (intake)
        public DcMotor mItk_l;
        public DcMotor mItk_r;

        //declare servos (arm)
        public Servo   sArm_0;

    //motor methods
    public void drive(double power, double time) throws InterruptedException
    { //set the power of both motors, allowing a drive forwards, backwards, and also a stop
        mDrv_l.setPower(power);
        mDrv_r.setPower(power);
        Thread.sleep(time);
    }

    public void turnPower(double power, double time) throws InterruptedException
    { //goes right
        mDrv_l.setPower(power);
        mDrv_r.setPower(power);
        Thread.sleep(time);
    }

    public void turn(double degrees, double power) throws InterruptedException //need to throw that because Thread.sleep sometimes throws that exception
    { //degrees to the right. for left, use a negative number
        if (power == null) { //set power to full unless we specificly need a gentle turn
            power = 1;
        }
        turnPower(power); //start turning
        Thread.sleep(degrees * turnModifier * 1/power); //we multiply by power because if the power is lower then the bot will be turning slower so we need to wait longer
        turnPower(0); //stop turning
    }

    @Override
    public void runOpMode() throws InterruptedException
    {
        //same as the declarations above but in the method
        //drive motors
        this.mDrv_l = this.hardwareMap.dcMotor.get("mDrv_l");
        this.mDrv_r = this.hardwareMap.dcMotor.get("mDrv_r");
        //etc etc (-alb, 10/1/2018)

        waitForStart();

        drive(10, 1);

    }

}
