package neuralearn; 

import brain.Brain;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import tools.STools;

public class Animal {
    public static final double  WIDTH  = 10.0 ,
                                HEIGHT = 10.0 ;
    private Color ANIMAL_COLOR ;
    
    public Cord cord = new Cord(Plane.WIDTH/2,Plane.HEIGHT);
    private Brain brain = new Brain();
    private double score = 0.0;
    
    public Animal(){
        ANIMAL_COLOR = Color.rgb(100, STools.ranIntInclusive(100, 255), STools.ranIntInclusive(100, 255), 1);
        brain.update(new double[]{cord.x,cord.y,Plane.food.getX(),Plane.food.getY()});
        //drawAnimal(ctx);
    }
    
    private void drawAnimal(GraphicsContext ctx){
        ctx.setFill(ANIMAL_COLOR);
        ctx.fillRect(cord.x - WIDTH/2.0, cord.y+HEIGHT/2, WIDTH, HEIGHT);
        
    }
    
    public void drawBrain(GraphicsContext ctx){
        
    }
    
    public void update(GraphicsContext ctx){
        double leapsize = 1;
        
        brain.update(new double[]{cord.x,cord.y,Plane.food.getX(),Plane.food.getY()});
        int move = brain.getOutNum()[0];
        switch(move){
            case (0):
                this.cord.x+=leapsize;
                break;
            case (1):
                this.cord.x-=leapsize;
                break;
            case (2):
                this.cord.y += leapsize;
                break;
            case (3):
                this.cord.y -= leapsize;
                break;
            default:
                throw new RuntimeException("Unexpected!");
        }
        
        drawAnimal(ctx);
    }
    
    

} 