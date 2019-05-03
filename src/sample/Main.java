package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage theStage) {
        Controller controller = new Controller();

        theStage.setTitle("RiverCrossingGame");
        //adding all the widgets
        StackPane level1Pane = new StackPane();
        Canvas levelCanvas = new Canvas(1080, 720);
        GraphicsContext levelGC = levelCanvas.getGraphicsContext2D();
        Canvas canvas = new Canvas(1080, 720);


        Button level1Button = new Button("level 1");
        Button level2Button = new Button("level 2");
        Button load = new Button("load");
        Button next = new Button("next");
        Button moveBoat = new Button("move boat");


        Text instructions = new Text();


        //panes 3moomn
        GridPane StartPane = new GridPane();
        StartPane.add(level1Button, 0, 0);
        StartPane.add(level2Button, 0, 1);
        StartPane.add(load, 0, 2);
        StartPane.setAlignment(Pos.CENTER);
        StartPane.setVgap(10);

        GridPane instructionsPane = new GridPane();
        instructionsPane.add(instructions, 0, 0);
        instructionsPane.add(next, 0, 5);
        instructionsPane.setAlignment(Pos.CENTER);


        //for the background========================================================================
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image background = new Image("Resources/river_crossing_background.png");
        ImageView backgroundImageView = new ImageView(background);
        //==========================================================================================

        //Creating level 1==========================================================================
        level1Pane.getChildren().add(levelCanvas);
        level1Pane.getChildren().add(moveBoat);
        StackPane.setAlignment(moveBoat, Pos.BOTTOM_CENTER);
        levelGC.drawImage(background, 0, 0);

        //==========================================================================================


        GridPane root = new GridPane();
        Scene theScene = new Scene(root, 1080, 720);
        Scene instructionScene = new Scene(instructionsPane, 1080, 720);
        theStage.setScene(theScene);


        root.add(backgroundImageView, 0, 0);
        root.add(canvas, 0, 0);
        root.add(StartPane, 0, 0);

        //for the title of the word=================================================================
        gc.setFill(Color.RED);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 48);
        gc.setFont(theFont);
        gc.fillText("Welcome to River Crossing Game", 200, 50);
        gc.strokeText("Welcome to River Crossing Game", 200, 50);
        //==========================================================================================


        Scene level1Scene = new Scene(level1Pane);

        level1Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.level = controller.levelCreator.getLevel(1);
                instructions.setText(controller.getInstructions()[0]);
                theStage.setScene(instructionScene);
            }
        });
        level2Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.level = controller.levelCreator.getLevel(2);
                instructions.setText(controller.getInstructions()[0]);
                theStage.setScene(instructionScene);
            }
        });
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                theStage.setScene(level1Scene);
                controller.newGame(controller.level);
                levelGC.drawImage(controller.boat.getImage(), 350, 300);
                controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);

            }

        });
        //dih el buttons kolaha ya sa7by=========================================================================================
        level1Scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

//                System.out.println(event.getSceneX());
//                System.out.println(event.getSceneY());
                controller.index = controller.detectHitBox(controller.level.getInitialCrossers(), event.getSceneX(), event.getSceneY());
                if (controller.index != -1) {
                    //go to right bank crossers======================================================
                    if (controller.index >= controller.level.getInitialCrossers().size()) {
                        controller.index %= controller.level.getInitialCrossers().size();
                        System.out.println(controller.index);
                        if (controller.index < controller.rightBankCrossers.size()) {
                            if (controller.boatOnTheLeftBank == false) {
                                controller.moveThisDude(controller.rightBankCrossers, controller.boatRaiders, controller.index);
                                controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);
                            }
                        }
                    }
                    //===============================================================================

                    //go to left bank crossers=======================================================
                    else if (controller.index < controller.level.getInitialCrossers().size()) {
                        System.out.println(controller.index);
                        if (controller.index < controller.leftBankCrossers.size()) {
                            if (controller.boatOnTheLeftBank == true) {
                                controller.moveThisDude(controller.leftBankCrossers, controller.boatRaiders, controller.index);
                                controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);
                            }
                        }
                    }
                    //==============================================================================
                }
            }
        });
        //=========================================================================================================================

        moveBoat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                //TODO: canMove , isVaild , doMove
            }

        });

        theStage.show();
    }

}
