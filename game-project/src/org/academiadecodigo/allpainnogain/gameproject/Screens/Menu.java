package org.academiadecodigo.allpainnogain.gameproject.Screens;

import org.academiadecodigo.allpainnogain.gameproject.Game;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Menu implements KeyboardHandler {

    private Keyboard keyboard;

    private Rectangle selectMenuStart = new Rectangle(80, 50, 305, 120);
    private Rectangle selectMenuGuide = new Rectangle(80, 185, 305, 120);

    private boolean rectangleStart = true;
    private boolean rectangleGuide = true;
    private boolean enter = false;


    public Menu() {

        Picture picture = new Picture(0, 0, "menuImage.png");
        keyboard = new Keyboard(this);
        initKeyboard();

        picture.draw();
        selectMenuStart.draw();
    }


    public void initKeyboard() {

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent enter = new KeyboardEvent();
        enter.setKey(KeyboardEvent.KEY_ENTER);
        enter.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(enter);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:
                selectMenuGuide.delete();
                selectMenuStart.draw();


                break;

            case KeyboardEvent.KEY_DOWN:
                selectMenuStart.delete();
                selectMenuGuide.draw();


                break;

            case KeyboardEvent.KEY_ENTER:

                enter = true;

                if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP){

                    rectangleStart = true;
                    rectangleGuide = false;
                    break;
                }

                rectangleGuide = true;
                rectangleStart = false;
                break;
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


    public boolean getRectangleStart() {

        return rectangleStart;
    }

    public boolean getRectangleGuide() {

        return rectangleGuide;
    }

    public boolean getEnter() {
        return enter;
    }
}
