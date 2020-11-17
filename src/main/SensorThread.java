package main;



public class SensorThread implements Runnable {

	private RobotState robotState;
	private EV3Helper ev3Helper;
	private SampleSet sampleSet;

	public SensorThread(RobotState robotState, EV3Helper ev3Helper, SampleSet sampleSet) {
		this.robotState = robotState;
		this.ev3Helper = ev3Helper;
		this.sampleSet = sampleSet;
	}

	@Override
	public void run() {
		while(robotState.shouldRun) {
			sampleSet.takeSamples();
		}
		robotState.latch.countDown();
	}
}
