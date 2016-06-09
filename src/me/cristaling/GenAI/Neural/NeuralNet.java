package me.cristaling.GenAI.Neural;

import java.util.ArrayList;
import java.util.List;

public class NeuralNet {

	List<NeuronLayer> layers = new ArrayList<NeuronLayer>();
	List<Double> outputs = new ArrayList<Double>();
	
	public NeuralNet(int inputNr, int outputNr, int hiddenNr, int hiddenSize) {
		layers.add(new NeuronLayer(inputNr, hiddenSize));
		for(int i=1;i<=hiddenNr;i++){
			layers.add(new NeuronLayer(hiddenNr, hiddenNr));
		}
		layers.add(new NeuronLayer(hiddenNr, outputNr));
	}
	
	public void setWeights(List<Double> newWeights){
		int index = 0;
		for(NeuronLayer neuronLayer:layers){
			List<Double> newWeightsL = new ArrayList<Double>();
			int weightNr = neuronLayer.getWeightNumber();
			for(int i=1;i<=weightNr;i++){
				newWeightsL.add(newWeights.get(index));
				index++;
			}
			neuronLayer.setWeights(newWeightsL);
		}
	}
	
	public List<Double> getWeights(){
		List<Double> result = new ArrayList<Double>();
		for(NeuronLayer neuronLayer:layers){
			List<Double> layerWeights = neuronLayer.getWeights();
			for(double weight:layerWeights){
				result.add(weight);
			}
		}
		return result;
	}
	
	public void setInputs(List<Double> newInputs){
		List<Double> result = null;
		for(NeuronLayer neuronLayer:layers){
			if(result == null){
				neuronLayer.setInputs(newInputs);
			}else{
				neuronLayer.setInputs(result);
			}
			result = neuronLayer.getOutputs();
		}
		outputs = result;
	}
	
	public List<Double> getOutputs(){
		return outputs;
	}
	
}
