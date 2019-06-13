package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BattleField {

    public static final int MARGIN = 60;
    public static final int WIDTH = 1246;
    public static final int HEIGHT = 648;

    // default constructor


    public void init() {

        Picture battleFieldRectangle = new Picture(0, 0, "arena1.png");
        battleFieldRectangle.draw();


        Obstacle obstacle1 = new Obstacle(WIDTH/8, HEIGHT/4, "fiveTrees.png");
        obstacle1.drawObstacle();

        Obstacle obstacle2 = new Obstacle(WIDTH/4, HEIGHT/2, "nineTrees.png");
        obstacle2.drawObstacle();

        Obstacle obstacle3 = new Obstacle(WIDTH - WIDTH/5, HEIGHT - HEIGHT/5+20, "fiveTrees.png");
        obstacle3.drawObstacle();

        Obstacle obstacle4 = new Obstacle(WIDTH-WIDTH/6-20, HEIGHT/5, "nineTrees.png");
        obstacle4.drawObstacle();


        Goat goat1 = new Goat(WIDTH/2+25, HEIGHT/4, "goat.png");
        goat1.drawObstacle();

        Goat goat2 = new Goat(WIDTH/2 +25, HEIGHT-HEIGHT/6, "goat.png");
        goat2.drawObstacle();

        Obstacle obstacle8 = new Obstacle(WIDTH/7 - 25, HEIGHT-HEIGHT/7-20, "rock.png");
        obstacle8.drawObstacle();

        Obstacle obstacle9 = new Obstacle(WIDTH - WIDTH/12, HEIGHT /4, "rock.png");
        obstacle9.drawObstacle();


    }

}
