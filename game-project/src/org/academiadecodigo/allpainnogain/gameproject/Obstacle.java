package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Obstacle extends Picture {


    public void drawObstacle(int x, int y, String string) {
        Picture picture = new Picture(x, y, string);
        picture.draw();
    }

}
