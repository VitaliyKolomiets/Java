package gameController;

import com.sun.tools.javac.Main;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import models.*;

import java.util.*;

public class Game {
    private Group group = new Group();
    private PlayerTank player;
    private List<EnemyTank> enemyTanks = new ArrayList<>();
    private volatile List<Bullet> bullets = new ArrayList<>();
    private boolean gameOver = false;
    private int speedEnemy = 200;
    private int bulletSpeed = 20;

    public static Game initGame() {

        Game game = new Game();
        game.addEnemyTanks();
        game.addEnemyTanks();
        game.addEnemyTanks();
        game.addEnemyTanks();
        game.addEnemyTanks();
        game.addPlayerTanks();

        return game;
    }

    public Group getGroup() {
        return group;
    }



    public synchronized void moveEnemy(double sizeFrameX, double sizeFrameY,double sizeFrameX0, double sizeFrameY0) {

        ListIterator<EnemyTank> enemyTankListIterator = enemyTanks.listIterator();
        while (enemyTankListIterator.hasNext()) {
            EnemyTank enemyTank = enemyTankListIterator.next();
            long currentTime = new Date().getTime();
            if (currentTime - enemyTank.getLastMove() > speedEnemy) {
                enemyTank.setLastMove(currentTime);
                if(enemyTank.getFlafEnemy()<new Random().nextInt(16)+5){
                    enemyTank.setFlafEnemy(enemyTank.getFlafEnemy()+1);
                    if ((enemyTank.getX()>sizeFrameX0)&&(enemyTank.getX()<sizeFrameX)&&(enemyTank.getY()<sizeFrameY)&&(enemyTank.getY()>sizeFrameX0)){
                        enemyTank.randomMove(enemyTank.getRotationDirectEnmy());
                        //shoot(enemyTank);
                    }
                    else {
                        if(enemyTank.getX()<=sizeFrameX0){
                            enemyTank.setRotationDirectEnmy(RotationDirect.Right);
                            enemyTank.randomMove(enemyTank.getRotationDirectEnmy());
                        } else
                        if(enemyTank.getX()>=sizeFrameX){
                            enemyTank.setRotationDirectEnmy(RotationDirect.Left);
                            enemyTank.randomMove(enemyTank.getRotationDirectEnmy());
                        } else
                        if(enemyTank.getY()<=sizeFrameY0){
                            enemyTank.setRotationDirectEnmy(RotationDirect.Down);
                            enemyTank.randomMove(enemyTank.getRotationDirectEnmy());
                        } else
                        if(enemyTank.getY()>=sizeFrameY){
                            enemyTank.setRotationDirectEnmy(RotationDirect.Up);
                            enemyTank.randomMove(enemyTank.getRotationDirectEnmy());
                        }
                    }
                }else {
                    enemyTank.setRotationDirectEnmy(RotationDirect.values()[new Random().nextInt(4)]);
                    enemyTank.setFlafEnemy(0);
                }
            }
        }
    }

    public synchronized void moveBullets(double sizeFrameX, double sizeFrameY,double sizeFrameX0, double sizeFrameY0) {


        ListIterator<Bullet> bulletsIterator = bullets.listIterator();
        while (bulletsIterator.hasNext()) {
            Bullet bullet = bulletsIterator.next();
            long currentTime = new Date().getTime();
            if (currentTime - bullet.getLastMoveBullet() > bulletSpeed) {
                bullet.setLastMoveBullet(currentTime);
                bullet.shoot();
                if(bullet.getX()<sizeFrameX0){
                    group.getChildren().remove(bullet.getNode());
                    bulletsIterator.remove();
                } else
                if(bullet.getX()>sizeFrameX){
                    group.getChildren().remove(bullet.getNode());
                    bulletsIterator.remove();

                } else
                if(bullet.getY()<sizeFrameY0){
                    group.getChildren().remove(bullet.getNode());
                    bulletsIterator.remove();

                } else
                if(bullet.getY()>sizeFrameY){
                    group.getChildren().remove(bullet.getNode());
                    bulletsIterator.remove();
                }

            }
        }
    }

    private void addEnemyTanks() {
        EnemyTank tank = new EnemyTank(new Random().nextInt(200)+200, new Random().nextInt(200) + 200, 0);
        addToGroup(tank);
        enemyTanks.add(tank);
    }

    private void addPlayerTanks() {
        PlayerTank playerTank = new PlayerTank(500, 500, 0);
        addToGroup(playerTank);
        this.player = playerTank;
    }



    public void checkBulletsColliding() {
        Iterator<Bullet> bulletsIterator = bullets.iterator();
        while (bulletsIterator.hasNext()) {
            Bullet bullet = bulletsIterator.next();
            Iterator<EnemyTank> enemyTanksIterator = enemyTanks.iterator();
            while (enemyTanksIterator.hasNext()) {
                EnemyTank currentEnemy = enemyTanksIterator.next();
                if (currentEnemy.isColliding(bullet.getBoundingBox())) {
                    group.getChildren().removeAll(bullet.getNode(),currentEnemy.getNode());
                    bulletsIterator.remove();
                    enemyTanksIterator.remove();
                }
            }
        }
    }

    public void shoot(BaseTank shooter) {
        Bullet bullet = new Bullet(shooter);
        addToGroup(bullet);
        bullets.add(bullet);
    }


    public void playerShoot() {
        shoot(player);
    }

    public PlayerTank getPlayer() {
        return player;
    }

    public synchronized void addToGroup(GameObject gameObject) {
        group.getChildren().add(gameObject.getNode());
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
