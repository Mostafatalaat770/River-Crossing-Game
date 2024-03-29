package GUI;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

        Controller controller = new Controller();

        theStage.setTitle("RiverCrossingGame");
        //adding all the widgets
        StackPane levelPane = new StackPane();
        Canvas levelCanvas = new Canvas(1080, 720);
        GraphicsContext levelGC = levelCanvas.getGraphicsContext2D();
        Canvas canvas = new Canvas(1080, 720);


        Button level1Button = new Button("Level 1");
        Button level2Button = new Button("Level 2");
        Button level3Button = new Button("Level 3");
        Button load = new Button("Load last save");
        Button next = new Button("Start game!");
        Button move = new Button("Move");
        Button undo = new Button("Undo");
        Button redo = new Button("Redo");
        Button save = new Button("Save Game");
        Button instructionsInGame = new Button("Instructions");
        Button reset = new Button("Reset Game");
        Button emptyBoat = new Button("Empty Boat");

        Text instructions = new Text();

        Button winButton = new Button("Main Menu");
        Button mainMenu = new Button("Main Menu");
        Text winText = new Text("YOU WON!!!");
        GridPane winPane = new GridPane();
        winPane.add(winText, 0, 0);
        winPane.add(winButton, 0, 1);
        winPane.setAlignment(Pos.CENTER);
        Scene winScene = new Scene(winPane, 1080, 720);

        //panes 3moomn
        GridPane StartPane = new GridPane();
        StartPane.add(level1Button, 0, 0);
        StartPane.add(level2Button, 0, 1);
        StartPane.add(level3Button, 0, 2);
        StartPane.add(load, 0, 3);
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
        controller.executeButton(undo, false);
        controller.executeButton(redo, false);

        GridPane moveBoat = new GridPane();
        moveBoat.add(emptyBoat, 1, 0);
        moveBoat.add(mainMenu, 2, 0);
        moveBoat.add(move, 0, 0);
        moveBoat.setAlignment(Pos.BOTTOM_CENTER);
        moveBoat.setHgap(5);

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
        Button instrucionsInsideTheLevelButton = new Button("Back To Game");
        GridPane instrucionsInsideTheLevelGridPane = new GridPane();
        instrucionsInsideTheLevelGridPane.add(instrucionsInsideTheLevelText, 0, 0);
        instrucionsInsideTheLevelGridPane.add(instrucionsInsideTheLevelButton, 0, 1);
        instrucionsInsideTheLevelGridPane.setAlignment(Pos.CENTER);
        Scene instrucionsInsideTheLevel = new Scene(instrucionsInsideTheLevelGridPane, 1080, 720);


        level1Button.setOnAction(actionEvent -> {
            controller.level = controller.levelCreator.getLevel(1);
            instructions.setText(controller.getInstructions()[0]);
            theStage.setScene(instructionScene);
        });
        level2Button.setOnAction(actionEvent -> {
            controller.level = controller.levelCreator.getLevel(2);
            instructions.setText(controller.getInstructions()[0]);
            theStage.setScene(instructionScene);
        });
        level3Button.setOnAction(actionEvent -> {
            controller.level = controller.levelCreator.getLevel(3);
            instructions.setText(controller.getInstructions()[0]);
            theStage.setScene(instructionScene);
        });
        next.setOnAction(actionEvent -> {
            theStage.setScene(levelScene);
            controller.newGame(controller.level);
            controller.executeButton(undo, false);
            controller.executeButton(redo, false);
            levelGC.drawImage(controller.boat.getImage(), 350, 300);
            controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);

        });
        load.setOnAction(event -> {
            controller.loadGame();
            controller.executeButton(redo, false);
            controller.executeButton(undo, false);
            theStage.setScene(levelScene);
            controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);

        });
        //dih el buttons kolaha ya sa7by=========================================================================================
        levelScene.setOnMouseClicked(event -> {
            controller.index = controller.detectHitBox(controller.level.getInitialCrossers(), event.getSceneX(), event.getSceneY());
            if (controller.index != -1) {
                //go to right bank crossers======================================================
                if (controller.index >= controller.level.getInitialCrossers().size()) {
                    controller.index %= controller.level.getInitialCrossers().size();
                    if (controller.index < controller.rightBankCrossers.size()) {
                        if (!controller.boatOnTheLeftBank) {
                            controller.moveThisDude(controller.rightBankCrossers, controller.boatRaiders, controller.index);
                            controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);
                        }
                    }
                }
                //===============================================================================

                //go to left bank crossers=======================================================
                else if (controller.index < controller.level.getInitialCrossers().size()) {
                    if (controller.index < controller.leftBankCrossers.size()) {
                        if (controller.boatOnTheLeftBank) {
                            controller.moveThisDude(controller.leftBankCrossers, controller.boatRaiders, controller.index);
                            controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);
                        }
                    }
                }
                //==============================================================================
            }
        });
        //=========================================================================================================================

        move.setOnAction(actionEvent -> {

            if (controller.boatRaiders.size() != 0) {
                if (controller.canMove(controller.boatRaiders, controller.boatOnTheLeftBank) && controller.level.isValid(controller.rightBankCrossers, controller.leftBankCrossers, controller.boatRaiders)) {
                    controller.doMove(controller.boatRaiders, controller.boatOnTheLeftBank);
                    if (controller.didIWin(controller.rightBankCrossers, controller)) {
                        theStage.setScene(winScene);
                    }
                    controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);

                    controller.executeButton(undo, true);
                    controller.executeButton(redo, false);


                } else if (!controller.canMove(controller.boatRaiders, controller.boatOnTheLeftBank) || !controller.level.isValid(controller.rightBankCrossers, controller.leftBankCrossers, controller.boatRaiders)) {
                    if (controller.boatOnTheLeftBank) {
                        controller.returnThisDude(controller.leftBankCrossers, controller.boatRaiders);
                    } else {
                        controller.returnThisDude(controller.rightBankCrossers, controller.boatRaiders);

                    }
                    controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);
                    levelGC.setFill(Color.BLACK);
                    levelGC.setLineWidth(2);
                    Font theFont1 = Font.font("Arial Rounded MT Bold", 15);
                    levelGC.setFont(theFont1);
                    levelGC.fillText("Invalid Move!", 550, 50);

                }
            }
        });
        undo.setOnAction(event -> {
            if (controller.canUndo()) {
                controller.undo();
                controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);
                if (!controller.canUndo()) {
                    controller.executeButton(undo, false);
                    controller.executeButton(redo, true);
                } else {
                    controller.executeButton(undo, true);
                    controller.executeButton(redo, true);

                }
            } else {
                controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);
                levelGC.setFill(Color.BLACK);
                levelGC.setLineWidth(2);
                Font theFont12 = Font.font("Arial Rounded MT Bold", 15);
                levelGC.setFont(theFont12);
                levelGC.fillText("can't undo", 550, 50);
            }
        });
        redo.setOnAction(event -> {
            if (controller.canRedo()) {
                controller.redo();
                controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);
                if (!controller.canRedo()) {
                    controller.executeButton(redo, false);
                    controller.executeButton(undo, true);

                } else {
                    controller.executeButton(redo, true);
                    controller.executeButton(undo, true);

                }
            } else {
                controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);
                levelGC.setFill(Color.BLACK);
                levelGC.setLineWidth(2);
                Font theFont13 = Font.font("Arial Rounded MT Bold", 15);
                levelGC.setFont(theFont13);
                levelGC.fillText("can't redo", 550, 50);
            }
        });
        instructionsInGame.setOnAction(event -> {
        });
        save.setOnAction(event -> controller.saveGame());
        reset.setOnAction(event -> {
            controller.resetGame();
            controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);
            controller.executeButton(undo, false);
            controller.executeButton(redo, false);


        });

        instructionsInGame.setOnAction(event -> {
            instrucionsInsideTheLevelText.setText(controller.getInstructions()[0]);
            theStage.setScene(instrucionsInsideTheLevel);
        });
        instrucionsInsideTheLevelButton.setOnAction(event -> theStage.setScene(levelScene));
        winButton.setOnAction(event -> theStage.setScene(theScene));
        emptyBoat.setOnAction(event -> {
            if (controller.boatOnTheLeftBank) {
                controller.returnThisDude(controller.leftBankCrossers, controller.boatRaiders);
            } else {
                controller.returnThisDude(controller.rightBankCrossers, controller.boatRaiders);

            }
            controller.refreshAndDraw(controller.rightBankCrossers, controller.leftBankCrossers, levelGC, controller, background, controller.boatOnTheLeftBank, controller.boat.getImage(), controller.boatRaiders);

        });
        mainMenu.setOnAction(event -> theStage.setScene(theScene));

        theStage.show();
    }

}
