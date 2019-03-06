package brain; 

import tools.STools;

public class Synapse {
    public static final double  MUL_MIN = -1.0 , 
                                MUL_MAX = 1.0 ;
    
    
    private double mul=1.0;
    private Neuron prevNeuron;
    
    public void setPrevNeuron(Neuron prev){
        prevNeuron = prev;
    }
    public void setMul (double mul){this.mul = mul;}
    public void setRanMul(){
        mul = STools.ranDobInclusive(MUL_MIN, MUL_MAX);
    }
    
    public void reset(Neuron prev){
        setPrevNeuron(prev);
        setRanMul();
    }
    
    public double getValue(){
        return mul*prevNeuron.getValue();
    }

} 