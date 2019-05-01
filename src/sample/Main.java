package sample;

import Levels.Level1;
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

    public void start(Stage theStage)
    {
        Level1 level1=new Level1();

        theStage.setTitle( "RiverCrossingGame" );
        //adding all the widgets
        StackPane level1Pane=new StackPane();
        Canvas levelCanvas = new Canvas(1080,720);
        GraphicsContext levelGC= levelCanvas.getGraphicsContext2D();
        Canvas canvas = new Canvas( 1080, 720 );


        Button level1Button = new Button("level 1");
        Button level2Button = new Button("level 2");
        Button load = new Button("load");
        Button next = new Button("next");
        Button move1left = new Button("move1l");
        Button move2left = new Button("move2l");
        Button move3left = new Button("move3l");
        Button move4left = new Button("move4l");
        Button move1Right = new Button("move1r");
        Button move4Right = new Button("move4r");
        Button move2Right = new Button("move2r");
        Button move3Right = new Button("move3r");
        Button moveBoat = new Button("move boat");

        GridPane leftButtons=new GridPane();
        leftButtons.add(move1left,0,0);
        leftButtons.add(move2left,0,1);
        leftButtons.add(move3left,0,2);
        leftButtons.add(move4left,0,3);
        leftButtons.setVgap(50);

        GridPane rightButtons=new GridPane();
        rightButtons.add(move1Right,0,0);
        rightButtons.add(move2Right,0,1);
        rightButtons.add(move3Right,0,2);
        rightButtons.add(move4Right,0,3);
        rightButtons.setVgap(50);

        Text instrctions1= new Text();
        Text instrctions2= new Text();
        Text instrctions3= new Text();
        Text instrctions4= new Text();
        Text instrctions5= new Text();


        //panes 3moomn
        GridPane StartPane=new GridPane();
        StartPane.add(level1Button,0,0);
        StartPane.add(level2Button,0,1);
        StartPane.add(load,0,2);
        StartPane.setAlignment(Pos.CENTER);

        GridPane instructionsPane=new GridPane();
        instructionsPane.add(instrctions1,0,0);
        instructionsPane.add(instrctions2,0,1);
        instructionsPane.add(instrctions3,0,2);
        instructionsPane.add(instrctions4,0,3);
        instructionsPane.add(instrctions5,0,4);
        instructionsPane.add(next,0,5);
        instructionsPane.setAlignment(Pos.CENTER);



        //for the background========================================================================
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image background = new Image( "Resources/river_crossing_background.png" );
        ImageView backgroundImageView=new ImageView(background);
        //==========================================================================================

        //Creating level 1==========================================================================
        level1Pane.getChildren().add(levelCanvas);
        level1Pane.getChildren().add(leftButtons);
        leftButtons.setAlignment(Pos.CENTER_LEFT);
        level1Pane.getChildren().add(rightButtons);
        rightButtons.setAlignment(Pos.CENTER_RIGHT);
        level1Pane.getChildren().add(moveBoat);
        StackPane.setAlignment(moveBoat, Pos.BOTTOM_CENTER);
        levelGC.drawImage(background,0,0);

        //==========================================================================================


        GridPane root = new GridPane();
        Scene theScene = new Scene( root ,1080,720);
        Scene instructionScene= new Scene(instructionsPane,1080,720);
        theStage.setScene( theScene );


        root.add(backgroundImageView,0,0);
        root.add(canvas,0,0);
        root.add(StartPane,0,0);

        //for the title of the word=================================================================
        gc.setFill( Color.RED );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
        gc.setFont( theFont );
        gc.fillText( "Welcome to River Crossing Game", 200, 50 );
        gc.strokeText( "Welcome to River Crossing Game", 200, 50 );
        //==========================================================================================


        Scene level1Scene=new Scene(level1Pane);

        level1Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                theStage.setScene(instructionScene);
            }
        });
        level2Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                theStage.setScene(instructionScene);
            }
        });
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            theStage.setScene(level1Scene);

            }

        });

        theStage.show();
    }
}
