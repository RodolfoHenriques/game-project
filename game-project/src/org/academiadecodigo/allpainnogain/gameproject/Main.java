package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.allpainnogain.gameproject.Screens.Guide;
import org.academiadecodigo.allpainnogain.gameproject.Screens.Menu;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Menu menu = new Menu();
        menu.createMenu();

        while (menu.getHasMenu()) {
            Thread.sleep(0);
        }

        while (true) {
            if (menu.getEnter()) {

                if (menu.getRectangleStart()) {
                    menu.deleteMenu();

                    Game game = new Game(15);

                    game.init();
                    game.start();
                }

                if (menu.getRectangleGuide()) {
                    Guide guide = new Guide();
                    guide.createGuide();

                    while (guide.getHasGuide()) {
                        Thread.sleep(0);
                    }

                    while (true) {
                        if (guide.getGoBack()) {
                            guide.deleteGuide();
                        }
                    }
                }
            }
        }
    }
}