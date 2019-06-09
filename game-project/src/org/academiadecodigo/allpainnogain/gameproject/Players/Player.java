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


    public void initKeyboard() {

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_W);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_A);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_D);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_S);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        KeyboardEvent upRelease = new KeyboardEvent();
        upRelease.setKey(KeyboardEvent.KEY_W);
        upRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent downRelease = new KeyboardEvent();
        downRelease.setKey(KeyboardEvent.KEY_S);
        downRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent rightRelease = new KeyboardEvent();
        rightRelease.setKey(KeyboardEvent.KEY_D);
        rightRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent leftRelease = new KeyboardEvent();
        leftRelease.setKey(KeyboardEvent.KEY_A);
        leftRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);


        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(right);
        keyboard.addEventListener(left);

        keyboard.addEventListener(upRelease);
        keyboard.addEventListener(downRelease);
        keyboard.addEventListener(rightRelease);
        keyboard.addEventListener(leftRelease);


    }



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
}