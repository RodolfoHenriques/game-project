package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Obstacle extends Collidable{

    private int x;
    private int y;
    private String pictureName;
    private Picture picture;



    public Obstacle(int x, int y, String pictureName){
        this.x = x;
        this.y = y;
        this.pictureName = pictureName;
        listObstacles.add(this);

    }


    public void drawObstacle() {
        picture = new Picture(x, y, pictureName);
        picture.draw();
    }

    @Override
    int getX() {
        return x;
    }

    @Override
    int getY() {
        return y;
    }

    @Override
    int getWidth() {
        return picture.getWidth();
    }

    @Override
    int getHeight() {
        return picture.getHeight();
    }

}
