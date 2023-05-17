package com.example.animacionintro;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/*import javafx.fxml.FXML;
import javafx.scene.control.Label;*/

public class HelloController implements Initializable {
    @FXML
    private Canvas canvas;
    private GraphicsContext gc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        /*System.out.println("Inicia hilo");
        Thread h = new Thread(
                ()->{
                    int counter = 0;
                    for(int i = 0; i < 10; i++){
                        try{
                            Thread.sleep(1000);
                        }catch (Exception e){e.printStackTrace();}
                        counter++;
                        System.out.println(counter);
                    }
                    System.out.println("Alfa");
                }
        );
        h.start();

        Thread j = new Thread(
                ()->{
                    char counter = 64;
                    for(int i = 0; i < 20; i++) {
                        try {
                            Thread.sleep(500);
                        } catch (Exception e) {e.printStackTrace();}
                        counter++;
                        System.out.println(counter);
                    }
                }
        );
        j.start();*/

        gc = canvas.getGraphicsContext2D();
        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(this::onKeyPressed);
        canvas.setOnKeyReleased(this::onKeyReleased);
        canvas.setOnMousePressed(this::onMousePressed);
        avatar = new Avatar();
        //avatar2 = new Avatar();
        enemies.add(new Enemy(new Vector(10, 10)));
        enemies.add(new Enemy(new Vector(15, 15)));
        draw();
    }

    private void onMousePressed(MouseEvent mouseEvent) {
        System.out.println("X: " + mouseEvent.getX() + "Y: " + mouseEvent.getY());

        double diffX = mouseEvent.getX() - avatar.pos.getX();
        double diffY = mouseEvent.getY() - avatar.pos.getY();
        Vector diff = new Vector(diffX, diffY);
        diff.normalize();
        diff.setMag(4);

        bullets.add(
                //new Bullet(new Vector(mouseEvent.getX(), mouseEvent.getY()))
                new Bullet(
                        new Vector(avatar.pos.getX()+25, avatar.pos.getY()+25),
                        diff
                )
        );
    }

    //private int x = 100, y = 100;
    private boolean isAlive = true;
    private boolean Apressed = false;
    private boolean Wpressed = false;
    private boolean Spressed = false;
    private boolean Dpressed = false;

    /*private boolean rightPressed = false;
    private boolean leftPressed = false;
    private boolean upPressed = false;
    private boolean downPressed = false;*/



    private Avatar avatar;
    //private Avatar avatar2;

    private ArrayList<Bullet> bullets = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();


    public void onKeyReleased(KeyEvent event){
        switch (event.getCode()){
            case W: Wpressed = false; break;
            case A: Apressed = false; break;
            case S: Spressed = false; break;
            case D: Dpressed = false; break;
            /*case RIGHT: rightPressed = false; break;
            case LEFT: leftPressed = false; break;
            case UP: upPressed = false; break;
            case DOWN: downPressed = false; break;*/
        }
    }
    /*private boolean isMovingToRight = true;
    private boolean isMovingToBottom = true;*/

    public void onKeyPressed(KeyEvent event){
        System.out.println(event.getCode());
        switch (event.getCode()){
            case W: Wpressed = true; break;
            case A: Apressed = true; break;
            case S: Spressed = true; break;
            case D: Dpressed = true; break;
            /*case RIGHT: rightPressed = true; break;
            case LEFT: leftPressed = true; break;
            case UP: upPressed = true; break;
            case DOWN: downPressed = true; break;*/
        }
    }
    public void draw(){
        Thread ae = new Thread(()->{
            while(isAlive){

                //Dibujar en el lienzo
                Platform.runLater(()->{
                    //Lo que hagamos aquí, corre en el main thread.
                    gc.setFill(Color.BLUE);

                    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

                    //gc.setFill(Color.WHITE);

                    //gc.fillOval(0, 0, canvas.getWidth(), canvas.getHeight());

                    avatar.draw(gc);
                    //avatar2.draw2(gc);

                    for(int i = 0; i < bullets.size(); i++){
                        bullets.get(i).draw(gc);
                        if(isOutside(bullets.get(i).pos.getX(), bullets.get(i).pos.getY())){
                            bullets.remove(i); //Se remueve la bala cuando sale de la pantalla.
                        }
                    }

                    for(int i = 0; i < enemies.size(); i++){
                        enemies.get(i).draw(gc);
                    }
                    System.out.println(bullets.size());
                });

                //Cálculos geométricos. Debería estar en el avatar


                if(Wpressed){
                    avatar.pos.setY(avatar.pos.getY()-3);
                }
                if(Apressed){
                    avatar.pos.setX(avatar.pos.getX()-3);
                }
                if(Spressed){
                    avatar.pos.setY(avatar.pos.getY()+3);
                }
                if(Dpressed){
                    avatar.pos.setX(avatar.pos.getX()+3);
                }

                /*if(rightPressed){
                    avatar2.w+=3;
                }
                if(leftPressed){
                    avatar2.w-=3;
                }
                if(upPressed){
                    avatar2.z-=3;
                }
                if(downPressed){
                    avatar2.z+=3;
                }*/

                /*if(x>canvas.getWidth()-100){
                    isMovingToRight = false;
                }
                if(x<0){
                    isMovingToRight = true;
                }
                if(y>canvas.getWidth()-100){
                    isMovingToBottom = false;
                }
                if(y<0){
                    isMovingToBottom = true;
                }

                if(isMovingToRight){
                    x++;
                }else{
                    x--;
                }

                if(isMovingToBottom){
                    y += 2;
                }else{
                    y -= 2;
                }*/


                try{
                    Thread.sleep(16);
                }catch (InterruptedException e){e.printStackTrace();}
            }
        });
        ae.start();
    }

    public boolean isOutside(double x, double y){
        return x<0 || y<0 || x>canvas.getWidth() || y>canvas.getHeight();
    }


}