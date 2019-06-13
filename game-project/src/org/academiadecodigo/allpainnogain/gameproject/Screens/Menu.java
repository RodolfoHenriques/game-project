package org.academiadecodigo.allpainnogain.gameproject.Screens;

import org.academiadecodigo.allpainnogain.gameproject.Sound;
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

    private boolean space;
    private boolean hasMenu;

    private Sound soundMenu = new Sound("/menuMusic.wav");


    public Menu() {

        keyboard = new Keyboard(this);
        initKeyboard();
    }


    public void createMenu() {

        pictureMenu.draw();
        selectMenuStart.draw();
        hasMenu = true;
        soundMenu.play(true);
    }


    public void deleteMenu() {

        pictureMenu.delete();
        selectMenuGuide.delete();
        selectMenuStart.delete();
        soundMenu.close();
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

        /*KeyboardEvent up = new KeyboardEvent();
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
        if(hasMenu){

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

                    space = true;
                    hasMenu = false;
            }
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

    public boolean getSpace() {
        return space;
    }

    public boolean getHasMenu() {
        return hasMenu;
    }

    public void setRectangleStart(boolean rectangleStart) {
        this.rectangleStart = rectangleStart;
    }
}