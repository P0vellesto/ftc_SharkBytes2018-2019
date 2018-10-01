package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@TeleOp(name = "Tele")
public class Nick_Tele_Op extends LinearOpMode
{

    @Override
    public void runopmode() throws InterruptedException
    {


        waitForStart();

        while(opModeIsActive())
        {

            idle();
        }
    }
}