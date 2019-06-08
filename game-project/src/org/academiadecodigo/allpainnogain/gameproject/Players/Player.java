package org.academiadecodigo.allpainnogain.gameproject.Players;

import org.academiadecodigo.allpainnogain.gameproject.Tank;

abstract public class Player{

    private String name;
    private Tank tank;

    public Player(String name, Tank tank){
        this.name = name;
        this.tank = tank;
    }

    public boolean hasTank(){
        return !tank.isDestroyed();
    }


}
