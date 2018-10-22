/*
DO NOT UNCOMMENT THIS CODE IS NOT GONNA BE USED
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class FlyNTeleOp extends LinearOpMode {

    public DcMotor motorLeft;
    public DcMotor motorRight;
    public Servo armServo;

    public FlyNTeleOp() {

        @Override
        public void runOpMode() {
            motorLeft = hardwareMap.dcMotor.get("motorLeft");
            motorRight = hardwareMap.dcMotor.get("motorRight");

            motorLeft.setDirection(DcMotor.Direction.REVERSE);

            armServo = hardwareMap.servo.get("armServo");
            waitForStart();

            while (opModeIsActive()) {
                motorLeft.setPower(-gamepad1.left_stick_y);
                motorRight.setPower(-gamepad1.right_stick_y);

                if (gamepad2.a) {
                    armServo.setPosition(+0.01);
                }

                if (gamepad2.b) {
                    armServo.setPosition(-0.01);
                }

                idle();

            }
        }
    }
}
*/