package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.allpainnogain.gameproject.Players.Player;
import org.academiadecodigo.allpainnogain.gameproject.Players.Player1;
import org.academiadecodigo.allpainnogain.gameproject.Players.Player2;

public class Game {

    private int delay;

    private BattleField battleField;
    private Player player1;
    private Player player2;

    // default constructor
    public Game(int delay){
        this.delay = delay;
    }


    public void init() {
        battleField = new BattleField();
        battleField.init();
        player1 = new Player1("P1",new Tank(new Position(20, 20)));
        player2 = new Player2("P2",new Tank(new Position(1326, 728)));

    }


    public void start()throws InterruptedException{

        Thread.sleep(5000);


        while (true) {
            Thread.sleep(delay);


                ((Player1) player1).moveTank();
                ((Player2) player2).moveTank();

        }
    }
}
