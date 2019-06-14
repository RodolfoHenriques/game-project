package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Bullet extends Collidable {


    public static final int DAMAGE = 5;
    protected int direction;
    protected int step = 5;
    protected int counter;
    protected int outOfTankX;
    protected int outOfTankY;
    protected int bulletSizeX = 15;
    protected int bulletSizeY = 15;
    protected int bulletInitX;
    protected int bulletInitY;
    protected int auxX;
    protected int auxY;
    protected Picture regularBullet;
    protected Tank tank;


    public Bullet(int tankPosX, int tankPosY, int direction, Tank tank) {
        bulletInitX = tankPosX + tank.getWidth() / 2 - bulletSizeX / 2;
        bulletInitY = tankPosY + tank.getHeight() / 2 - bulletSizeY / 2;
        this.regularBullet = new Picture(bulletInitX, bulletInitY, "/Resources/poop.png");
        this.tank = tank;
        this.direction = direction;
        outOfTankX = tank.getWidth() / 2 + bulletSizeX / 2 + 10;
        outOfTankY = tank.getHeight() / 2 + bulletSizeY / 2 + 10;
        auxX = bulletInitX;
        auxY = bulletInitY;
        listBullets.add(this);
    }


    public boolean hitWallAndObst(int outOfTankX, int outOfTankY, int currentBulletPosX, int currentBulletPosY, Direction dir) {

        if (!checkBulletObjCollision()) {
            switch (dir) {
                case NORTH:
                    if (currentBulletPosY - outOfTankY - 2 < BattleField.MARGIN) {
                        break;
                    }
                    return false;
                case SOUTH:
                    if (currentBulletPosY + outOfTankY + 2 > (BattleField.HEIGHT + BattleField.MARGIN - regularBullet.getWidth())) {
                        break;
                    }
                    return false;
                case EAST:
                    if (currentBulletPosX + outOfTankX + 2 > (BattleField.WIDTH + BattleField.MARGIN - regularBullet.getWidth())) {
                        break;
                    }
                    return false;
                case WEST:
                    if (currentBulletPosX - outOfTankX - 2 < BattleField.MARGIN) {
                        break;
                    }
                    return false;

                case SOUTHWEST:
                    if (currentBulletPosY + outOfTankY + 2 > (BattleField.HEIGHT + BattleField.MARGIN - regularBullet.getWidth())
                            || currentBulletPosX - outOfTankX - 2 < BattleField.MARGIN) {
                        break;
                    }
                    return false;
                case NORTHEAST:
                    if (currentBulletPosY - outOfTankY - 2 < BattleField.MARGIN
                            || currentBulletPosX + outOfTankX + 2 > (BattleField.WIDTH + BattleField.MARGIN - regularBullet.getWidth())) {
                        break;
                    }
                    return false;
                case SOUTHEAST:
                    if (currentBulletPosY + outOfTankY + 2 > (BattleField.HEIGHT + BattleField.MARGIN - regularBullet.getWidth())
                            || currentBulletPosX + outOfTankX + 2 > (BattleField.WIDTH + BattleField.MARGIN - regularBullet.getWidth())) {
                        break;
                    }
                    return false;
                case NORTHWEST:
                    if (currentBulletPosY - outOfTankY - 2 < BattleField.MARGIN
                            || currentBulletPosX - outOfTankX - 2 < BattleField.MARGIN) {
                        break;
                    }
                    return false;
            }
        }
        return true;
    }


    public void removeBullet() {

        listBullets.remove(this);
        this.regularBullet.delete();
    }

    boolean checkBulletObjCollision() {


        for (Obstacle obstacle : listObstacles) {


            if (prevX(direction) < obstacle.getX() + obstacle.getWidth() &&
                    prevX(direction) > obstacle.getX() &&
                    prevY(direction) < obstacle.getY() + obstacle.getHeight() &&
                    prevY(direction) > obstacle.getY()) {
                return true;
            }
        }
        return false;
    }


    public void checkBulletTankCollision() {

        for (Tank tank : listTanks) {
            if (tank.getX() < getX() + getWidth() &&
                    tank.getX() + tank.getWidth() > getX() &&

                    tank.getY() < getY() + getHeight() &&
                    tank.getY() + tank.getHeight() > getY()) {

                tank.setHealth(Bullet.DAMAGE);
                System.out.println("P1 life: " + listTanks.get(0).getHealth() + " | P2 life: " + listTanks.get(1).getHealth());
                removeBullet();
            }
        }
    }


    public int prevX(int direction) {
        switch (direction) {
            case 0:
            case 1:
                return getX();
            case 2:
            case 4:
            case 6:
                return getX() + 2;
            case 3:
            case 5:
            case 7:
                return getX() - 2;
        }
        return 0;
    }


    public int prevY(int direction) {
        switch (direction) {
            case 0:
            case 4:
            case 5:
                return getY();
            case 1:
            case 6:
            case 7:
                return getY() + 2;
            case 2:
            case 3:
                return getY() - 2;
        }
        return 1;
    }

    @Override
    int getX() {
        return regularBullet.getX();
    }

    @Override
    int getY() {
        return regularBullet.getY();
    }

    @Override
    int getWidth() {
        return regularBullet.getWidth();
    }

    @Override
    int getHeight() {
        return regularBullet.getHeight();
    }

}


