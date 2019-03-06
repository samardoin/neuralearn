package brain; 

public class Brain {
    public static final int INPUT_LENGTH = 4;
    public static final int OUTPUT_LENGTH = 4;
    public static final int MID_LENGTH = 4;
    public static final int MID_LAYERS = 2;
    
    private Neuron[] inputs = new Neuron[OUTPUT_LENGTH];
    private Neuron[][] middles = new Neuron[MID_LAYERS][MID_LENGTH];
    private Neuron[] outputs = new Neuron[INPUT_LENGTH];
    
    public Brain(){
        //set inputs
        for (int i = 0 ; i < inputs.length;i++) {
            inputs[i] = new Neuron();
            inputs[i].setNewStartNeuron(0);
        }
        
        //set first middle layer
        for (int i = 0 ; i < middles[0].length;i++) {
            middles[0][i] = new Neuron();
            middles[0][i].setViaPrevNeuron(inputs);
        }
        //set non-first middle layers
        for (int i = 1; i < middles.length;i++){
            for (int j = 0; j < middles[i].length;j++){
                middles[i][j] = new Neuron();
                middles[i][j].setViaPrevNeuron(middles[i-1]);
            }
        }
        //set outputs
        for (int i = 0 ; i < outputs.length;i++){
            outputs[i] = new Neuron();
            outputs[i].setViaPrevNeuron(middles[middles.length-1]);
        }
        
        
    }
    public Neuron[] test(){
        return this.inputs;
    }
    

    public void update(double[] newInputs){
        if (newInputs.length != INPUT_LENGTH)
            throw new RuntimeException ("Error: newInputs.length != INPUT_LENGTH!");
        //refresh init node values
        for (int i = 0 ; i < newInputs.length;i++){
            inputs[i].setNewStartNeuron(newInputs[i]);
        }
        
        //refresh middle node values
        for (Neuron[] middle : middles) {
            for (Neuron middle2 : middle){
                middle2.update();
            }
        }
        
        //refresh output values
        for (Neuron output : outputs){
                output.update();
        }
        
    }
    public double[] getOutVal(){
        double[] result = new double[OUTPUT_LENGTH];
        
        for (int i = 0; i < result.length; i++){
            result[i] = outputs[i].getValue();
        }
        
        return result;
    }
    
    public int[] getOutNum(){//TODO optimize!!!
        int result[];
        int ssize=1;
        int fp = 0;
        double large = outputs[0].getValue();
        for (int i = 1; i < outputs.length;i++){
            if (outputs[i].getValue() > large){
                large = outputs[i].getValue();
                ssize = 1;
                fp = i;
            }
            else if (outputs[i].getValue() == large){
                ssize++;
            }
        }
        //return new int[]{fp};
        result = new int[ssize];
        int place = 0;
        for (int i = 0; i < outputs.length;i++){
            if (outputs[i].getValue()==large){
                result[place] = i;
                place++;
            }
        }
        //System.out.println("place+1:" + (result.length) + "\tssize:" + ssize);
        //if (place+1 != ssize) throw new RuntimeException("Error:Brain:getOutNum:" + place);
        if (result.length != ssize) throw new RuntimeException("Error:Brain:getOutNum:" + place);
        
        return result;
    }

} 