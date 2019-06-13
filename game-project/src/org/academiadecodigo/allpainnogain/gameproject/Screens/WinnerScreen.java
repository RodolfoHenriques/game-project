package org.academiadecodigo.allpainnogain.gameproject.Screens;

import org.academiadecodigo.allpainnogain.gameproject.Sound;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class WinnerScreen implements KeyboardHandler {

    private Keyboard keyboard;
    private Picture pictureWinnerScreen = new Picture(50, 0, "endMenu.png");
    private Picture pictureWinnerScreenPlayer1 = new Picture(0, 0, "poop2.png");
    private Picture pictureWinnerScreenPlayer2 = new Picture(0, 0, "poop2.png");

    //change values of rectangle
    private Rectangle selectTryAgain = new Rectangle(380, 360,620,160);
    private Rectangle selectExit = new Rectangle(520, 520,335,160);

    private boolean rectangleTryAgain = true;
    private boolean rectangleExit;

    private boolean space;
    private boolean hasWinnerScreen;

    private Sound soundWinnerScreen = new Sound("/clapping.wav");

    public WinnerScreen() {

        keyboard = new Keyboard(this);
        initKeyboard();
    }

    public void createWinnerScreen() {

        pictureWinnerScreen.draw();
        selectTryAgain.draw();
        hasWinnerScreen = true;
        soundWinnerScreen.play(true);
    }


    public void deleteWinnerScreen() {

        pictureWinnerScreen.delete();
        selectExit.delete();
        selectTryAgain.delete();
        soundWinnerScreen.close();
    }


    public void initKeyboard() {

        int[] keys = new int[]{KeyboardEvent.KEY_UP,
                KeyboardEvent.KEY_DOWN,
                KeyboardEvent.KEY_SPACE};

        for (int key: keys) {
            KeyboardEvent event = new KeyboardEvent();
            event.setKey(key);
            event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(event);
        }

       /* KeyboardEvent up = new KeyboardEvent();
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
        keyboard.addEventListener(space);*/
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (hasWinnerScreen) {

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
