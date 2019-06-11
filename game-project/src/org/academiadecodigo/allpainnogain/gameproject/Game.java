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
    public Game(int delay) {
        this.delay = delay;
    }


    public void init() {
        battleField = new BattleField();
        battleField.init();
        player1 = new Player1("P1", new Tank(20, 20));
        player2 = new Player2("P2", new Tank(1326, 728));

    }


    public void start() throws InterruptedException {
        while (true) {
            Collidable.checkTankBulletCollision();
            Thread.sleep(delay);
            ((Player1) player1).moveTank();
            ((Player2) player2).moveTank();
            moveAllBullets();

            if (Collidable.listTanks.get(0).getHealth() <= 0) {
                System.out.println("PLAYER 2 WINS!");
                return;
            } else if (Collidable.listTanks.get(1).getHealth() <= 0) {
                System.out.println("PLAYER 1 WINS!");
                return;
            }

        }
    }

    public void moveAllBullets() {
        for (int i = 0; i < player1.getTank().getBulletList().size(); i++) {

            if (player1.getTank().getBulletList().get(i).isPuuuuuuummm()) {

                player1.getTank().getBulletList().remove(player1.getTank().getBulletList().get(i));
                continue;
            }
            (player1.getTank().getBulletList().get(i)).move();
        }

        for (int i = 0; i < player2.getTank().getBulletList().size(); i++) {

            if (player2.getTank().getBulletList().get(i).isPuuuuuuummm()) {

                player2.getTank().getBulletList().remove(player2.getTank().getBulletList().get(i));
                continue;
            }
            (player2.getTank().getBulletList().get(i)).move();
        }
    }

    public static void test() {


    }


}


