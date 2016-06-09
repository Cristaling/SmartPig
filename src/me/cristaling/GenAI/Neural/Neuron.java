package me.cristaling.GenAI.Neural;

import java.util.ArrayList;
import java.util.List;

import me.cristaling.GenAI.NeuralManager;

public class Neuron {

	List<Double> weights = new ArrayList<Double>();
	List<Double> inputs;

	double output;

	public Neuron(int inputNr) {
		for (int i = 0; i <= inputNr; i++) {
			weights.add(NeuralManager.getRandomWeight());
		}
	}

	public void setWeights(List<Double> newWeights) {
		weights = newWeights;
	}

	public List<Double> getWeights() {
		return weights;
	}

	public void setInputs(List<Double> newInputs) {
		inputs = newInputs;
		calculateOutput();
	}

	public void calculateOutput() {
		double sum = 0;
		int num = 0;
		for (double input : inputs) {
			sum += input * weights.get(num);
			num++;
		}
		sum += weights.get(num);
		output = NeuralManager.getSignoid(sum);
	}

	public double getOutput() {
		return output;
	}

}
