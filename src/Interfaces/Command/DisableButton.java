package Interfaces.Command;

/**
 * @author Mostafa Talaat
 */
public class DisableButton implements Command {

    javafx.scene.control.Button button;

    public DisableButton(javafx.scene.control.Button button) {
        this.button = button;
    }

    @Override
    public void execute() {
        button.setDisable(true);
    }
}
