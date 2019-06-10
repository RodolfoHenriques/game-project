package org.academiadecodigo.allpainnogain.gameproject.Screens;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Menu implements KeyboardHandler {

    private Keyboard keyboard;
    private Picture pictureMenu = new Picture(0, 0, "menuImage.png");

    private Rectangle selectMenuStart = new Rectangle(80, 50, 305, 120);
    private Rectangle selectMenuGuide = new Rectangle(80, 185, 305, 120);

    private boolean rectangleStart = true;
    private boolean rectangleGuide;

    private boolean enter;
    private boolean hasMenu;


    public Menu() {

        keyboard = new Keyboard(this);
        initKeyboard();
    }


    public void createMenu(){
        pictureMenu.draw();
        selectMenuStart.draw();
        hasMenu = true;
    }


    public void deleteMenu(){
        pictureMenu.delete();
        selectMenuGuide.delete();
        selectMenuStart.delete();
    }


    public void initKeyboard() {

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent enter = new KeyboardEvent();
        enter.setKey(KeyboardEvent.KEY_SPACE);
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

                rectangleStart = true;
                rectangleGuide = false;

                break;

            case KeyboardEvent.KEY_DOWN:
                selectMenuStart.delete();
                selectMenuGuide.draw();

                rectangleGuide = true;
                rectangleStart = false;

                break;

            case KeyboardEvent.KEY_SPACE:
                deleteMenu();

                enter = true;
                hasMenu = false;
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


    public boolean getHasMenu() {
        return hasMenu;
    }
}