package org.academiadecodigo.allpainnogain.gameproject.Screens;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Guide implements KeyboardHandler {

    private Keyboard keyboard;
    private Picture pictureGuide = new Picture(0, 0, ""); //missing picture

    private boolean goBack;


    public Guide() {

        keyboard = new Keyboard(this);
        initKeyboard();

        pictureGuide.draw();
    }


    public void initKeyboard() {

        KeyboardEvent back = new KeyboardEvent();
        back.setKey(KeyboardEvent.KEY_0);
        back.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(back);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_0) { //try catch

            pictureGuide.delete();
            goBack = true;
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


    public boolean getGoBack() {
        return goBack;
    }

}
