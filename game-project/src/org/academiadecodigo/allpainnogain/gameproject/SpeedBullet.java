package org.academiadecodigo.allpainnogain.gameproject;

public class SpeedBullet extends Bullet {

    public SpeedBullet(int tankPosX, int tankPosY, int direction, Tank tank) {
        super(tankPosX, tankPosY, direction, tank);
    }

    public void moveSpeedBullet() {

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
                    currentBulletPosY -= (outOfTankX + 2 * counter);
                    break;
                case SOUTH:
                    currentBulletPosY += (outOfTankX + 2 * counter);
                    break;

                case EAST:
                    currentBulletPosX += (outOfTankX + 2 * counter);
                    break;

                case WEST:
                    currentBulletPosX -= (outOfTankX + 2 * counter);
                    break;

                case SOUTHWEST:
                    currentBulletPosX -= (outOfTankX + 2 * counter);
                    currentBulletPosY += (outOfTankY + 2 * counter);
                    break;

                case NORTHEAST:
                    currentBulletPosX += (outOfTankX + 2 * counter);
                    currentBulletPosY -= (outOfTankY + 2 * counter);
                    break;

                case SOUTHEAST:
                    currentBulletPosX += (outOfTankX + 2 * counter);
                    currentBulletPosY += (outOfTankY + 2 * counter);
                    break;

                case NORTHWEST:
                    currentBulletPosX -= (outOfTankX + 2 * counter);
                    currentBulletPosY -= (outOfTankY + 2 * counter);
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
