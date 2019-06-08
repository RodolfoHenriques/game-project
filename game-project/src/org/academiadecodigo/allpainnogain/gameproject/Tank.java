package org.academiadecodigo.allpainnogain.gameproject;


public class Tank {

    private int health;
    private int speed;
    private boolean destroyed;
    private Position tankPos;
    private int direction;

    public Tank(Position tankPos) {
        this.tankPos = tankPos;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void moveTank() {
        int currentTankPosX = tankPos.getX();
        int currentTankPosY = tankPos.getY();
        int step = 1;
        Direction dir = Direction.values()[direction];

        switch (dir) {
            case NORTH:
                if (currentTankPosY - 1 < BattleField.MARGIN) {
                    break;
                }
                currentTankPosY -= step;
                break;
            case SOUTH:
                if (currentTankPosY + 1 > (BattleField.HEIGHT + BattleField.MARGIN - tankPos.getTankRectangle().getWidth())) {
                    break;
                }
                currentTankPosY += step;
                break;

            case EAST:
                if (currentTankPosX + 1 > (BattleField.WIDTH + BattleField.MARGIN - tankPos.getTankRectangle().getWidth())) {
                    break;
                }
                currentTankPosX += step;
                break;

            case WEST:
                if (currentTankPosX - 1 < BattleField.MARGIN) {
                    break;
                }
                currentTankPosX -= step;
                break;

            case SOUTHWEST:
                if (currentTankPosX - 1 < BattleField.MARGIN) {
                    break;
                }
                currentTankPosX -= step;
                currentTankPosY += step;
                break;

            case NORTHEAST:
                if (currentTankPosX + 1 > (BattleField.WIDTH + BattleField.MARGIN - tankPos.getTankRectangle().getWidth())) {
                    break;
                }
                currentTankPosX += step;
                currentTankPosY -= step;
                break;

            case SOUTHEAST:
                if (currentTankPosX + 1 > (BattleField.WIDTH + BattleField.MARGIN - tankPos.getTankRectangle().getWidth())) {
                    break;
                }
                currentTankPosX += step;
                currentTankPosY += step;
                break;

            case NORTHWEST:
                if (currentTankPosX - 1 < BattleField.MARGIN) {
                    break;
                }
                currentTankPosX -= step;
                currentTankPosY -= step;
                break;
        }


        tankPos.getTankRectangle().translate(currentTankPosX - tankPos.getX(), currentTankPosY - tankPos.getY());

        tankPos.setX(currentTankPosX);
        tankPos.setY(currentTankPosY);

    }

    public int getDirection() {
        return direction;
    }

    public Position getTankPos() {
        return tankPos;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }


}