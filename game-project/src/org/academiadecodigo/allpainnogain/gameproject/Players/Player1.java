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
        }
        super.keyPressed(keyboardEvent);
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_W:
                //  tank.setDirection(0);
                isUp = false;
                break;
            case KeyboardEvent.KEY_S:
                //tank.setDirection(1);
                isDown = false;
                break;

            case KeyboardEvent.KEY_D:
                //tank.setDirection(2);
                isRight = false;
                break;

            case KeyboardEvent.KEY_A:
                //tank.setDirection(3);
                isLeft = false;
                break;


        }
    }
}