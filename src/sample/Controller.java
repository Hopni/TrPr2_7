package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Controller {
    private StringBuilder log;
    @FXML private TextArea logArea;
    @FXML private Label label;
    @FXML private void initialize() {
        label.setText("");
        logArea.setText("");
        log = new StringBuilder();
    }
    void update(String s) {
        log.append("Pressed: ").append(s).append('\n');
        logArea.setText(log.toString());
        label.setText(s);
    }
}