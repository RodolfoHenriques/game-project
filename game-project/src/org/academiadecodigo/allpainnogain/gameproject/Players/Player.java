package org.academiadecodigo.allpainnogain.gameproject.Players;

import org.academiadecodigo.allpainnogain.gameproject.Sound;
import org.academiadecodigo.allpainnogain.gameproject.Tank;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

abstract public class Player implements KeyboardHandler {

    private String name;
    private Tank tank;
    protected Keyboard keyboard;
    protected boolean isUp;
    protected boolean isDown;
    protected boolean isLeft;
    protected boolean isRight;
    protected Sound sound1;
    protected Sound sound2;
    protected Sound sound3;


    public Player(String name, Tank tank) {
        this.name = name;
        this.tank = tank;
        sound1 = new Sound("/VOLUME_sound2.wav");
        sound2 = new Sound("/VOLUME_sound3.wav");
        sound3 = new Sound("/VOLUME_sound5.wav");
        keyboard = new Keyboard(this);
        initKeyboard();
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
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    public void shoot1() {
        this.tank.shoot1();
    }

    public void shoot2() {
        this.tank.shoot2();
    }

    public void shoot3() {
        this.tank.shoot3();
    }

    public void setTankHealth(int health){
        tank.setNewHealth(health);
    }

    public void setTankPosition(int x, int y, String file){
        tank.setNewPosition(x, y, file);
    }
}