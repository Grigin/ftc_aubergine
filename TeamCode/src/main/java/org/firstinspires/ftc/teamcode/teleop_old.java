//package org.firstinspires.ftc.teamcode;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//
//
//@TeleOp(name="Pushbot: Teleop POV", group="Pushbot")
//public class teleop extends LinearOpMode {
//
//    /* Declare OpMode members. */
//    hardware robot           = new hardware();   // Use a Pushbot's hardware
//    // could also use HardwarePushbotMatrix class.
//
//    @Override
//    public void runOpMode() {
//        double left;
//        double right;
//        double drive;
//        double turn;
//        double max;
//
//        /* Initialize the hardware variables.
//         * The init() method of the hardware class does all the work here
//         */
//        robot.init(hardwareMap);
//
//        // Send telemetry message to signify robot waiting;
//        telemetry.addData("Say", "Hello Driver");    //
//        telemetry.update();
//
//        // Wait for the game to start (driver presses PLAY)
//        waitForStart();
//
//        // run until the end of the match (driver presses STOP)
//        while (opModeIsActive()) {
//
//            // Run wheels in POV mode (note: The joystick goes negative when pushed forwards, so negate it)
//            // In this mode the Left stick moves the robot fwd and back, the Right stick turns left and right.
//            // This way it's also easy to just drive straight, or just turn.
//            drive = -gamepad1.left_stick_y;
//            turn  =  gamepad1.right_stick_x;
//
//            // Combine drive and turn for blended motion.
//            left  = drive + turn;
//            right = drive - turn;
//
//            // Normalize the values so neither exceed +/- 1.0
//            max = Math.max(Math.abs(left), Math.abs(right));
//            if (max > 1.0)
//            {
//                left /= max;
//                right /= max;
//            }
//
//            // Output the safe vales to the motor drives.
//            robot.leftDrive.setPower(left);
//            robot.rightDrive.setPower(right);
//            robot.secondLeftDrive.setPower(left);
//            robot.secondRightDrive.setPower(right);
//
//            // Send telemetry message to signify robot running;
//            telemetry.addData("left",  "%.2f", left);
//            telemetry.addData("right", "%.2f", right);
//            telemetry.addData("second_left",  "%.2f", left);
//            telemetry.addData("second_right", "%.2f", right);
//
//            telemetry.update();
//
//            // Pace this loop so jaw action is reasonable speed.
//            sleep(50);
//        }
//    }
//}
