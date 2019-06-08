package org.academiadecodigo.allpainnogain.gameproject;

public class Tank {

    private int health;
    private int speed;
    private Position tankPosition;
    private boolean destroyed;

    public Tank(Position tankPosition) {
        this.tankPosition = tankPosition;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}
