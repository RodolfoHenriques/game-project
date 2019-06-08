package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class BattleField {

    private final int MARGIN = 40;
    private final int WIDTH = 1840;
    private final int HEIGHT = 940;

    // default constructor


    public void init(){
        Rectangle battleFieldRectangle = new Rectangle(MARGIN,MARGIN,WIDTH,HEIGHT);
        battleFieldRectangle.setColor(new Color(255,0,0));
        battleFieldRectangle.fill();
    }






}
