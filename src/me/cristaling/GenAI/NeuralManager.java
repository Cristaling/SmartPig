package me.cristaling.GenAI;

import java.util.Random;

public class NeuralManager {

	static Random random = new Random();

	public static double getRandomWeight() {
		return random.nextDouble() * 2 - 1;
	}

	public static double getSignoid(double a) {
		return 1 / (1 + Math.pow(Math.E, a));
	}

}
