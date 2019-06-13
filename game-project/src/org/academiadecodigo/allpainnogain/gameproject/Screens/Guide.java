package org.academiadecodigo.allpainnogain.gameproject.Screens;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Guide implements KeyboardHandler {

    private Keyboard keyboard;
    private Picture pictureGuide = new Picture(0, 0, "fiveTrees.png"); //missing correct picture

    private boolean goBack;
    private boolean hasGuide;


    public Guide() {

        keyboard = new Keyboard(this);
        initKeyboard();
    }


    public void createGuide(){

        pictureGuide.draw();
        hasGuide = true;
    }


    public void deleteGuide(){

        pictureGuide.delete();
        hasGuide = false;
    }


    public void initKeyboard() {

        KeyboardEvent goBack = new KeyboardEvent();
        goBack.setKey(KeyboardEvent.KEY_0);
        goBack.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(goBack);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_0) {
            deleteGuide();
            goBack = true;
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


    public boolean getGoBack() {
        return goBack;
    }

    public boolean getHasGuide() {
        return hasGuide;
    }
}
