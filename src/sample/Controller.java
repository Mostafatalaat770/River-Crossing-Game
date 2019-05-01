package sample;

import Levels.Level1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {
    Level1 level1=new Level1();
    @FXML private Text instructionsText1=new Text();
    @FXML private Text instructionsText2=new Text();
    @FXML private Text instructionsText3=new Text();
    @FXML private Text instructionsText4=new Text();
    @FXML private Text instructionsText5=new Text();
    String[] instrctions= new String[5];
    public void handleLevel1ButtonClick(ActionEvent event) throws IOException {
        Parent LoginScreen= FXMLLoader.load(getClass().getResource("InstructionsPage.fxml"));
        Scene Loginscene = new Scene(LoginScreen);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();

    }

    public void handleShowInstructionsButtonClick(ActionEvent event) {
        instrctions=level1.getInstructions();
        instructionsText1.setText(instrctions[0]);
        instructionsText2.setText(instrctions[1]);
        instructionsText3.setText(instrctions[2]);
        instructionsText4.setText(instrctions[3]);
        instructionsText5.setText(instrctions[4]);
    }
}
