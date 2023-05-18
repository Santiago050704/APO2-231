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

    private ArrayList<Level> levels;
    private int currentLevel = 0;

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
        levels = new ArrayList<>();

        //Generar el primer mapa
        Level l1 = new Level(0);
        l1.setColor(Color.BLUE);
        Enemy enemy = new Enemy(new Vector(150,150));
        new Thread(enemy).start();
        l1.getEnemies().add(enemy);
        l1.getEnemies().add(new Enemy(new Vector(400, 100)));
        levels.add(l1);


        //avatar2 = new Avatar();
        levels.get(currentLevel).getEnemies().add(new Enemy(new Vector(10, 10)));
        levels.get(currentLevel).getEnemies().add(new Enemy(new Vector(15, 15)));

        //Generar el segundo mapa
        Level l2 = new Level(1);
        l2.setColor(Color.GRAY);
        l2.getEnemies().add(new Enemy(new Vector(100, 100)));
        l2.getEnemies().add(new Enemy(new Vector(100, 50)));
        l2.getEnemies().add(new Enemy(new Vector(30, 30)));
        levels.add(l2);
        draw();
    }

    private void onMousePressed(MouseEvent mouseEvent) {
        System.out.println("X: " + mouseEvent.getX() + "Y: " + mouseEvent.getY());

        double diffX = mouseEvent.getX() - avatar.pos.getX();
        double diffY = mouseEvent.getY() - avatar.pos.getY();
        Vector diff = new Vector(diffX, diffY);
        diff.normalize();
        diff.setMag(4);

        levels.get(currentLevel).getBullets().add(
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
                Level level = levels.get(currentLevel);

                //Dibujar en el lienzo
                Platform.runLater(()->{
                    //Lo que hagamos aquí, corre en el main thread.

                    gc.setFill(level.getColor());

                    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

                    //gc.setFill(Color.WHITE);

                    //gc.fillOval(0, 0, canvas.getWidth(), canvas.getHeight());

                    avatar.draw(gc);
                    //avatar2.draw2(gc);

                    for(int i = 0; i < level.getBullets().size(); i++){
                        level.getBullets().get(i).draw(gc);
                        if(isOutside(level.getBullets().get(i).pos.getX(), level.getBullets().get(i).pos.getY())){
                            level.getBullets().remove(i); //Se remueve la bala cuando sale de la pantalla.
                        }
                    }

                    for(int i = 0; i < level.getEnemies().size(); i++){
                        level.getEnemies().get(i).draw(gc);
                    }
                    System.out.println(level.getBullets().size());
                });

                //Cálculos geométricos. Debería estar en el avatar

                //Paredes
                if(avatar.pos.getX() < 0){
                    avatar.pos.setX(25);
                }
                if(avatar.pos.getY() > canvas.getHeight() - 50){
                    avatar.pos.setY(canvas.getHeight() - 50);
                }
                if(avatar.pos.getY() < 0){
                    currentLevel = 1;
                    avatar.pos.setY(canvas.getHeight());
                }

                //Colisiones
                for(int i = 0; i < level.getBullets().size(); i++){
                    Bullet bn = level.getBullets().get(i);
                    for(int j = 0; j < level.getEnemies().size(); j++){
                        Enemy en = level.getEnemies().get(j);

                        double distance = Math.sqrt(
                                Math.pow(en.pos.getX()-bn.pos.getX(), 2) +
                                        Math.pow(en.pos.getY()-bn.pos.getY(), 2)
                        );

                        if(distance < 5){
                            level.getBullets().remove(i);
                            level.getEnemies().remove(j);

                        }
                    }
                }


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