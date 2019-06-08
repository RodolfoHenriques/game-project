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
}
