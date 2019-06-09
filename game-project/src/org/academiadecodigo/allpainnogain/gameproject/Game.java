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
        player1 = new Player1("P1", new Tank(new Position(50, 800)));
        //player2 = new Player2("P2", new Tank(new Position(300, 300)));

    }


    public void start()throws InterruptedException{

        while (true) {
            Thread.sleep(delay);

                ((Player1) player1).moveTank();
                //((Player2) player2).moveTank();

        }
    }
}
