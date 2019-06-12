package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.allpainnogain.gameproject.Players.Player;
import org.academiadecodigo.allpainnogain.gameproject.Players.Player1;
import org.academiadecodigo.allpainnogain.gameproject.Players.Player2;
import org.academiadecodigo.allpainnogain.gameproject.Screens.Guide;
import org.academiadecodigo.allpainnogain.gameproject.Screens.Menu;

public class Game {

    private int delay;
    private boolean end;

    private Player player1;
    private Player player2;


    public Game(int delay) {
        this.delay = delay;
    }


    public void init() {

        BattleField battleField = new BattleField();
        battleField.init();
        player1 = new Player1("P1", new Tank(90, 90, "t1.png"));
        player2 = new Player2("P2", new Tank(1236, 638, "t2.png"));


    }


    public void start() throws InterruptedException {

        while (!end) {
            Thread.sleep(delay);
            ((Player1) player1).moveTank();
            ((Player2) player2).moveTank();

            moveBullets();
            winnerCheck();
        }
    }


    public void winnerCheck() {
        if (Collidable.listTanks.get(0).getHealth() <= 0) {

            System.out.println("PLAYER 2 WINS!");
            end = true;

        } else if (Collidable.listTanks.get(1).getHealth() <= 0) {

            System.out.println("PLAYER 1 WINS!");
            end = true;
        }
    }


    public void moveBullets() {

        for (int i = 0; i < Collidable.listBullets.size(); i++) {
            Collidable.listBullets.get(i).move();
        }
    }


    public boolean getEnd() {
        return end;
    }


}


