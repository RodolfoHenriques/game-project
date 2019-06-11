package org.academiadecodigo.allpainnogain.gameproject;

import java.util.ConcurrentModificationException;
import java.util.LinkedList;

abstract public class Collidable {

    public static LinkedList<Tank> listTanks = new LinkedList();
    public static LinkedList<Bullet> listBullets = new LinkedList();
    public static LinkedList<Obstacle> listObstacles = new LinkedList();


    private boolean collided;
    abstract int getX();
    abstract int getY();
    abstract int getWidth();
    abstract int getHeight();


    public static void checkTankBulletCollision() {


        if (listBullets.size() == 0) {
            return;
        }
        try {

            for (Tank tank : listTanks) {

                for (int i = 0; i < listBullets.size(); i++) {

                    if (tank.getX() <
                            listBullets.get(i).getX()
                            +
                                    listBullets.get(i).getWidth()
                            &&
                            tank.getX()
                                    + tank.getWidth()
                                    >
                                    listBullets.get(i).getX()
                            &&
                            tank.getY()
                                    <
                                    listBullets.get(i).getY()
                                           +
                                            listBullets.get(i).getHeight()
                            &&
                           tank.getY()
                                    + tank.getHeight()
                                    >
                                    listBullets.get(i).getY()
                                    )
                                    {
                        listBullets.get(i).removeBullet();
                        tank.setHealth(Bullet.DAMAGE);
                        System.out.println("P1 life: " + listTanks.get(0).getHealth() +" | P2 life: " + listTanks.get(1).getHealth());
                        return;
                    }
                }

            }

        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }
        return;
    }












}
