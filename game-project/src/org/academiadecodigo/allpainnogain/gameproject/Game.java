package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.allpainnogain.gameproject.Players.Player;
import org.academiadecodigo.allpainnogain.gameproject.Players.Player1;
import org.academiadecodigo.allpainnogain.gameproject.Players.Player2;

public class Game {

    private BattleField battleField;
    private Player player1;
    private Player player2;

    // default constructor


    public void init() {
        battleField = new BattleField();
        battleField.init();
        player1 = new Player1("P1", new Tank(new Position(123,123)));
        player2 = new Player2("P2", new Tank(new Position(300,300)));

    }

}
