package sample;

import Levels.Level1;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage theStage)
    {
        Level1 level1=new Level1();

        theStage.setTitle( "RiverCrossingGame" );
        //adding all the widgets
        Canvas canvas = new Canvas( 1080, 720 );
        Button level1Button = new Button("level 1");
        Button level2Button = new Button("level 2");
        Button load = new Button("load");
        Button next = new Button("next");

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
        Image test =new Image("sample/CAC.jpg",50,50,true,true);
        ImageView testView=new ImageView(test);
        //==========================================================================================


        GridPane root = new GridPane();
        Scene theScene = new Scene( root ,1080,720);
        Scene instructionScene= new Scene(instructionsPane,1080,720);
        theStage.setScene( theScene );


        root.add(backgroundImageView,0,0);
        root.add(canvas,0,0);
        root.add(StartPane,0,0);
        root.add(testView,0,1);


        //for the title of the word=================================================================
        gc.setFill( Color.RED );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
        gc.setFont( theFont );
        gc.fillText( "Welcome to River Crossing Game", 200, 50 );
        gc.strokeText( "Welcome to River Crossing Game", 200, 50 );
        //==========================================================================================

        level1Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                theStage.setScene(instructionScene);
                String[] instructions;
                instructions=level1.getInstructions();
                instrctions1.setText(instructions[0]);
                instrctions2.setText(instructions[1]);
                instrctions3.setText(instructions[2]);
                instrctions4.setText(instructions[3]);
                instrctions5.setText(instructions[4]);


            }
        });
        level2Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {


            }

        });


        testView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("fuck yea");
                theStage.setScene( theScene );

            }
        });
        theStage.show();
    }
}
