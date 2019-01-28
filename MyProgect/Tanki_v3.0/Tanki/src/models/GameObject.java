package models;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class GameObject {
    private int rotation;
    private ImageView node;
    RotationDirect currentDirect;
    String imagePath;
    BoundingBox boundingBox;
    Center center;

    GameObject(int x, int y, int rotation) {
        center = new Center(x, y);
        this.rotation = rotation;
        currentDirect = RotationDirect.Right;
        setImagePath();
        initNode();
        rotateToDirect(RotationDirect.Right);
        setBoundingBox();
    }

    abstract void setImagePath();

    public Node getNode() {
        return node;
    }

    private void initNode() {
        node = new ImageView();
        node.setImage(new Image(imagePath));
        node.setRotate(rotation);
        node.setX(center.getX());
        node.setY(center.getY());
    }

    public void move(RotationDirect direct) {
        if (direct != currentDirect) {
            rotateToDirect(direct);
        }
        currentDirect = direct;

        switch (direct) {
            case Up:
                moveUp();
                break;
            case Down:
                moveDown();
                break;
            case Left:
                moveLeft();
                break;
            case Right:
                moveRight();
                break;
            default:
                throw new IllegalArgumentException("Can`t apply direction");
        }
    }

    protected void rotateToDirect(RotationDirect direct) {
        switch (direct) {
            case Up:
                rotation = 90;
                break;
            case Down:
                rotation = 270;
                break;
            case Left:
                rotation = 0;
                break;
            case Right:
                rotation = 180;
                break;
            default:
                throw new IllegalArgumentException("Can`t apply direction");
        }
        node.setRotate(rotation);
    }

    private void moveLeft() {
        this.center.updateX(-5);
        this.node.setX(center.getX());
    }

    private void moveRight() {
        this.center.updateX(5);
        this.node.setX(center.getX());
    }

    private void moveUp() {
        this.center.updateY(-5);
        this.node.setY(center.getY());
    }

    private void moveDown() {
        this.center.updateY(5);
        this.node.setY(center.getY());
    }

    public int getRotation() {
        return rotation;
    }

    public int getX() {
        return center.getX();
    }

    public int getY() {
        return center.getY();
    }

    public RotationDirect getCurrentDirect() {
        return currentDirect;
    }

    protected abstract void setBoundingBox();

  public boolean isColliding(BoundingBox boundingBox) {
      boolean fl=false;

         int deltaMinX=boundingBox.getCenter().getX()-boundingBox.getMinX();
         int deltaMaxX=boundingBox.getCenter().getX()+ boundingBox.getMaxX();
         int deltaMinY=boundingBox.getCenter().getY()-boundingBox.getMinY();
         int deltaMaxY=boundingBox.getCenter().getY()+boundingBox.getMaxY();

         int deltaMinXenemy=0;
         int deltaMaxXenemy=0;
         int deltaMinYenemy=0;
         int deltaMaxYenemy=0;


      if ((this.currentDirect==RotationDirect.Up)||((currentDirect==RotationDirect.Down))){
          System.out.println("up");
          deltaMinXenemy=getX()+30-this.boundingBox.getMinX();
          deltaMaxXenemy=getX()+30+this.boundingBox.getMaxX();
          deltaMinYenemy=getY()+33-this.boundingBox.getMinY();
          deltaMaxYenemy=getY()+33+this.boundingBox.getMaxY();

      }else
          if((currentDirect==RotationDirect.Right)||((currentDirect==RotationDirect.Left))){
              System.out.println("left");
          deltaMinXenemy=getX()+8-this.boundingBox.getMinX();
          deltaMaxXenemy=getX()+45+this.boundingBox.getMaxX();
          deltaMinYenemy=getY()+45-this.boundingBox.getMinY();
          deltaMaxYenemy=getY()+18+this.boundingBox.getMaxY();
      }
      System.out.println("deltaMinXenemy "+deltaMinXenemy+" deltaMinX "+deltaMinX);
      System.out.println("deltaMaxXenemy "+deltaMaxXenemy+" deltaMaxX "+deltaMaxX);
      System.out.println("deltaMinYenemy "+deltaMinYenemy+" deltaMinY "+deltaMinY);
      System.out.println("deltaMaxYenemy "+deltaMaxYenemy+" deltaMaxY "+deltaMaxY);


         if ((deltaMinXenemy>deltaMinX)&&(deltaMinXenemy<deltaMaxX)&&(deltaMinYenemy>deltaMinY)&&(deltaMinYenemy<deltaMaxY)){
             System.out.println("kill");
             fl=true;
         } else
         if ((deltaMinXenemy>deltaMinX)&&(deltaMinXenemy<deltaMaxX)&&(deltaMaxYenemy>deltaMinY)&&(deltaMaxYenemy<deltaMaxY)){
             System.out.println("kill");
             fl=true;
         } else
         if ((deltaMaxXenemy>deltaMinX)&&(deltaMaxXenemy<deltaMaxX)&&(deltaMinYenemy>deltaMinY)&&(deltaMinYenemy<deltaMaxY)){
             System.out.println("kill");
             fl=true;
         } else
         if ((deltaMaxXenemy>deltaMinX)&&(deltaMaxXenemy<deltaMaxX)&&(deltaMaxYenemy>deltaMinY)&&(deltaMaxYenemy<deltaMaxY)){
             System.out.println("kill");
             fl=true;
         }


      return fl;
  }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }
}
