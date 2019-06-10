package org.academiadecodigo.allpainnogain.gameproject.Screens;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu extends Picture implements KeyboardHandler {


    private Picture picture = new Picture(0, 0, "menuImage.png");

    public Menu() {
        initKeyboard();
    }

    public void initKeyboard() {

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        Rectangle selectMenuStart = new Rectangle(80, 50, 305, 120);
        Rectangle selectMenuGuide = new Rectangle(80, 185, 305, 120);

        selectMenuStart.draw();

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:
                selectMenuGuide.delete();
                selectMenuStart.draw();
                break;

            case KeyboardEvent.KEY_DOWN:
                selectMenuStart.delete();
                selectMenuGuide.draw();
                break;
        }
    }

    @Override
    public void keyReleased (KeyboardEvent keyboardEvent){

    }
}
