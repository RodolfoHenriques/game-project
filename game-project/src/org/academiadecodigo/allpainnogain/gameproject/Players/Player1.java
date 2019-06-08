package org.academiadecodigo.allpainnogain.gameproject.Players;


import org.academiadecodigo.allpainnogain.gameproject.Tank;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public class Player1 extends Player {

    private Tank tank;


    public Player1(String name, Tank tank) {
        super(name, tank);
        this.tank = tank;

    }

    public void moveTank() {
        tank.moveTank();
    }



}