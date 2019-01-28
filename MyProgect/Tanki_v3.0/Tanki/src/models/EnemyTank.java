package models;

import java.util.Random;

public class EnemyTank extends BaseTank {

    private static final String RESOURCES_T1_PNG = "resources/t22.png";
    private long lastMove;
    private int flafEnemy=0;
    private RotationDirect RotationDirectEnmy =RotationDirect.Right;


    public EnemyTank(int x, int y, int rotation) {
        super(x, y, rotation);
    }

    /*    @Override
    protected void setBoundingBox() {
        boundingBox = new BoundingBox(5, 55, 10, 83, center);
    }*/


    @Override
    protected void setBoundingBox() {
        boundingBox = new BoundingBox(25, 25, 47, 47, center);
    }

    public void setRotationDirectEnmy(RotationDirect rotationDirectEnmy) {
        RotationDirectEnmy = rotationDirectEnmy;
    }

    public RotationDirect getRotationDirectEnmy() {
        return RotationDirectEnmy;
    }

    @Override
    void setImagePath() {
        imagePath = RESOURCES_T1_PNG;
    }

    public void randomMove(RotationDirect rotationDirect) {
        move(rotationDirect);
    }


    public int getFlafEnemy() {
        return flafEnemy;
    }

    public void setFlafEnemy(int flafEnemy) {
        this.flafEnemy = flafEnemy;
    }


    public long getLastMove() {
        return lastMove;
    }
    public void setLastMove(long lastMove) {
        this.lastMove = lastMove;
    }
}
