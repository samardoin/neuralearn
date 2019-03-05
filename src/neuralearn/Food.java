package neuralearn; 

public class Food {
    public static final int WIDTH = 10, HEIGHT = 10;
    
    private Cord cord = new Cord(10.0,20.0);
    
    public Cord getCord(){
        return cord;
    }
    
    public double getX(){
        return cord.x;
    }
    
    public double getY(){
        return cord.y;
    }
    

} 