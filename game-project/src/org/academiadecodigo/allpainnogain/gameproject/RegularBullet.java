package org.academiadecodigo.allpainnogain.gameproject;

public class RegularBullet extends Bullet {


    public RegularBullet(int tankPosX, int tankPosY, int direction, Tank tank) {
        super(tankPosX, tankPosY, direction, tank);

    }

    public void moveRegularBullet() {


        int currentBulletPosX = regularBullet.getX();
        int currentBulletPosY = regularBullet.getY();


        Direction dir = Direction.values()[direction];

        if (counter != 0) {
            outOfTankX = 0;
            outOfTankY = 0;
        }

        counter++;

        if (!hitWallAndObst(outOfTankX, outOfTankY, currentBulletPosX, currentBulletPosY, dir)) {
            switch (dir) {
                case NORTH:
                    currentBulletPosY -= (outOfTankX + step);
                    break;
                case SOUTH:
                    currentBulletPosY += (outOfTankX + step);
                    break;

                case EAST:
                    currentBulletPosX += (outOfTankX + step);
                    break;

                case WEST:
                    currentBulletPosX -= (outOfTankX + step);
                    break;

                case SOUTHWEST:
                    currentBulletPosX -= (outOfTankX + step);
                    currentBulletPosY += (outOfTankY + step);
                    break;

                case NORTHEAST:
                    currentBulletPosX += (outOfTankX + step);
                    currentBulletPosY -= (outOfTankY + step);
                    break;

                case SOUTHEAST:
                    currentBulletPosX += (outOfTankX + step);
                    currentBulletPosY += (outOfTankY + step);
                    break;

                case NORTHWEST:
                    currentBulletPosX -= (outOfTankX + step);
                    currentBulletPosY -= (outOfTankY + step);
                    break;

            }
        }
        regularBullet.translate(currentBulletPosX - regularBullet.getX(), currentBulletPosY - regularBullet.getY());
        regularBullet.draw();
        checkBulletTankCollision();

        if (hitWallAndObst(outOfTankX, outOfTankY, currentBulletPosX, currentBulletPosY, dir)) {
            removeBullet();
        }


    }

}
