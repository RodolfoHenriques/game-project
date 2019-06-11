package org.academiadecodigo.allpainnogain.gameproject.Players;


import org.academiadecodigo.allpainnogain.gameproject.Game;
import org.academiadecodigo.allpainnogain.gameproject.Tank;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class Player1 extends Player {

    private Tank tank;

    public Player1(String name, Tank tank) {
        super(name, tank);
        this.tank = tank;

    }

    public void moveTank() {
        tank.moveTank();
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

        KeyboardEvent fire = new KeyboardEvent();
        fire.setKey(KeyboardEvent.KEY_1);
        fire.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


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

        KeyboardEvent shootRelease = new KeyboardEvent ();
        shootRelease.setKey (KeyboardEvent.KEY_1);
        shootRelease.setKeyboardEventType (KeyboardEventType.KEY_RELEASED);


        keyboard.addEventListener (up);
        keyboard.addEventListener (down);
        keyboard.addEventListener (right);
        keyboard.addEventListener (left);
        keyboard.addEventListener (fire);


        keyboard.addEventListener (upRelease);
        keyboard.addEventListener (downRelease);
        keyboard.addEventListener (rightRelease);
        keyboard.addEventListener (leftRelease);
        keyboard.addEventListener (shootRelease);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_W:
                tank.setDirection(0);
                isUp = true;
                break;
            case KeyboardEvent.KEY_S:
                tank.setDirection(1);
                isDown = true;
                break;
            case KeyboardEvent.KEY_D:
                tank.setDirection(2);
                isRight = true;
                break;
            case KeyboardEvent.KEY_A:
                tank.setDirection(3);
                isLeft = true;
                break;
            case KeyboardEvent.KEY_1:
                break;


        }

        super.keyPressed (keyboardEvent);
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey ()) {
            case KeyboardEvent.KEY_W:
                tank.setDirection(0);
                isUp = false;
                break;
            case KeyboardEvent.KEY_S:
                tank.setDirection(1);
                isDown = false;
                break;

            case KeyboardEvent.KEY_D:
                tank.setDirection(2);
                isRight = false;
                break;

            case KeyboardEvent.KEY_A:
                tank.setDirection(3);
                isLeft = false;
                break;
            case KeyboardEvent.KEY_1:
                shoot ();
                break;

        }

    }
}