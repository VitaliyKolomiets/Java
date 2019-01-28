import gameController.Game;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import models.RotationDirect;

public class Main extends Application {


    private static double sizeFrameX;
    private static double sizeFrameY;
    private static double sizeFrameX0=100;
    private static double sizeFrameY0=100;




    @Override
    public void start(Stage primaryStage) throws InterruptedException {

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        Label l1= new Label("Name");
        Label l2= new Label("Password");
        TextField textArea1= new TextField();
        PasswordField textArea2= new PasswordField();
        Button btn = new Button("Enter");
        Button create = new Button("Create Account");
        HBox box=new HBox(10);
        box.setAlignment(Pos.BOTTOM_RIGHT);
        box.getChildren().add(btn);

        GridPane gridPane=new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25,25,25,25));



        Scene scene= new Scene(gridPane,screenBounds.getWidth(), screenBounds.getHeight()-25);


        btn.setOnAction(rotat ->{

             rotateImg(primaryStage);
        });
        create.setOnAction(rotat ->{
            createAccount(primaryStage);
        });

        gridPane.add(l1,0,0);
        gridPane.add(l2,0,1);
        gridPane.add(textArea1,1,0);
        gridPane.add(textArea2,1,1);
        gridPane.add(box,1,2);
        gridPane.add(create,1,2);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void createAccount(Stage primaryStage) {

    }

    private void rotateImg(Stage primaryStage) {


        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        Game game = Game.initGame();

        BorderPane root = new BorderPane();
        root.getChildren().add(game.getGroup());
        Scene scene = new Scene(root,screenBounds.getWidth(), screenBounds.getHeight()-25);
        scene.getStylesheets().add(getClass().getResource("resources/application.css").toExternalForm());

        sizeFrameX=scene.getWidth()-200;
        sizeFrameY=scene.getHeight()-200;

        System.out.println(scene.getWidth());
        System.out.println(scene.getHeight());
        KeyCombination left = new KeyCodeCombination(KeyCode.LEFT);
        KeyCombination right = new KeyCodeCombination(KeyCode.RIGHT);
        KeyCombination down = new KeyCodeCombination(KeyCode.DOWN);
        KeyCombination up = new KeyCodeCombination(KeyCode.UP);
        KeyCombination shot = new KeyCodeCombination(KeyCode.SPACE);

        scene.setOnKeyPressed(event -> {
            if (left.match(event)) {
                if (game.getPlayer().getX()>sizeFrameX0)
                    game.getPlayer().move(RotationDirect.Left);
            } else if (right.match(event)) {
                if (game.getPlayer().getX()<sizeFrameX)
                    game.getPlayer().move(RotationDirect.Right);
            } else if (up.match(event)) {
                if (game.getPlayer().getY()>sizeFrameY0)
                    game.getPlayer().move(RotationDirect.Up);
            } else if (down.match(event)) {
                if (game.getPlayer().getY()<sizeFrameY)
                    game.getPlayer().move(RotationDirect.Down);
            } else if (shot.match(event)) {
                game.playerShoot();
            }
        });

        AnimationTimer gameLoop = new AnimationTimer() {

            @Override
            public void handle(long now) {

                game.moveBullets(sizeFrameX,sizeFrameY, sizeFrameX0,sizeFrameY0);
                game.checkBulletsColliding();
              game.moveEnemy(sizeFrameX,sizeFrameY, sizeFrameX0,sizeFrameY0);
            }

        };
        try {

            primaryStage.setScene(scene);
            primaryStage.show();
            gameLoop.start();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}
