package main;

import lejos.hardware.Button;


import java.util.concurrent.CountDownLatch;

public class Main {

	private static EV3Helper ev3Helper = new EV3Helper();
	private static SampleSet sampleSet = new SampleSet(ev3Helper);
	private static RobotState robotState = new RobotState();
	private static GameField gameField = new GameField();
	

	public static void main(String[] args) throws InterruptedException {
		ev3Helper.playBeep();
		System.out.println("startup complete.\n\nClick any button to fight");
		Button.waitForAnyPress();
		ev3Helper.playBeep();

		Thread.sleep(3000);

		Thread mt = new Thread(new MotorThread(robotState, ev3Helper));
		Thread st = new Thread(new SensorThread(robotState, ev3Helper, sampleSet));
		Thread ct = new Thread(new ControlThread(robotState, sampleSet));

		mt.start();
		st.start();
		ct.start();

		robotState.latch = new CountDownLatch(3);

		ev3Helper.playBeep();

		System.out.println("\nPress any key to stop motors and finish program");

		while (robotState.shouldRun) {
			Button.waitForAnyPress();
			ev3Helper.playBeep();
			robotState.shouldRun = false;
		}

		robotState.latch.await();

		ev3Helper.playBeep();
		System.out.println("Bye!");

		System.exit(0);

	}
}
