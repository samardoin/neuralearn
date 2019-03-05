package brain; 

public class Neuron {
    private Synapse[] prevSynapses;
    private double correct = 0.0;
    private boolean isStart = false;
    private double value = 0.0;
    private boolean isUpdated = false;
    
    public Neuron(){}
    
    public double getValue(){
        if (!isUpdated)
            throw new RuntimeException("Error:Neuron must be updated to get value.");
        return value;
    }
    
    public void setNewStartNeuron(double newValue){
        isStart = true;
        value = newValue;
        isUpdated = true;
    }
    
    public void setViaPrevNeuron(Neuron[] prevNeurons){
        isStart = false;
        correct = 0.0;
        prevSynapses = new Synapse[prevNeurons.length];
        for (int i = 0; i < prevSynapses.length;i++){
            prevSynapses[i].reset(prevNeurons[i]);
        }
    }
    
    public void update(){
        if (isStart)
            throw new RuntimeException ("Error:You cannot update a start neuron!");
        double rawVal = 0.0;
        for (Synapse prevSynapse : prevSynapses) {
            rawVal += prevSynapse.getValue();
        }
        rawVal+=correct;
        rawVal = mush(rawVal);
        this.value=rawVal;
        this.isUpdated=true;
    }
    
    private double mush(double val){
        return val;
    }
    

} 