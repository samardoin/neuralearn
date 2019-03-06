package neuralearn; 

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import tools.STools;

public class Plane {
    public static final double  WIDTH  = Neuralearn.CANVAS_WIDTH ,
                                HEIGHT = Neuralearn.CANVAS_HEIGHT;
    public static Food food = new Food();
    public Animal[] animals;
    private GraphicsContext ctx;
    
    public Plane(GraphicsContext ctx){
        this.ctx = ctx;
        int animalsAmt = 200;
        animals = new Animal[animalsAmt];
        for (int i = 0 ; i < animalsAmt; i++){
            animals[i] = new Animal();
            animals[i].cord.set(Neuralearn.CANVAS_WIDTH/2.0,Neuralearn.CANVAS_HEIGHT/2.0);
        }
        
    }
    
    public void update(){
        ctx.setFill(Color.GHOSTWHITE);
        ctx.fillRect(0, 0, Neuralearn.CANVAS_WIDTH, Neuralearn.CANVAS_HEIGHT);
        int j = 0;
        for (Animal animal : animals){           
            animal.update(ctx);
            //System.out.println("A:" + ++j);
            
        }
    }
    
    

} 