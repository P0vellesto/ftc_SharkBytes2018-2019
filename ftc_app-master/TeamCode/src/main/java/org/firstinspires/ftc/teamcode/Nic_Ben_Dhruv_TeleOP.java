// IMPORTANT: Left and right joysticks are used to move the robot,
// and a b are used to move the servo.
// You hold a to lift the bucket,
// and you hold be to make it go back.
// The speed the servo turns when held will most
// likely ber changed later after testing.
// This code needs to be debugged.

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Nicholas Tele Op", group="TeleOpmode")
public class Nic_Ben_Dhruv_TeleOP extends LinearOpMode
{
    public DcMotor motorLeft;
    public DcMotor motorRight;
    public Servo armServo;

    @Override
    public void runOpMode() throws InterruptedException
    {
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");

        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        armServo = hardwareMap.servo.get("armServo");

        waitForStart();

        while(opModeIsActive())
        {
            motorLeft.setPower(-gamepad1.left_stick_y);
            motorRight.setPower(-gamepad1.right_stick_y);

            if(gamepad2.a)
            {
                armServo.setPosition(+ 0.01);
            }

            if(gamepad2.b)
            {
                armServo.setPosition(- 0.01);
            }

            idle();
        }
    }
}