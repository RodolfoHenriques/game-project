package org.academiadecodigo.allpainnogain.gameproject.Players;

import org.academiadecodigo.allpainnogain.gameproject.Tank;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

abstract public class Player implements KeyboardHandler {

    private String name;  // receive input player
    private Tank tank;
    private Keyboard keyboard;
    private boolean isUp;
    private boolean isDown;
    private boolean isLeft;
    private boolean isRight;

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
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        KeyboardEvent upRelease = new KeyboardEvent();
        upRelease.setKey(KeyboardEvent.KEY_UP);
        upRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent downRelease = new KeyboardEvent();
        downRelease.setKey(KeyboardEvent.KEY_DOWN);
        downRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent rightRelease = new KeyboardEvent();
        rightRelease.setKey(KeyboardEvent.KEY_RIGHT);
        rightRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent leftRelease = new KeyboardEvent();
        leftRelease.setKey(KeyboardEvent.KEY_LEFT);
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
        } else {

            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_UP:
                    tank.setDirection(0);
                    isUp = true;   
                    break;
                case KeyboardEvent.KEY_DOWN:
                    tank.setDirection(1);
                    isDown = true;
                    break;
                case KeyboardEvent.KEY_RIGHT:
                    tank.setDirection(2);
                    isRight = true;
                    break;
                case KeyboardEvent.KEY_LEFT:
                    tank.setDirection(3);
                    isLeft = true;
                    break;
            }
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
              //  tank.setDirection(0);
                isUp = false;
                break;
            case KeyboardEvent.KEY_DOWN:
                //tank.setDirection(1);
                isDown = false;
                break;

            case KeyboardEvent.KEY_RIGHT:
                //tank.setDirection(2);
                isRight = false;
                break;

            case KeyboardEvent.KEY_LEFT:
                //tank.setDirection(3);
                isLeft = false;
                break;


        }
    }
}