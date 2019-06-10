package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.allpainnogain.gameproject.Screens.Menu;


public class Main {

    public static void main(String[] args) throws InterruptedException{

        //KeyboardEvent keyboardEvent = null;

        Game game = new Game(15);

        Menu menu = new Menu();



        if (menu.getEnter()){
            if (menu.getRectangleStart()){
                game.init();
                game.start();
            }

            if (menu.getRectangleGuide()){
                System.out.println("yeeeey estamos no guide");
            }
        }


        while(true){

        }


    }
}
