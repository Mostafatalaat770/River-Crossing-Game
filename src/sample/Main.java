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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage theStage) {
        Canvas instructionsCanvas = new Canvas(1080, 720);
        GraphicsContext instructionsGC = instructionsCanvas.getGraphicsContext2D();

        Controller controller = new Controller();

        theStage.setTitle("RiverCrossingGame");
        //adding all the widgets
        StackPane levelPane = new StackPane();
        Canvas levelCanvas = new Canvas(1080, 720);
        GraphicsContext levelGC = levelCanvas.getGraphicsContext2D();
        Canvas canvas = new Canvas(1080, 720);


        Button level1Button = new Button("Level 1");
        Button level2Button = new Button("Level 2");
        Button load = new Button("Load last save");
        Button next = new Button("Start game!");
        Button move = new Button("Move");
        Button undo = new Button("Undo");
        Button redo = new Button("Redo");
        Button save = new Button("Save Game");
        Button instructionsInGame = new Button("Instructions");
        Button reset = new Button("Reset Game");

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


        GridPane levelButtonsPane = new GridPane();
        levelButtonsPane.add(undo, 0, 0);
        levelButtonsPane.add(redo, 1, 0);
        levelButtonsPane.add(save, 2, 0);
        levelButtonsPane.add(instructionsInGame, 3, 0);
        levelButtonsPane.add(reset, 4, 0);
        levelButtonsPane.setHgap(5);
        levelButtonsPane.setAlignment(Pos.TOP_CENTER);

        GridPane moveBoat = new GridPane();
        moveBoat.add(move, 0, 0);
        moveBoat.setAlignment(Pos.BOTTOM_CENTER);

        GridPane levelMain = new GridPane();
        levelMain.add(moveBoat, 0, 0);
        moveBoat.setAlignment(Pos.BOTTOM_CENTER);
        levelMain.add(levelButtonsPane, 0, 1);



        //for the background========================================================================
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image background = new Image("Resources/river_crossing_background.png");
        ImageView backgroundImageView = new ImageView(background);
        //==========================================================================================

        //Creating level ==========================================================================
        levelPane.getChildren().add(levelCanvas);
//        levelPane.getChildren().add(levelButtonsPane);
//        levelPane.getChildren().add(moveBoat);
        levelPane.getChildren().add(levelMain);
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
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        Font theFont = Font.font("Arial Rounded MT Bold", 48);
        gc.setFont(theFont);
        gc.fillText("Welcome to River Crossing Game", 170, 50);
        gc.strokeText("Welcome to River Crossing Game", 170, 50);
        //==========================================================================================


        Scene levelScene = new Scene(levelPane);

        Text instrucionsInsideTheLevelText = new Text();
        Button instrucionsInsideTheLevelButton = new Button("back to game");
        GridPane instrucionsInsideTheLevelGridPane = new GridPane();
        instrucionsInsideTheLevelGridPane.add(instrucionsInsideTheLevelText, 0, 0);
        instrucionsInsideTheLevelGridPane.add(instrucionsInsideTheLevelButton, 0, 1);
        instrucionsInsideTheLevelGridPane.setAlignment(Pos.CENTER);
        Scene instrucionsInsideTheLevel = new Scene(instrucionsInsideTheLevelGridPane, 1080, 720);

        Button winButton = new Button("back to main menu");
        Text winText = new Text("YOU WIN!!!");
        GridPane winPane = new GridPane();
        winPane.add(winText, 0, 0);
        winPane.add(winButton, 0, 1);
        winPane.setAlignment(Pos.CENTER);
        Scene winScene = new Scene(winPane, 1080, 720);

        level1Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.level = controller.levelCreator.getLevel(1);
                //controller.levelID = 1;
                instructions.setText(controller.getInstructions()[0]);
                theStage.setScene(instructionScene);
            }
        });
        level2Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.level = controller.levelCreator.getLevel(2);
                //controller.levelID = 2;
                instructions.setText(controller.getInstructions()[0]);
                theStage.setScene(instructionScene);
            }
        });
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                theStage.setScene(levelScene);
                controller.newGame(controller.level);
                levelGC.drawImage(controller.boat.getImage(), 350, 300);
                controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);

            }

        });
        load.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.loadGame();
                //TODO : show levelScene immediately
                theStage.setScene(levelScene);
                controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);

            }
        });
        //dih el buttons kolaha ya sa7by=========================================================================================
        levelScene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                controller.index = controller.detectHitBox(controller.level.getInitialCrossers(), event.getSceneX(), event.getSceneY());
                if (controller.index != -1) {
                    //go to right bank crossers======================================================
                    if (controller.index >= controller.level.getInitialCrossers().size()) {
                        controller.index %= controller.level.getInitialCrossers().size();
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

        move.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                //TODO: canMove , isVaild , doMove
                if (controller.boatRaiders.size() != 0) {
                    if (controller.canMove(controller.boatRaiders, controller.boatOnTheLeftBank) && controller.level.isValid(controller.rightBankCrossers, controller.leftBankCrossers, controller.boatRaiders)) {
                        controller.doMove(controller.boatRaiders, controller.boatOnTheLeftBank);
                        if (controller.didIWin(controller.rightBankCrossers, controller)) {
                            theStage.setScene(winScene);
                        }
                        controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);
                    } else if (!controller.canMove(controller.boatRaiders, controller.boatOnTheLeftBank) || !controller.level.isValid(controller.rightBankCrossers, controller.leftBankCrossers, controller.boatRaiders)) {
                        if (controller.boatOnTheLeftBank) {
                            controller.returnThisDude(controller.leftBankCrossers, controller.boatRaiders);
                        } else {
                            controller.returnThisDude(controller.rightBankCrossers, controller.boatRaiders);

                        }
                        controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);
                        levelGC.setFill(Color.BLACK);
                        levelGC.setLineWidth(2);
                        Font theFont = Font.font("Arial Rounded MT Bold", 15);
                        levelGC.setFont(theFont);
                        levelGC.fillText("invalid move", 550, 50);

                    }
                }
            }

        });
        undo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (controller.canUndo()) {
                    controller.undo();
                    controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);
                } else {
                    controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);
                    levelGC.setFill(Color.BLACK);
                    levelGC.setLineWidth(2);
                    Font theFont = Font.font("Arial Rounded MT Bold", 15);
                    levelGC.setFont(theFont);
                    levelGC.fillText("can't undo", 550, 50);
                }
            }
        });
        redo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (controller.canRedo()) {
                    controller.redo();
                    controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);
                } else {
                    controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);
                    levelGC.setFill(Color.BLACK);
                    levelGC.setLineWidth(2);
                    Font theFont = Font.font("Arial Rounded MT Bold", 15);
                    levelGC.setFont(theFont);
                    levelGC.fillText("can't redo", 550, 50);
                }
            }
        });
        instructionsInGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO : pop a window showing instructions
            }
        });
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.saveGame();
            }
        });
        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.resetGame();
                controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);
            }
        });

        instructionsInGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                instrucionsInsideTheLevelText.setText(controller.getInstructions()[0]);
                theStage.setScene(instrucionsInsideTheLevel);
            }
        });
        instrucionsInsideTheLevelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                theStage.setScene(levelScene);
            }
        });
        winButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                theStage.setScene(theScene);
            }
        });


        theStage.show();
    }

}
