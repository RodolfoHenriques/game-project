package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.allpainnogain.gameproject.Players.Player;
import org.academiadecodigo.allpainnogain.gameproject.Players.Player1;
import org.academiadecodigo.allpainnogain.gameproject.Players.Player2;
import org.academiadecodigo.allpainnogain.gameproject.Screens.Guide;
import org.academiadecodigo.allpainnogain.gameproject.Screens.Menu;
import org.academiadecodigo.allpainnogain.gameproject.Screens.WinnerScreen;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    private int delay;
    private boolean end;

    private Player player1;
    private Player player2;
    private Tank tank;
    private Rectangle energyBarP1;
    private Rectangle energyBarP2;
    private Rectangle recBarP1;
    private Rectangle recBarP2;


    public Game(int delay) {
        this.delay = delay;
    }


    public void init() {

        BattleField battleField = new BattleField();
        battleField.init();
        player1 = new Player1("P1", new Tank(90, 90, "t1.png"));
        player2 = new Player2("P2", new Tank(1236, 638, "t2.png"));
        energyBarP1 = new Rectangle(0, 0, 0, 0);
        energyBarP2 = new Rectangle(0, 0, 30, 0);
        recBarP1 = new Rectangle(0, 0, 0, 0);
        recBarP2 = new Rectangle(0, 0, 30, 0);


    }


    public void start() throws InterruptedException {

        while (!end) {
            Thread.sleep(delay);
            ((Player1) player1).moveTank();
            ((Player2) player2).moveTank();

            moveBullets();
            winnerCheck();
            energyBars();
        }

        WinnerScreen winnerScreen = new WinnerScreen();

        winnerScreen.createWinnerScreen();

        while (winnerScreen.getHasWinnerScreen()) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }

        if (winnerScreen.getSpace()) {

            if (winnerScreen.getRectangleTryAgain()) {

                winnerScreen.deleteWinnerScreen();

                end = false;

                Collidable.listBullets.clear();

                player1.setTankHealth(100);
                player2.setTankHealth(100);
                player1.setTankPosition(90,90, "09.png");
                player2.setTankPosition(1236,638, "t2.png");


                //init();

                try {

                    start();

                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }


            }

            if (winnerScreen.getRectangleExit()) {

                System.exit(0);
            }
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
            if (Collidable.listBullets.get(i) == null) {
                return;
            }
            if (Collidable.listBullets.get(i) instanceof RegularBullet) {
                ((RegularBullet) Collidable.listBullets.get(i)).moveRegularBullet();
                continue;
            }
            if (Collidable.listBullets.get(i) instanceof SpeedBullet) {
                ((SpeedBullet) Collidable.listBullets.get(i)).moveSpeedBullet();

                continue;
            }
            if (Collidable.listBullets.get(i) instanceof CrazyBullet) {
                ((CrazyBullet) Collidable.listBullets.get(i)).crazyMove();


            }
        }

    }

    public void energyBars() {
        energyBarP1.delete();
        energyBarP1 = new Rectangle(0, 0, ((BattleField.WIDTH/2)+ (BattleField.MARGIN)) * Collidable.listTanks.get(0).getHealth()/100, 30);
        energyBarP1.setColor(new Color(91,99,75));
        energyBarP1.fill();
        energyBarP2.delete();
        energyBarP2 = new Rectangle(((BattleField.WIDTH)+ (BattleField.MARGIN*2)) - ((BattleField.WIDTH/2)+BattleField.MARGIN)* Collidable.listTanks.get(1).getHealth()/100, 0, ((BattleField.WIDTH/2)+ (BattleField.MARGIN)) * Collidable.listTanks.get(1).getHealth()/100, 30);
        energyBarP2.setColor(new Color(201,180,137));
        energyBarP2.fill();

       recBarP1.delete();
        recBarP1 = new Rectangle(0, 0, ((BattleField.WIDTH/2)+ (BattleField.MARGIN)) * Collidable.listTanks.get(0).getHealth()/100, 30);
        recBarP1.draw();
        recBarP2.delete();
        recBarP2 = new Rectangle(((BattleField.WIDTH)+ (BattleField.MARGIN*2)) - ((BattleField.WIDTH/2)+BattleField.MARGIN)* Collidable.listTanks.get(1).getHealth()/100, 0, ((BattleField.WIDTH/2)+ (BattleField.MARGIN)) * Collidable.listTanks.get(1).getHealth()/100, 30);
        recBarP2.draw();



    }

    public boolean getEnd() {
        return end;
    }

}

