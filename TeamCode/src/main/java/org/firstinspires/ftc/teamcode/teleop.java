package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Baclajanbot: Teleop", group="Baclajan")
public class teleop extends LinearOpMode {
     /* Declare OpMode members. */
     hardware robot = new hardware();
     double servoPosition = robot.SERVO_HOME;
     double servoPosition1 = robot.SERVO_HOME_1;
     final double SERVO_SPEED = 0.01;
     final double SERVO_SPEED_1 = 0.01;

     @Override
     public void runOpMode() {
         robot.init(hardwareMap);

         // Send telemetry message to signify robot aing;
         telemetry.addData("Say", "Hello Driver");    //
         telemetry.update();

         waitForStart();

         while (opModeIsActive()) {
//             float LFspeed = gamepad1.left_stick_y - gamepad1.left_stick_x;
//             float LBspeed = gamepad1.left_stick_y + gamepad1.left_stick_x;
//             float RFspeed = gamepad1.left_stick_y + gamepad1.left_stick_x;
//             float RBspeed = gamepad1.left_stick_y - gamepad1.left_stick_x;
//             float Liftspeed = gamepad2.right_stick_y + gamepad2.right_stick_x;

//             float LFspeed = gamepad1.left_stick_x - gamepad1.left_stick_y;
//             float LBspeed = gamepad1.left_stick_x + gamepad1.left_stick_y;
//             float RFspeed = gamepad1.left_stick_x + gamepad1.left_stick_y;
//             float RBspeed = gamepad1.left_stick_x - gamepad1.left_stick_y;
//             float Liftspeed = gamepad2.right_stick_x + gamepad2.right_stick_y;

             float RFspeed = - gamepad1.left_stick_x - gamepad1.left_stick_y;
             float RBspeed = gamepad1.left_stick_x + gamepad1.left_stick_y;
             float LFspeed = - gamepad1.left_stick_x + gamepad1.left_stick_y;
             float LBspeed = gamepad1.left_stick_x - gamepad1.left_stick_y;
             float Liftspeed = gamepad2.right_stick_x + gamepad2.right_stick_y;


             LFspeed = Range.clip(LFspeed, -1, 1);
             LBspeed = Range.clip(LBspeed, -1, 1);
             RFspeed = Range.clip(RFspeed, -1, 1);
             RBspeed = Range.clip(RBspeed, -1, 1);
             Liftspeed = Range.clip(Liftspeed, -1, 1);

             robot.leftDrive.setPower(LFspeed);
             robot.rightDrive.setPower(RFspeed);
             robot.secondLeftDrive.setPower(LBspeed);
             robot.secondRightDrive.setPower(RBspeed);
             robot.lift.setPower(Liftspeed);

             if (gamepad2.a)
                 servoPosition += SERVO_SPEED;

             else if (gamepad2.y)
                 servoPosition -= SERVO_SPEED;


             else if (gamepad2.x)
                 servoPosition1 += SERVO_SPEED_1;

             else if (gamepad2.b)
                 servoPosition1 -= SERVO_SPEED_1;

             servoPosition = Range.clip(servoPosition, robot.SERVO_MIN_RANGE, robot.SERVO_MAX_RANGE);
             servoPosition1 = Range.clip(servoPosition1, robot.SERVO_MIN_RANGE, robot.SERVO_MAX_RANGE);
             robot.claw1.setPosition(servoPosition);
             robot.claw2.setPosition(servoPosition1);


             //            // Send telemetry message to signify robot running;
            telemetry.addData("left",  "%.2f");
           telemetry.addData("right", "%.2f");
           telemetry.addData("second_left",  "%.2f");
           telemetry.addData("second_right", "%.2f");
//
//            telemetry.update();
//        double Speed = 0;
//        double Turn = 0;
//        double Strafe = 0;
//
//        // Wait for the game to start (driver presses PLAY)
//        waitForStart();
//
//        // run until the end of the match (driver presses STOP)
//        while (opModeIsActive()) {
//            Speed = -gamepad1.left_stick_y;
//            Turn = gamepad1.left_stick_x;
//            Strafe = gamepad1.right_stick_x;\
//
//            holonomic(Speed, Turn, Strafe, MAX_SPEED);
//
//            telemetry.update();
//
//            // Pace this loop so jaw action is reasonable speed.
//            sleep(50);
//        }
//    }
//
//
//    public void holonomic(double Speed, double Turn, double Strafe, double MAX_SPEED){
//
//        left = Speed + Turn - Strafe;
//        right = Speed - Turn + Strafe;
//        secondLeft = Speed + Turn + Strafe;
//        secondRight = Speed - Turn - Strafe;
//
//        double Magnitude = abs(Speed) + abs(Turn) + abs(Strafe);
//        Magnitude = (Magnitude > 1) ? Magnitude : 1; //Set scaling to keep -1,+1 range
//
//        robot.leftDrive.setPower(Range.scale((scaleInput(Speed) + scaleInput(Turn) - scaleInput(Strafe)),
//                -Magnitude, +Magnitude, -MAX_SPEED, +MAX_SPEED));
//        if (secondLeft != 0) {
//            robot.secondLeftDrive.setPower(Range.scale((scaleInput(Speed) + scaleInput(Turn) + scaleInput(Strafe)),
//                    -Magnitude, +Magnitude, -MAX_SPEED, +MAX_SPEED));
//        }
//        robot.rightDrive.setPower(Range.scale((scaleInput(Speed) - scaleInput(Turn) + scaleInput(Strafe)),
//                -Magnitude, +Magnitude, -MAX_SPEED, +MAX_SPEED));
//        if (secondRight != 0) {
//            robot.secondRightDrive.setPower(Range.scale((scaleInput(Speed) - scaleInput(Turn) - scaleInput(Strafe)),
//                    -Magnitude, +Magnitude, -MAX_SPEED, +MAX_SPEED));
//        }
//    }
//
//    double scaleInput(double dVal){
//        double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
//                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };
//
//        // get the corresponding index for the scaleInput array.
//        int index = (int) (dVal * 16.0);
//
//        // index should be positive.
//        if (index < 0) {
//            index = -index;
//        }
//
//        // index cannot exceed size of array minus 1.
//        if (index > 16) {
//            index = 16;
//        }
//
//        // get value from the array.
//        double dScale = 0.0;
//        if (dVal < 0) {
//            dScale = -scaleArray[index];
//        } else {
//            dScale = scaleArray[index];
//        }
//
//        // return scaled value.
//        return dScale;
//    }
         }
     }
 }