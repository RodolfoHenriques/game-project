package org.academiadecodigo.allpainnogain.gameproject;

import java.util.ConcurrentModificationException;
import java.util.LinkedList;

abstract public class Collidable {

    public static LinkedList<Tank> listTanks = new LinkedList();
    public static LinkedList<Bullet> listBullets = new LinkedList();
    public static LinkedList<Obstacle> listObstacles = new LinkedList();

    abstract int getX();
    abstract int getY();
    abstract int getWidth();
    abstract int getHeight();

}
