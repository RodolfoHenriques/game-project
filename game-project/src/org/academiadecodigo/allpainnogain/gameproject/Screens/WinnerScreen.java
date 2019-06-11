package org.academiadecodigo.allpainnogain.gameproject.Screens;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class WinnerScreen implements KeyboardHandler {

    private Keyboard keyboard;
    private Picture pictureWinnerScreen = new Picture(0, 0, "poop2.png");


    //change values of rectangle
    private Rectangle selectTryAgain = new Rectangle(80, 50, 305, 120);
    private Rectangle selectExit = new Rectangle(80, 185, 305, 120);

    private boolean rectangleTryAgain = true;
    private boolean rectangleExit;

    private boolean space;
    private boolean hasWinnerScreen;

    public WinnerScreen() {

        keyboard = new Keyboard(this);
        initKeyboard();
    }

    public void createWinnerScreen() {

        pictureWinnerScreen.draw();
        selectTryAgain.draw();
        hasWinnerScreen = true;
    }


    public void deleteWinnerScreen() {

        pictureWinnerScreen.delete();
        selectExit.delete();
        selectTryAgain.delete();
    }


    public void initKeyboard() {

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(space);
    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:
                selectExit.delete();
                selectTryAgain.draw();

                rectangleTryAgain = true;
                rectangleExit = false;

                break;

            case KeyboardEvent.KEY_DOWN:
                selectTryAgain.delete();
                selectExit.draw();

                rectangleExit = true;
                rectangleTryAgain = false;

                break;

            case KeyboardEvent.KEY_SPACE:
                deleteWinnerScreen();

                space = true;
                hasWinnerScreen = false;
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


    public boolean getRectangleTryAgain() {
        return rectangleTryAgain;
    }

    public boolean getRectangleExit() {
        return rectangleExit;
    }

    public boolean getSpace() {
        return space;
    }

    public boolean getHasWinnerScreen() {
        return hasWinnerScreen;
    }

    public void setRectangleTryAgain(boolean rectangleStart) {
        this.rectangleTryAgain = rectangleStart;
    }
}
