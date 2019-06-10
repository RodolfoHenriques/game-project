package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class BattleField {

    public static final int MARGIN = 0;
    public static final int WIDTH = 1365;
    public static final int HEIGHT = 708;


    public void init() {

        Rectangle battleFieldRectangle = new Rectangle(MARGIN, MARGIN, WIDTH, HEIGHT);
        battleFieldRectangle.setColor(new Color(131, 0, 0));
        battleFieldRectangle.fill();

        Obstacle obstacle1 = new Obstacle();
        obstacle1.drawObstacle(150, 150, "fiveTrees.png");

        Obstacle obstacle2 = new Obstacle();
        obstacle2.drawObstacle(333, 300, "nineTrees.png");

        Obstacle obstacle3 = new Obstacle();
        obstacle3.drawObstacle(WIDTH - 380, HEIGHT - 200, "fiveTrees.png");

        Obstacle obstacle4 = new Obstacle();
        obstacle4.drawObstacle(WIDTH - 383, 150, "nineTrees.png");

        Obstacle obstacle5 = new Obstacle();
        obstacle5.drawObstacle(WIDTH / 2 - 115, HEIGHT / 2 - 25, "fiveTrees.png");

        Obstacle obstacle6 = new Obstacle();
        obstacle6.drawObstacle(128 + MARGIN, HEIGHT - 150, "rock.png");

        Obstacle obstacle7 = new Obstacle();
        obstacle7.drawObstacle(WIDTH - 202 + MARGIN, 100, "rock.png");

        Obstacle obstacle8 = new Obstacle();
        obstacle8.drawObstacle(WIDTH / 2 - 37, 175, "rock.png");

        Obstacle obstacle9 = new Obstacle();
        obstacle9.drawObstacle(WIDTH / 2 - 37, HEIGHT - 225, "rock.png");
    }
}
