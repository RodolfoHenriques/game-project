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
        /*Rectangle battleFieldRectangle = new Rectangle(MARGIN,MARGIN,WIDTH,HEIGHT);
        battleFieldRectangle.setColor(Color.DARK_GRAY);
        battleFieldRectangle.fill();*/

        Picture battleFieldRectangle = new Picture(0, 0, "arena1.png");
        battleFieldRectangle.draw();


        Obstacle obstacle1 = new Obstacle(150, 150, "fiveTrees.png");
        obstacle1.drawObstacle();

        Obstacle obstacle2 = new Obstacle(333, 300, "nineTrees.png");
        obstacle2.drawObstacle();

        Obstacle obstacle3 = new Obstacle(WIDTH - 380, HEIGHT - 200, "fiveTrees.png");
        obstacle3.drawObstacle();

        Obstacle obstacle4 = new Obstacle(WIDTH - 383, 150, "nineTrees.png");
        obstacle4.drawObstacle();

        Obstacle obstacle5 = new Obstacle(WIDTH / 2 - 115, HEIGHT / 2 - 25, "fiveTrees.png");
        obstacle5.drawObstacle();

        Obstacle obstacle6 = new Obstacle(128 + MARGIN, HEIGHT - 150, "rock.png");
        obstacle6.drawObstacle();

        Obstacle obstacle7 = new Obstacle(WIDTH - 202 + MARGIN, 100, "rock.png");
        obstacle7.drawObstacle();

        Obstacle obstacle8 = new Obstacle(WIDTH / 2 - 37, 175, "rock.png");
        obstacle8.drawObstacle();

        Obstacle obstacle9 = new Obstacle(WIDTH / 2 - 37, HEIGHT - 225, "rock.png");
        obstacle9.drawObstacle();


    }

}
