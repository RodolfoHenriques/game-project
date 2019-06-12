package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Optional;

public class Bullet extends Collidable {


    public static final int DAMAGE = 5;
    private int direction;
    private int step = 5;
    private int counter;
    private int outOfTankX;
    private int outOfTankY;
    private int bulletSizeX = 15;           //PESCADATE WITH RABATE IN BOCATE
    private int bulletSizeY = 15;           //PESCADATE WITH RABATE IN BOCATE
    private int bulletInitX;
    private int bulletInitY;
    private int auxX;
    private int auxY;
    private Picture regularBullet;
    private Tank tank;

    
    public Bullet(int tankPosX, int tankPosY, int direction, Tank tank) {
        bulletInitX = tankPosX + tank.getWidth() / 2 - bulletSizeX / 2;
        bulletInitY = tankPosY + tank.getHeight() / 2 - bulletSizeY / 2;
        regularBullet = new Picture(bulletInitX, bulletInitY, "poop.png");
        this.tank = tank;
        this.direction = direction;
        outOfTankX = tank.getWidth() / 2 + bulletSizeX / 2 + 10;
        outOfTankY = tank.getHeight() / 2 + bulletSizeY / 2 + 10;
        auxX = bulletInitX;
        auxY = bulletInitY;
        listBullets.add(this);
    }

    public void move() {

        int currentBulletPosX = regularBullet.getX();
        int currentBulletPosY = regularBullet.getY();


        Direction dir = Direction.values()[direction];

        if (counter != 0) {
            outOfTankX = 0;
            outOfTankY = 0;
        }


        counter++;


        switch (dir) {
            case NORTH:
                if (currentBulletPosY - outOfTankY - 2 < BattleField.MARGIN || checkBulletObjCollision()) {
                    removeBullet();
                    return;
                }
                currentBulletPosY -= (outOfTankX + step);
                break;
            case SOUTH:
                if (currentBulletPosY + outOfTankY + 2 > (BattleField.HEIGHT + BattleField.MARGIN - regularBullet.getWidth()) || checkBulletObjCollision()) {
                    removeBullet();
                    return;
                }
                currentBulletPosY += (outOfTankX + step);
                break;

            case EAST:
                if (currentBulletPosX + outOfTankX + 2 > (BattleField.WIDTH + BattleField.MARGIN - regularBullet.getWidth()) || checkBulletObjCollision()) {
                    removeBullet();
                    return;
                }
                currentBulletPosX += (outOfTankX + step);
                break;

            //MOV PIRILAU
            //currentBulletPosY = auxY + ((int) (20-20*(Math.sin(counter*57))));
            //currentBulletPosX += (outOfTankX + step + ((int) (20*(Math.sin(counter*57)))));

            //currentBulletPosX += (outOfTankX + step);
            //currentBulletPosY += (outOfTankX + step);

            //PARABOLA INVERTIDA
            //currentBulletPosX += (outOfTankX + step*5);
            //currentBulletPosY = auxY - counter*counter;

            //PARABOLA NORMAL
            //currentBulletPosX += (outOfTankX + step*5);
            //currentBulletPosY = auxY + counter*counter;

            //PARA MANDAR DUAS BALAS

            //currentBulletPosX += (outOfTankX + step * 5);
            //currentBulletPosY = auxY + counter * 3;


            case WEST:
                if (currentBulletPosX - outOfTankX - 2 < BattleField.MARGIN || checkBulletObjCollision()) {
                    removeBullet();
                    return;
                }
                currentBulletPosX -= (outOfTankX + step);
                break;

            case SOUTHWEST:
                if (currentBulletPosY + outOfTankY + 2 > (BattleField.HEIGHT + BattleField.MARGIN - regularBullet.getWidth())
                        || currentBulletPosX - outOfTankX - 2 < BattleField.MARGIN || checkBulletObjCollision()) {
                    removeBullet();
                    return;
                }
                currentBulletPosX -= (outOfTankX + step);
                currentBulletPosY += (outOfTankY + step);
                break;

            case NORTHEAST:
                if (currentBulletPosY - outOfTankY - 2 < BattleField.MARGIN
                        || currentBulletPosX + outOfTankX + 2 > (BattleField.WIDTH + BattleField.MARGIN - regularBullet.getWidth()) || checkBulletObjCollision()) {
                    removeBullet();
                    return;
                }
                currentBulletPosX += (outOfTankX + step);
                currentBulletPosY -= (outOfTankY + step);
                break;

            case SOUTHEAST:
                if (currentBulletPosY + outOfTankY + 2 > (BattleField.HEIGHT + BattleField.MARGIN - regularBullet.getWidth())
                        || currentBulletPosX + outOfTankX + 2 > (BattleField.WIDTH + BattleField.MARGIN - regularBullet.getWidth()) || checkBulletObjCollision()) {
                    removeBullet();
                    return;
                }
                currentBulletPosX += (outOfTankX + step);
                currentBulletPosY += (outOfTankY + step);
                break;

            case NORTHWEST:
                if (currentBulletPosY - outOfTankY - 2 < BattleField.MARGIN
                        || currentBulletPosX - outOfTankX - 2 < BattleField.MARGIN || checkBulletObjCollision()) {
                    removeBullet();
                    return;
                }
                currentBulletPosX -= (outOfTankX + step);
                currentBulletPosY -= (outOfTankY + step);
                break;
        }


        regularBullet.translate(currentBulletPosX - regularBullet.getX(), currentBulletPosY - regularBullet.getY());
        regularBullet.draw();
        checkBulletTankCollision();
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
