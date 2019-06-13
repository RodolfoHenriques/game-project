package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Tank extends Collidable {
    private int health = 100;
    private int direction = 8;
    private int step = 3;
    private int tankHeight;
    private int tankWidth;
    private Position tankPos;
    private Picture tankRectangle;

    public Tank(int x, int y, String file) {
        this.tankPos = new Position(x, y);
        tankRectangle = new Picture(x, y, file);
        tankRectangle.draw();
        listTanks.add(this);
        tankHeight = tankRectangle.getHeight();
        tankWidth = tankRectangle.getWidth();
    }

    public void moveTank() {
        int currentTankPosX = tankPos.getX();
        int currentTankPosY = tankPos.getY();

        Direction dir = Direction.values()[direction];

        switch (dir) {
            case NORTH:
                tankRectangle.load("05.png");
                if (currentTankPosY - 2 < BattleField.MARGIN || isCollide()) {
                    break;
                }
                currentTankPosY -= step;
                break;
            case SOUTH:
                tankRectangle.load("03.png");
                if (currentTankPosY + 2 > (BattleField.HEIGHT + BattleField.MARGIN - tankHeight) || isCollide()) {
                    break;
                }
                currentTankPosY += step;
                break;

            case EAST:
                tankRectangle.load("09.png");
                if (currentTankPosX + 2 > (BattleField.WIDTH + BattleField.MARGIN - tankWidth) || isCollide()) {
                    break;
                }
                currentTankPosX += step;
                break;

            case WEST:
                tankRectangle.load("08.png");
                if (currentTankPosX - 2 < BattleField.MARGIN || isCollide()) {
                    break;
                }
                currentTankPosX -= step;
                break;

            case SOUTHWEST:
                tankRectangle.load("01.png");
                if (currentTankPosY + 2 > (BattleField.HEIGHT + BattleField.MARGIN - tankHeight)
                        || currentTankPosX - 2 < BattleField.MARGIN || isCollide()) {
                    break;
                }
                currentTankPosX -= step;
                currentTankPosY += step;
                break;

            case NORTHEAST:
                tankRectangle.load("07.png");
                if (currentTankPosY - 2 < BattleField.MARGIN
                        || currentTankPosX + 2 > (BattleField.WIDTH + BattleField.MARGIN - tankHeight) || isCollide()) {
                    break;
                }
                currentTankPosX += step;
                currentTankPosY -= step;
                break;

            case SOUTHEAST:
                tankRectangle.load("06.png");
                if (currentTankPosY + 2 > (BattleField.HEIGHT + BattleField.MARGIN - tankHeight)
                        || currentTankPosX + 2 > (BattleField.WIDTH + BattleField.MARGIN - tankHeight) || isCollide()) {
                    break;
                }
                currentTankPosX += step;
                currentTankPosY += step;
                break;

            case NORTHWEST:
                tankRectangle.load("02.png");
                if (currentTankPosY - 2 < BattleField.MARGIN
                        || currentTankPosX - 2 < BattleField.MARGIN || isCollide()) {
                    break;
                }
                currentTankPosX -= step;
                currentTankPosY -= step;
                break;
        }
        tankRectangle.translate(currentTankPosX - tankPos.getX(), currentTankPosY - tankPos.getY());
        tankRectangle.draw();
        tankPos.setX(currentTankPosX);
        tankPos.setY(currentTankPosY);
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void shoot1() {
        new RegularBullet(tankPos.getX(), tankPos.getY(), direction, this);
    }

    public void shoot2(){
        new SpeedBullet(tankPos.getX(), tankPos.getY(), direction, this);
    }

    public void shoot3(){
        new CrazyBullet(tankPos.getX(), tankPos.getY(), direction, this);
    }

    boolean checkTankObjCollision() {
        for (Tank tank : listTanks) {
            for (Obstacle obstacle : listObstacles) {
                if (prevX(direction) < obstacle.getX() + obstacle.getWidth() &&
                        prevX(direction) + tank.tankWidth > obstacle.getX() &&
                        prevY(direction) < obstacle.getY() + obstacle.getHeight() &&
                        prevY(direction) + tank.tankHeight > obstacle.getY()) {
                    if (obstacle instanceof Goat) {
                        Sound sound = new Sound("/goatsScream.wav");
                        sound.play(true);
                    }

                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkTankCollision() {
        for (Tank listTank : listTanks) {
            if (listTank != this) {
                if (prevX(direction) < listTank.getX() + listTank.tankWidth &&
                        prevX(direction) + tankWidth > listTank.getX() &&
                        prevY(direction) < listTank.getY() + listTank.tankHeight &&
                        prevY(direction) + tankHeight > listTank.getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCollide() {
        return checkTankObjCollision() || checkTankCollision();
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
        return tankWidth;
    }

    @Override
    int getHeight() {
        return tankHeight;
    }

    public void setNewPosition(int x, int y, String file){
        tankPos = new Position(x, y);
        tankRectangle.delete();
        tankRectangle = new Picture(x, y, file);
    }

    public void setNewHealth(int health){
        this.health = health;
    }
}
