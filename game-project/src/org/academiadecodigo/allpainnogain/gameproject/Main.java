package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.allpainnogain.gameproject.Screens.Guide;
import org.academiadecodigo.allpainnogain.gameproject.Screens.Menu;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Menu menu = new Menu();

        while (true) {

            menu.createMenu();
            Sound sound = new Sound("/Resources/menuMusic.wav");

            try {
                sound.loopIndef();

                Thread.sleep(0); // wait 1 seconds

            } catch (InterruptedException e) {

                System.err.println(e.getMessage());
            }

            while (menu.getHasMenu()) {
                Thread.sleep(0);
            }

            if (menu.getSpace()) {

                if (menu.getRectangleStart()) {
                    menu.deleteMenu();

                    Game game = new Game(15);

                    game.init();
                    game.start();

                    if(game.getEnd()){
                        sound.close();
                    }
                }

                if (menu.getRectangleGuide()) {

                    Guide guide = new Guide();
                    guide.createGuide();

                    while (guide.getHasGuide()) {
                        Thread.sleep(0);
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