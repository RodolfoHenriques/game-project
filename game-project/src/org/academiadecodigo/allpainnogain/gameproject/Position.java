package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

    private int x;
    private int y;
    private Rectangle tankRectangle;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
        tankRectangle = new Rectangle(x,y,20,20); //Test
        tankRectangle.fill();                              //Test
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rectangle getTankRectangle() {
        return tankRectangle;
    }
}

