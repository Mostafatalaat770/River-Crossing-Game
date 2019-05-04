package Interfaces.Command;

/**
 * @author Mostafa Talaat
 */
public class EnableButton implements Command {

    javafx.scene.control.Button button;

    public EnableButton(javafx.scene.control.Button button) {
        this.button = button;
    }

    @Override
    public void execute() {
        button.setDisable(false);
    }
}
