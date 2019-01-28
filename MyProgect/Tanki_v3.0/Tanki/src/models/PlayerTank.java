package models;

public class PlayerTank extends BaseTank {

    private static final String RESOURCES_T2_PNG = "resources/t1.png";

    public PlayerTank(int x, int y, int rotation) {
        super(x, y, rotation);
    }

    @Override
    void setImagePath() {
        imagePath = RESOURCES_T2_PNG;
    }

    @Override
    protected void setBoundingBox() {
        boundingBox = new BoundingBox(5, 5, 5, 5, center);
    }
}
