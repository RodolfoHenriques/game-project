package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BattleField {

    public static final int MARGIN = 60;
    public static final int WIDTH = 1246;
    public static final int HEIGHT = 648;


    public void init() {

        Picture battleFieldRectangle = new Picture(0, 0, "/Resources/arena1.png");
        battleFieldRectangle.draw();


        Obstacle obstacle1 = new Obstacle(WIDTH / 8, HEIGHT / 4, "/Resources/fiveTrees.png");
        obstacle1.drawObstacle();

        Obstacle obstacle2 = new Obstacle(WIDTH / 4, HEIGHT / 2, "/Resources/nineTrees.png");
        obstacle2.drawObstacle();

        Obstacle obstacle3 = new Obstacle(WIDTH - WIDTH / 5, HEIGHT - HEIGHT / 5 + 20, "/Resourcesfive/Trees.png");
        obstacle3.drawObstacle();

        Obstacle obstacle4 = new Obstacle(WIDTH - WIDTH / 6 - 20, HEIGHT / 5, "/Resources/nineTrees.png");
        obstacle4.drawObstacle();


        Goat goat1 = new Goat(WIDTH / 2 + 25, HEIGHT / 4, "/Resources/goat.png");
        goat1.drawObstacle();

        Goat goat2 = new Goat(WIDTH / 2 + 25, HEIGHT + 30 - HEIGHT / 6, "/Resources/goat.png");
        goat2.drawObstacle();

        Obstacle obstacle8 = new Obstacle(WIDTH / 7 - 25, HEIGHT - HEIGHT / 7 - 20, "/Resources/rock.png");
        obstacle8.drawObstacle();

        Obstacle obstacle9 = new Obstacle(WIDTH - WIDTH / 12, HEIGHT / 4, "/Resources/rock.png");
        obstacle9.drawObstacle();

    }
}
