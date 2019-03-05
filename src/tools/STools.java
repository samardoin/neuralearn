package tools; 

import java.util.Random;

public class STools {
    public static int ranIntInclusive(int min, int max){
        Random r = new Random();
	return r.nextInt((max - min) + 1) + min;
    }
    
    public static double ranDobInclusive(double min, double max){
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }
    

} 