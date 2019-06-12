package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ConcurrentModificationException;
import java.util.Optional;

public class Bullet extends Collidable {

    private int bulletInitX;
    private int bulletInitY;
    private Tank tank;
    public static final int DAMAGE = 5;
    private Picture regularBullet;
    private int bulletSizeX = 15;           //PESCADATE WITH RABATE IN BOCATE
    private int bulletSizeY = 15;           //PESCADATE WITH RABATE IN BOCATE
    private int direction;
    private int step = 5;

    //TEST SECTION
    private int counter;
    private int outOfTankX;
    private int outOfTankY;


    private int auxX;
    private int auxY;


    //END TEST SECTION


    public Bullet(int tankPosX, int tankPosY, int direction, Tank tank) {
        bulletInitX = tankPosX + tank.getWidth() / 2 - bulletSizeX / 2;
        bulletInitY = tankPosY + tank.getHeight() / 2 - bulletSizeY / 2;
        this.regularBullet = new Picture(bulletInitX, bulletInitY, "poop.png");
        this.tank = tank;
        this.direction = direction;

        outOfTankX = tank.getWidth() / 2 + bulletSizeX / 2 + 5;
        outOfTankY = tank.getHeight() / 2 + bulletSizeY / 2 + 5;
        auxX = bulletInitX;
        auxY = bulletInitY;
        listBullets.add(this);
    }

    public void move() {

        int currentBulletPosX = this.regularBullet.getX();
        int currentBulletPosY = this.regularBullet.getY();


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
                if (currentBulletPosY + outOfTankY + 2 > (BattleField.HEIGHT + BattleField.MARGIN - this.regularBullet.getWidth()) || checkBulletObjCollision()) {
                    removeBullet();
                    return;
                }
                currentBulletPosY += (outOfTankX + step);
                break;

            case EAST:
                if (currentBulletPosX + outOfTankX + 2 > (BattleField.WIDTH + BattleField.MARGIN - this.regularBullet.getWidth()) || checkBulletObjCollision()) {
                    removeBullet();
                    return;
                }

                //MOV PIRILAU
                //currentBulletPosY = auxY + ((int) (20-20*(Math.sin(counter*57))));
                //currentBulletPosX += (outOfTankX + step + ((int) (20*(Math.sin(counter*57)))));

                currentBulletPosX += (outOfTankX + step);

                //PARABOLA INVERTIDA
                //currentBulletPosX += (outOfTankX + step*5);
                //currentBulletPosY = auxY - counter*counter;

                //PARABOLA NORMAL
                //currentBulletPosX += (outOfTankX + step*5);
                //currentBulletPosY = auxY + counter*counter;

                //PARA MANDAR DUAS BALAS

                //currentBulletPosX += (outOfTankX + step * 5);
                //currentBulletPosY = auxY + counter * 3;

                break;

            case WEST:
                if (currentBulletPosX - outOfTankX - 2 < BattleField.MARGIN || checkBulletObjCollision()) {
                    removeBullet();
                    return;
                }
                currentBulletPosX -= (outOfTankX + step);
                break;

            case SOUTHWEST:
                if (currentBulletPosY + outOfTankY + 2 > (BattleField.HEIGHT + BattleField.MARGIN - this.regularBullet.getWidth())
                        || currentBulletPosX - outOfTankX - 2 < BattleField.MARGIN || checkBulletObjCollision()) {
                    removeBullet();
                    return;
                }
                currentBulletPosX -= (outOfTankX + step);
                currentBulletPosY += (outOfTankY + step);
                break;

            case NORTHEAST:
                if (currentBulletPosY - outOfTankY - 2 < BattleField.MARGIN
                        || currentBulletPosX + outOfTankX + 2 > (BattleField.WIDTH + BattleField.MARGIN - this.regularBullet.getWidth()) || checkBulletObjCollision()) {
                    removeBullet();
                    return;
                }
                currentBulletPosX += (outOfTankX + step);
                currentBulletPosY -= (outOfTankY + step);
                break;

            case SOUTHEAST:
                if (currentBulletPosY + outOfTankY + 2 > (BattleField.HEIGHT + BattleField.MARGIN - this.regularBullet.getWidth())
                        || currentBulletPosX + outOfTankX + 2 > (BattleField.WIDTH + BattleField.MARGIN - this.regularBullet.getWidth()) || checkBulletObjCollision()) {
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



        //regularBullet.setColor(Color.MAGENTfA);
        //regularBullet.fill();

        this.regularBullet.translate(currentBulletPosX - this.regularBullet.getX(), currentBulletPosY - this.regularBullet.getY());
        this.regularBullet.draw();
        checkBulletTankCollision();

    }

    public void removeBullet() {

        listBullets.remove(this);
        this.regularBullet.delete();
    }

    boolean checkBulletObjCollision() {
        for (Obstacle obstacle : listObstacles) {
            if (prevX(direction) < obstacle.getX() + obstacle.getWidth() && prevX(direction) + getWidth() > obstacle.getX() && prevY(direction) < obstacle.getY() + obstacle.getHeight() && prevY(direction) + getHeight() > obstacle.getY()) {
                return true;
            }
        }
        return false;
    }


    public void checkBulletTankCollision() {

        for (Tank tank : listTanks) {
            if ((tank.getX() < getX() + getWidth() &&
                    tank.getX() + tank.getWidth() > getX() &&

                    tank.getY() < getY() + getHeight() &&
                    tank.getY() + tank.getHeight() > getY())) {
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

    @Override
    int getX() {
        return this.regularBullet.getX();
    }

    @Override
    int getY() {
        return this.regularBullet.getY();
    }

    @Override
    int getWidth() {
        return this.regularBullet.getWidth();
    }

    @Override
    int getHeight() {
        return this.regularBullet.getHeight();
    }


}
