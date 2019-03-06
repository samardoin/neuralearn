package neuralearn; 

import brain.Brain;
import brain.Neuron;
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
    
    private void drawCir(GraphicsContext ctx,double x, double y, double size, double value){
        if (value < -1.0) value = -1.0;
        else if (value > 1.0) value = 1.0;
        double min = -1.0, max = 1.0;
        //System.out.println("value:" + value);
        value += 1;
        min = 0.0; max = 2.0;
        double colorMax = 765;
        
        value *= colorMax;
        value /= max;
        
        double r,g,b;
        r = g = b = 0.0;
        if (value > 255*2){
            r = value - 255*2;
        }
        else if (value > 255){
            g = value - 255;
        }
        else {
            if (value >= 0) b = value;
        }
        
        
        
        
        ctx.setFill(Color.BLACK);
        ctx.fillOval(x, y, size, size);
        //System.out.println("r:" + ((int)r) + "\tg:" + ((int)g) + "\tb:"+(int)b);
        ctx.setFill(Color.rgb((int)r,(int) g, (int)b));
        //ctx.setFill(Color.AQUA);
        ctx.fillOval(x+1, y+1, size-2, size-2);
    }
    public void drawBrain(GraphicsContext ctx){
        double circleRad = Math.PI;
        double brainx = 10, brainy=10, brainSize=30;
        
        //draw inputs
        for (int i = 0; i < Brain.INPUT_LENGTH;i++){
            drawCir(ctx,brainx, brainy, brainSize, brain.getinput(i));
            brainy+=brainSize;
        }
        brainy-=Brain.INPUT_LENGTH*brainSize;
        brainx+=brainSize*2;
        
        //draw mid
        for (int i = 0; i < Brain.MID_LAYERS; i++){
            for (int j = 0; j < Brain.MID_LENGTH;j++){
                drawCir(ctx,brainx, brainy, brainSize,brain.getmiddle(i, j));
                brainy+=brainSize;
            }
            brainy-=Brain.MID_LENGTH*brainSize;
            brainx+=brainSize*2;
        }
        
        //draw out
        for (int i = 0; i < Brain.OUTPUT_LENGTH;i++){
            drawCir(ctx,brainx, brainy, brainSize,brain.getoutput(i));
            brainy+=brainSize;
        }
        
    }
    
    public void update(GraphicsContext ctx){
        double leapsize = 1;
        
        brain.update(new double[]{cord.x/Neuralearn.CANVAS_WIDTH,cord.y/Neuralearn.CANVAS_HEIGHT,Plane.food.getX()/Neuralearn.CANVAS_WIDTH,Plane.food.getY()/Neuralearn.CANVAS_HEIGHT});
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
                //throw new RuntimeException("Unexpected!");
        }
        
        drawAnimal(ctx);
    }
    
    

} 