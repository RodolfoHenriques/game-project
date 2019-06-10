package org.academiadecodigo.allpainnogain.gameproject;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Optional;

public class Bullet {

    private int bulletInitX;
    private int bulletInitY;
    private int bulletSizeX = 15;
    private int bulletSizeY = 15;
    private Tank tank;
    private Ellipse regularBullets;

    private Picture regularBullet;
    private int direction;
    private int step = 5;

    //TEST SECTION
    private int counter;
    private int outOfTankX;
    private int outOfTankY;
    private boolean puuuuuuummm;


    //END TEST SECTION


    public Bullet(int tankPosX, int tankPosY, int direction, Tank tank) {
        bulletInitX = tankPosX + tank.getTankPos().getTankRectangle().getWidth() / 2 - bulletSizeX / 2;
        bulletInitY = tankPosY + tank.getTankPos().getTankRectangle().getHeight() / 2 - bulletSizeY / 2;
        this.tank = tank;
        this.direction = direction;
        regularBullets = new Ellipse(bulletInitX, bulletInitY, bulletSizeX, bulletSizeY);


        regularBullet = new Picture(bulletInitX, bulletInitY, "poop.png");
        bulletSizeX = regularBullet.getWidth();
        bulletSizeY = regularBullet.getHeight();

    }

    public void move() {

        int currentBulletPosX = regularBullet.getX();
        int currentBulletPosY = regularBullet.getY();

        Direction dir = Direction.values()[direction];

        if (counter == 0) {
            outOfTankX = tank.getTankPos().getTankRectangle().getWidth() / 2 + bulletSizeX / 2;
            outOfTankY = tank.getTankPos().getTankRectangle().getHeight() / 2 + bulletSizeY / 2;
        }

        counter++;


        switch (dir) {
            case NORTH:
                if (currentBulletPosY - outOfTankY - 2 < BattleField.MARGIN) {
                    regularBullet.delete();
                    puuuuuuummm = true;
                    return;
                }
                currentBulletPosY -= (outOfTankY + step);
                break;
            case SOUTH:
                if (currentBulletPosY + outOfTankY + 2 > (BattleField.HEIGHT + BattleField.MARGIN - regularBullet.getWidth())) {
                    regularBullet.delete();
                    puuuuuuummm = true;
                    return;
                }
                currentBulletPosY += (outOfTankY + step);
                break;

            case EAST:
                if (currentBulletPosX + outOfTankX + 2 > (BattleField.WIDTH + BattleField.MARGIN - regularBullet.getWidth())) {
                    regularBullet.delete();
                    puuuuuuummm = true;
                    return;
                }
                currentBulletPosX += (outOfTankX + step);
                break;

            case WEST:
                if (currentBulletPosX - outOfTankX - 2 < BattleField.MARGIN) {
                    regularBullet.delete();
                    puuuuuuummm = true;
                    return;
                }
                currentBulletPosX -= (outOfTankX + step);
                break;

            case SOUTHWEST:
                if (currentBulletPosY + outOfTankY + 2 > (BattleField.HEIGHT + BattleField.MARGIN - regularBullet.getWidth())
                        || currentBulletPosX - outOfTankX - 2 < BattleField.MARGIN) {
                    regularBullet.delete();
                    puuuuuuummm = true;
                    return;
                }
                currentBulletPosX -= (outOfTankX + step);
                currentBulletPosY += (outOfTankY + step);
                break;

            case NORTHEAST:
                if (currentBulletPosY - outOfTankY - 2 < BattleField.MARGIN
                        || currentBulletPosX + outOfTankX + 2 > (BattleField.WIDTH + BattleField.MARGIN - regularBullet.getWidth())) {
                    regularBullet.delete();
                    puuuuuuummm = true;
                    return;
                }
                currentBulletPosX += (outOfTankX + step);
                currentBulletPosY -= (outOfTankY + step);
                break;

            case SOUTHEAST:
                if (currentBulletPosY + outOfTankY + 2 > (BattleField.HEIGHT + BattleField.MARGIN - regularBullet.getWidth())
                        || currentBulletPosX + outOfTankX + 2 > (BattleField.WIDTH + BattleField.MARGIN - regularBullet.getWidth())) {
                    regularBullet.delete();
                    puuuuuuummm = true;
                    return;
                }
                currentBulletPosX += (outOfTankX + step);
                currentBulletPosY += (outOfTankY + step);
                break;

            case NORTHWEST:
                if (currentBulletPosY - outOfTankY - 2 < BattleField.MARGIN
                        || currentBulletPosX - outOfTankX - 2 < BattleField.MARGIN) {
                    regularBullet.delete();
                    puuuuuuummm = true;
                    return;
                }
                currentBulletPosX -= (outOfTankX + step);
                currentBulletPosY -= (outOfTankY + step);
                break;
        }


        regularBullet.translate(currentBulletPosX - regularBullet.getX(), currentBulletPosY - regularBullet.getY());
        //regularBullet.setColor(Color.MAGENTA);
        //regularBullet.fill();
        regularBullet.draw();


    }


    public boolean isPuuuuuuummm() {
        return puuuuuuummm;
    }



}
