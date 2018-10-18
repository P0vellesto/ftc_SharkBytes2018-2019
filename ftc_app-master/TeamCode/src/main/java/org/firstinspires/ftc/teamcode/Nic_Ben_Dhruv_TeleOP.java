// IMPORTANT: Left and right joysticks are used to move the robot,
// and a b are used to move the servo.
// You hold a to lift the bucket,
// and you hold be to make it go back.
// The speed the servo turns when held will most
// likely ber changed later after testing.
// This code needs to be debugged.
// commit buffer, ignore this line

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Nicholas Tele Op", group="TeleOpmode")
public class Nic_Ben_Dhruv_TeleOP extends LinearOpMode
{
    public DcMotor mDrv_l; //Left motor
    public DcMotor mDrv_r; //Right motor
    public Servo sArm_0; //Arm servo that lifts bucket with silver and gold

    @Override
    //@Disabled
    public void runOpMode() throws InterruptedException
    {
        mDrv_l = hardwareMap.dcMotor.get("mDrv_l");
        mDrv_r = hardwareMap.dcMotor.get("mDrv_r");

        mDrv_l.setDirection(DcMotor.Direction.REVERSE); //Most robots have one motor backwards

        sArm_0 = hardwareMap.servo.get("armServo");

        waitForStart();

        while(opModeIsActive())
        {
            mDrv_l.setPower(-gamepad1.left_stick_y);
            mDrv_r.setPower(-gamepad1.right_stick_y);

            if(gamepad2.a)
            {
                sArm_0.setPosition(+ 0.01);
            }

            if(gamepad2.b)
            {
                sArm_0.setPosition(- 0.01);
            }

            idle();
        }
    }
}