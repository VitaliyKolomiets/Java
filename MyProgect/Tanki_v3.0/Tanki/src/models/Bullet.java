package models;

import java.util.Date;

public class Bullet extends GameObject {

    private static final String RESOURCES_SHOT_PNG = "resources/shot.png";
    private BaseTank shooter;
    private long lastMoveBullet;

    public Bullet(BaseTank shooter) {
        super(shooter.getX()+30, shooter.getY()+10, shooter.getRotation());
        this.shooter = shooter;
        lastMoveBullet = new Date().getTime();
        currentDirect = shooter.getCurrentDirect();
        rotateToDirect(currentDirect);
    }

    public BaseTank getShooter() {
        return shooter;
    }

    public void shoot() {
        move(currentDirect);
    }

    @Override
    void setImagePath() {
        imagePath = RESOURCES_SHOT_PNG;
    }

    @Override
    protected void setBoundingBox() {
        boundingBox = new BoundingBox(10, 10, 10, 10, center);
    }

    public long getLastMoveBullet() {
        return lastMoveBullet;
    }

    public void setLastMoveBullet(long lastMove) {
        this.lastMoveBullet = lastMove;
    }
}
