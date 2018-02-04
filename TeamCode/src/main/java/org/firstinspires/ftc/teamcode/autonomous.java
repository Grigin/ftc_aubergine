
package org.firstinspires.ftc.teamcode;

/**
 * Created by grigo on 16-Dec-17.
 */

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "BaklajanBot: Autonomous", group="Baclajan")
public class autonomous extends LinearOpMode {
    hardware robot = new hardware();

    @Override
    public void runOpMode() {
        // Define and Initialize Motors
        robot.init(hardwareMap);

//        robot.leftDrive.setDirection(DcMotor.Direction.REVERSE);
//        robot.secondRightDrive.setDirection(DcMotor.Direction.REVERSE);
//
//        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        rightDrive.setMo de(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        secondLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        secondRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            float hsvValues[] = {0F, 0F, 0F};
            robot.init(hardwareMap);
//        final float values[] = hsvValues;
            // final View relativeLayout = ((Activity)hardwareMap.appContext).findViewById(R.id.RelativeLayout);
            telemetry.addData("Initialization", "Passed");

            int b = 1;
            waitForStart();

            while (opModeIsActive()){
                Color.RGBToHSV(robot.color.red() * 8, robot.color.green() * 8, robot.color.blue() * 8, hsvValues);
                telemetry.addData("RED: ", robot.color.red());
                telemetry.addData("GREEN: ", robot.color.green());
                telemetry.addData("BLUE: ", robot.color.blue());
                telemetry.update();
                        waitForStart();
                         Forward(1);
                            delay(100);
                            Stop();
                            Forward(-1);
                            delay(1000);
                            Stop();
                            Right(1);
                            delay(2000);
                            Left(1);
                            delay(2000);
                            Stop();

            }
        }

    public void decision(){
        if (robot.color.red() > robot.color.blue()){
            Forward(1);

        }
        else {
            Forward(-1);
        }
    }



    public void delay(int del) {
        // Sleep for 1000 ms.
        try {
            Thread.sleep(del);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void Forward(double power) {
        robot.leftDrive.setPower(power);
        robot.rightDrive.setPower(-power);
        robot.secondLeftDrive.setPower(-power);
        robot.secondRightDrive.setPower(power);
    }

    public void Left(double power) {
        robot.leftDrive.setPower(power * -1.0);
        robot.rightDrive.setPower(power * -1.0);
        robot.secondLeftDrive.setPower(power);
        robot.secondRightDrive.setPower(power);
    }


    public void Right(double power) {
        robot.leftDrive.setPower(power);
        robot.rightDrive.setPower(power);
        robot.secondLeftDrive.setPower(power * -1.0);
        robot.secondRightDrive.setPower(power * -1.0);
    }



    public void Stop()
    {
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
        robot.secondLeftDrive.setPower(0);
        robot.secondRightDrive.setPower(0);
    }


}
