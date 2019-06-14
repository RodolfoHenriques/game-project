package org.academiadecodigo.allpainnogain.gameproject.Players;

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
        int[] keys = new int[]{KeyboardEvent.KEY_E, KeyboardEvent.KEY_D, KeyboardEvent.KEY_F, KeyboardEvent.KEY_S,
                KeyboardEvent.KEY_1, KeyboardEvent.KEY_2, KeyboardEvent.KEY_3};
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
            case KeyboardEvent.KEY_E:
                tank.setDirection(0);
                isUp = true;
                setQwerty(true);
                break;
            case KeyboardEvent.KEY_D:
                tank.setDirection(1);
                isDown = true;
                setQwerty(true);
                break;
            case KeyboardEvent.KEY_F:
                tank.setDirection(2);
                isRight = true;
                setQwerty(true);
                break;
            case KeyboardEvent.KEY_S:
                tank.setDirection(3);
                isLeft = true;
                setQwerty(true);
                break;
        }

        super.keyPressed(keyboardEvent);
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_E:
                isUp = false;
                break;
            case KeyboardEvent.KEY_D:
                isDown = false;
                break;
            case KeyboardEvent.KEY_F:
                isRight = false;
                break;
            case KeyboardEvent.KEY_S:
                isLeft = false;
                break;
            case KeyboardEvent.KEY_1:
                shoot1();
                sound1.play(true);
                break;
            case KeyboardEvent.KEY_2:
                shoot2();
                sound3.play(true);
                break;
            case KeyboardEvent.KEY_3:
                shoot3();
                sound2.play(true);
                break;

        }
    }

}