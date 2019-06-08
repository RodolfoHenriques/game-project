package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class BattleField {

    public static final int MARGIN = 40;
    public static final int WIDTH = 1840;
    public static final int HEIGHT = 940;

    // default constructor


    public void init(){
        Rectangle battleFieldRectangle = new Rectangle(MARGIN,MARGIN,WIDTH,HEIGHT);
        battleFieldRectangle.setColor(new Color(255,0,0));
        battleFieldRectangle.fill();
    }

}
