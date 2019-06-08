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
    private boolean keyPressed;

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

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        keyPressed = true;

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                tank.setDirection(0);
                break;
            case KeyboardEvent.KEY_DOWN:
                tank.setDirection(1);
                break;
            case KeyboardEvent.KEY_RIGHT:
                tank.setDirection(2);
                break;
            case KeyboardEvent.KEY_LEFT:
                tank.setDirection(3);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        keyPressed = false;
    }

    public boolean isKeyPressed() {
        return keyPressed;
    }
}