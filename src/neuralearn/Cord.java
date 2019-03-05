package neuralearn; 

public class Cord {
    public double x,y;
    public Cord(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Cord(double x){
        this (x, 0.0);
    }
    public Cord(){
        this(0.0,0.0);
    }
    public void set (double x, double y){
        this.x = x;
        this.y = y;
    }
} 