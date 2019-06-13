package org.academiadecodigo.allpainnogain.gameproject;


import org.academiadecodigo.allpainnogain.gameproject.Players.Player;
import org.academiadecodigo.allpainnogain.gameproject.Players.Player1;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ConcurrentModificationException;
import java.util.LinkedList;

public class Tank extends Collidable {

    private int health = 100;
    private int direction = 8;
    private int step = 3;
    private int height = 50;
    private int width = 50;
    private Position tankPos;
    private Picture tankRectangle;


    public Tank(int x, int y, String file) {
        this.tankPos = new Position(x, y);
        tankRectangle = new Picture(x, y, file);
        tankRectangle.draw();
        listTanks.add(this);
    }

    public void moveTank() {
        int currentTankPosX = tankPos.getX();
        int currentTankPosY = tankPos.getY();

        Direction dir = Direction.values()[direction];

        switch (dir) {
            case NORTH:
                if (currentTankPosY - 2 < BattleField.MARGIN || checkTankObjCollision() || checkTankCollision()) {
                    break;
                }
                currentTankPosY -= step;
                break;
            case SOUTH:
                if (currentTankPosY + 2 > (BattleField.HEIGHT + BattleField.MARGIN - tankRectangle.getWidth()) || checkTankObjCollision() || checkTankCollision()) {
                    break;
                }
                currentTankPosY += step;
                break;

            case EAST:
                if (currentTankPosX + 2 > (BattleField.WIDTH + BattleField.MARGIN - tankRectangle.getWidth()) || checkTankObjCollision() || checkTankCollision()) {
                    break;
                }
                currentTankPosX += step;
                break;

            case WEST:
                if (currentTankPosX - 2 < BattleField.MARGIN || checkTankObjCollision() || checkTankCollision()) {
                    break;
                }
                currentTankPosX -= step;
                break;

            case SOUTHWEST:
                if (currentTankPosY + 2 > (BattleField.HEIGHT + BattleField.MARGIN - tankRectangle.getWidth())
                        || currentTankPosX - 2 < BattleField.MARGIN || checkTankObjCollision() || checkTankCollision()) {
                    break;
                }
                currentTankPosX -= step;
                currentTankPosY += step;
                break;

            case NORTHEAST:
                if (currentTankPosY - 2 < BattleField.MARGIN
                        || currentTankPosX + 2 > (BattleField.WIDTH + BattleField.MARGIN - tankRectangle.getWidth()) || checkTankObjCollision() || checkTankCollision()) {
                    break;
                }
                currentTankPosX += step;
                currentTankPosY -= step;
                break;

            case SOUTHEAST:
                if (currentTankPosY + 2 > (BattleField.HEIGHT + BattleField.MARGIN - tankRectangle.getWidth())
                        || currentTankPosX + 2 > (BattleField.WIDTH + BattleField.MARGIN - tankRectangle.getWidth()) || checkTankObjCollision() || checkTankCollision()) {
                    break;
                }
                currentTankPosX += step;
                currentTankPosY += step;
                break;

            case NORTHWEST:
                if (currentTankPosY - 2 < BattleField.MARGIN
                        || currentTankPosX - 2 < BattleField.MARGIN || checkTankObjCollision() || checkTankCollision()) {
                    break;
                }
                currentTankPosX -= step;
                currentTankPosY -= step;
                break;
        }


        tankRectangle.translate(currentTankPosX - tankPos.getX(), currentTankPosY - tankPos.getY());

        tankPos.setX(currentTankPosX);
        tankPos.setY(currentTankPosY);
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void shoot() {
        new Bullet(tankPos.getX(), tankPos.getY(), direction, this);
    }

    @Override
    int getX() {
        return tankPos.getX();
    }

    @Override
    int getY() {
        return tankPos.getY();
    }

    @Override
    int getWidth() {
        return width;
    }

    @Override
    int getHeight() {
        return height;
    }


    boolean checkTankObjCollision() {

        for (Tank tank : listTanks) {
            for (Obstacle obstacle : listObstacles) {
                if (prevX(direction) < obstacle.getX() + obstacle.getWidth() && prevX(direction) + tank.getWidth() > obstacle.getX() && prevY(direction) < obstacle.getY() + obstacle.getHeight() && prevY(direction) + tank.getHeight() > obstacle.getY()) {

                    if(obstacle instanceof Goat){
                        Sound sound = new Sound("/goatsScream.wav");
                        sound.play(true);
                    }

                    return true;
                }
            }
        }
        return false;
    }


    boolean checkTankCollision() {
        for (Tank listTank : listTanks) {
            if (listTank != this) {
                if (prevX(direction) < listTank.getX() + listTank.getWidth() && prevX(direction) + getWidth() > listTank.getX() && prevY(direction) < listTank.getY() + listTank.getHeight() && prevY(direction) + getHeight() > listTank.getY()) {
                    return true;
                }
            }
        }
        return false;
    }


    public int prevX(int direction) {
        switch (direction) {
            case 0:
            case 1:
                return getX();
            case 2:
            case 4:
            case 6:
                return getX() + step;
            case 3:
            case 5:
            case 7:
                return getX() - step;
        }
        return 0;
    }


    public int prevY(int direction) {
        switch (direction) {
            case 0:
            case 4:
            case 5:
                return getY() - step;
            case 1:
            case 6:
            case 7:
                return getY() + step;
            case 2:
            case 3:
                return getY();
        }
        return 0;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int damage) {
        health = health - damage;
    }
}

