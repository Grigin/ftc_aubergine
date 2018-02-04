package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class hardware
{
    /* Public OpMode members. */
    public DcMotor leftDrive   = null;
    public DcMotor rightDrive  = null;
    public DcMotor secondLeftDrive = null;
    public DcMotor secondRightDrive = null;
    public DcMotor lift = null;
    public Servo claw1 = null;
    public Servo claw2 = null;
//    public Servo stick = null;
    public ColorSensor color = null;

    public final static double SERVO_HOME = 0.0;
    public final static double SERVO_HOME_1 = 0.0;
    public final static double SERVO_MIN_RANGE = -1.0;
    public final static double SERVO_MAX_RANGE = 1.0;

    /* Local OpMode members. */
    HardwareMap hwMap  = null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public hardware() {
    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // save reference to HW Map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftDrive  = hwMap.get(DcMotor.class, "left_drive");
        rightDrive = hwMap.get(DcMotor.class, "right_drive");
        secondLeftDrive = hwMap.get(DcMotor.class, "second_left_drive");
        secondRightDrive = hwMap.get(DcMotor.class, "second_right_drive");
        lift = hwMap.get(DcMotor.class,"lift");
        claw1 = hwMap.servo.get("claw1");
        claw1.setPosition(SERVO_HOME);
        claw2 = hwMap.servo.get("claw2");
        claw2.setPosition(SERVO_HOME_1);
        color = hwMap.colorSensor.get("sensorColor");

        //stick = hwMap.servo.get("stick");
        //stick.setPosition(SERVO_HOME);

        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        //secondLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        //secondRightDrive.setDirection(DcMotor.Direction.REVERSE);

        // Set all motors to zero power
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        secondLeftDrive.setPower(0);
        secondRightDrive.setPower(0);
        lift.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
}
