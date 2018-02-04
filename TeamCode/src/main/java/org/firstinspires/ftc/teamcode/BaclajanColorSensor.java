//package org.firstinspires.ftc.teamcode;
//
//import android.graphics.Color;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//
//@Autonomous(name = "Baclajan: ColorSensor", group = "Baclajan")
//public class BaclajanColorSensor extends LinearOpMode{
//    hardware robot = new hardware();
//
//    @Override
//    public void runOpMode(){
//        float hsvValues[] = {0F, 0F, 0F};
//        robot.init(hardwareMap);
////        final float values[] = hsvValues;
//       // final View relativeLayout = ((Activity)hardwareMap.appContext).findViewById(R.id.RelativeLayout);
//        telemetry.addData("Initialization", "Passed");
//
//        int b = 1;
//        waitForStart();
//
//        while (opModeIsActive()){
//            Color.RGBToHSV(robot.color.red() * 8, robot.color.green() * 8, robot.color.blue() * 8, hsvValues);
//            telemetry.addData("RED: ", robot.color.red());
//            telemetry.addData("GREEN: ", robot.color.green());
//            telemetry.addData("BLUE: ", robot.color.blue());
//            telemetry.update();
//        }
//    }
//
//    public void decision(){
//        if (robot.color.red() > robot.color.blue()){
//            Forward(1);
//
//        }
//        else {
//            Forward(-1);
//        }
//    }
//}A