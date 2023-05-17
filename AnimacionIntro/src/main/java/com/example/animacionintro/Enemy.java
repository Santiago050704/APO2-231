package com.example.animacionintro;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Enemy extends Drawing{

    public Enemy(Vector pos){
        this.pos = pos;
    }
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.YELLOW);
        gc.fillRect(pos.getX(), pos.getY(), 10, 10);
        gc.strokeRect(pos.getX(), pos.getY(), 10, 10);
    }
}
