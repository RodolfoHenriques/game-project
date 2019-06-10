package org.academiadecodigo.allpainnogain.gameproject.Players;

import org.academiadecodigo.allpainnogain.gameproject.Tank;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

abstract public class Player implements KeyboardHandler {

    private String name;  // receive input player
    private Tank tank;
    protected Keyboard keyboard;
    protected boolean isUp;
    protected boolean isDown;
    protected boolean isLeft;
    protected boolean isRight;



    public Player(String name, Tank tank) {
        this.name = name;
        this.tank = tank;
        keyboard = new Keyboard(this);
        initKeyboard();
    }

    public boolean hasTank() {
        return !tank.isDestroyed();
    }


    public abstract void initKeyboard();



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (isRight && isUp || isRight && isDown || isLeft && isUp || isLeft && isDown) {

            if (isRight && isUp) {
                tank.setDirection(4);
            }
            if (isRight && isDown) {
                tank.setDirection(6);
            }
            if (isLeft && isUp) {
                tank.setDirection(5);
            }
            if (isLeft && isDown) {
                tank.setDirection(7);
            }
            return;
        }

    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
    public void shoot(){
        this.tank.shoot();
    }

    public Tank getTank() {
        return tank;
    }
}