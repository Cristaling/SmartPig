package me.cristaling.GenAI.Neural;

import java.util.ArrayList;
import java.util.List;

public class NeuronLayer {

	List<Neuron> neurons = new ArrayList<Neuron>();
	List<Double> outputs = new ArrayList<Double>();
	
	int weightNumber;
	
	public NeuronLayer(int neuronNr, int inputNr){
		for(int i=1;i<=neuronNr;i++){
			neurons.add(new Neuron(inputNr));
		}
		weightNumber = inputNr * neuronNr;
	}
	
	public int getWeightNumber(){
		return weightNumber;
	}
	
	public void setWeights(List<Double> newWeights){
		int index = 0;
		for(Neuron neuron:neurons){
			List<Double> newWeightsN = new ArrayList<Double>();
			int weightNr = neuron.getWeights().size();
			for(int i=1;i<=weightNr;i++){
				newWeightsN.add(newWeights.get(index));
				index++;
			}
			neuron.setWeights(newWeightsN);
		}
	}
	
	public List<Double> getWeights(){
		List<Double> result = new ArrayList<Double>();
		for(Neuron neuron:neurons){
			for(double weight:neuron.getWeights()){
				result.add(weight);
			}
		}
		return result;
	}
	
	public void setInputs(List<Double> newInputs){
		outputs = new ArrayList<Double>();
		for(Neuron neuron:neurons){
			neuron.setInputs(newInputs);
			outputs.add(neuron.getOutput());
		}
	}
	
	public List<Double> getOutputs(){
		return outputs;
	}
	
}
