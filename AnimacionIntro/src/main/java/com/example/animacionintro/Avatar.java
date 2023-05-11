package com.example.animacionintro;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class Avatar extends Drawing{

    public Avatar(){
        x=100;
        y=100;

        w=50;
        z=50;
    }
    @Override
    public void draw(GraphicsContext gc){
        gc.setFill(Color.rgb(255, 0, 0));
        gc.fillOval(x, y, 50, 50);
    }

    @Override
    public void draw2(GraphicsContext gc){
        gc.setFill(Color.WHITE);
        gc.fillRect(w, z, 50, 50);
    }
}
