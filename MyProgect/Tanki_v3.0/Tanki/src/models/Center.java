package models;

public class Center {
    private int X;
    private int Y;

    public Center(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void updateX(int deltaX) {
        X += deltaX;
    }

    public void updateY(int deltaY) {
        Y += deltaY;
    }
}
