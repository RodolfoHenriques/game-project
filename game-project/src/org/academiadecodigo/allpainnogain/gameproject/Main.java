package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.allpainnogain.gameproject.Screens.Guide;
import org.academiadecodigo.allpainnogain.gameproject.Screens.Menu;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Menu menu = new Menu();


        while(menu.getHasMenu()){
            Thread.sleep(0);
        }


        if (menu.getEnter()) {

            if (menu.getRectangleStart()) {

                Game game = new Game(15);

                game.init();
                game.start();
            }
        }
    }
}