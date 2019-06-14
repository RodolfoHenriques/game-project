package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.allpainnogain.gameproject.Screens.Guide;
import org.academiadecodigo.allpainnogain.gameproject.Screens.Menu;

public class Main {

    public static void main(String[] args) {

        Game game = new Game(15);
        Menu menu = new Menu();
        Sound sound = new Sound("/menuMusic.wav");

        while (true) {

            menu.createMenu();

            try {
                sound.loopIndef();
                Thread.sleep(0);

            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }

            while (menu.getHasMenu()) {
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }

            if (menu.getSpace()) {

                if (menu.getRectangleStart()) {

                    menu.deleteMenu();

                    if(!menu.getHasMenu()){
                        sound.close();
                    }

                    game.init();

                    try {
                        game.start();

                    } catch (InterruptedException e) {
                        System.err.println(e.getMessage());
                    }
                }

                if (menu.getRectangleGuide()) {

                    Guide guide = new Guide();
                    guide.createGuide();

                    while (guide.getHasGuide()) {
                        try {
                            Thread.sleep(0);
                        } catch (InterruptedException e) {
                            System.err.println(e.getMessage());
                        }
                    }

                    if (guide.getGoBack()) {
                        guide.deleteGuide();
                        menu.setRectangleStart(true);
                    }
                }
            }
        }
    }
}