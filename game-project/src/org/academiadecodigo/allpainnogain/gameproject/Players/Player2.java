package org.academiadecodigo.allpainnogain.gameproject.Players;

import org.academiadecodigo.allpainnogain.gameproject.Sound;
import org.academiadecodigo.allpainnogain.gameproject.Tank;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class Player2 extends Player {

    private Tank tank;

    public Player2(String name, Tank tank) {
        super(name, tank);
        this.tank = tank;
    }

    public void moveTank() {
        tank.moveTank();
    }

    @Override
    public void initKeyboard() {

        int[] keys = new int[]{KeyboardEvent.KEY_UP, KeyboardEvent.KEY_DOWN, KeyboardEvent.KEY_RIGHT, KeyboardEvent.KEY_LEFT,
                KeyboardEvent.KEY_B, KeyboardEvent.KEY_N, KeyboardEvent.KEY_M};

        for (int key : keys) {
            KeyboardEvent event = new KeyboardEvent();
            event.setKey(key);
            event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(event);

            KeyboardEvent eventRelease = new KeyboardEvent();
            eventRelease.setKey(key);
            eventRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            keyboard.addEventListener(eventRelease);
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
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
        super.keyPressed(keyboardEvent);
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                isUp = false;
                break;
            case KeyboardEvent.KEY_DOWN:
                isDown = false;
                break;

            case KeyboardEvent.KEY_RIGHT:
                isRight = false;
                break;

            case KeyboardEvent.KEY_LEFT:
                isLeft = false;
                break;
            case KeyboardEvent.KEY_B:
                shoot1();
                sound2.play(true);
                break;
            case KeyboardEvent.KEY_N:
                shoot2();
                sound1.play(true);
                break;
            case KeyboardEvent.KEY_M:
                shoot3();
                sound3.play(true);
                break;
        }
    }
}

