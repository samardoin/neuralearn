package neuralearn;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Neuralearn extends Application{
    public static final double  WINDOW_WIDTH  = 800, 
                                WINDOW_HEIGHT = 600, 
                                CANVAS_WIDTH  = WINDOW_WIDTH, 
                                CANVAS_HEIGHT = WINDOW_HEIGHT - 22;
    public static Color bg_color = Color.GHOSTWHITE;

    private Canvas canvas;
    private GraphicsContext ctx;
    
    private Plane plane;
    
    boolean stageOpen = true;
    @Override
    public void start(Stage primaryStage){
        BorderPane borderPane = new BorderPane();

        canvas = new Canvas(CANVAS_WIDTH,CANVAS_HEIGHT);
        ctx = canvas.getGraphicsContext2D();

        borderPane.setCenter(canvas);

        Scene scene = new Scene(borderPane);

        primaryStage.setScene(scene);
        primaryStage.setWidth(WINDOW_WIDTH);
        primaryStage.setHeight(WINDOW_HEIGHT);
        //primaryStage.setResizable(false);

        ctx.setFill(bg_color);
        ctx.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              stageOpen=false;
          }
        });
        
        plane = new Plane(ctx);
        primaryStage.show();
        
        
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                plane.update();
            }
        };
        timer.start();
        
        System.out.println("out");
        //plane.update();
        
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
