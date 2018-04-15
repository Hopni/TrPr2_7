package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

class SpecialController {
    private StringBuilder log;
    private TextArea logArea;
    private Label label;
    SpecialController(TextArea textArea, Label label){
        this.label = label;
        this.logArea = textArea;
        log = new StringBuilder();
    }
    void update(String s) {
        log.append("Pressed: ").append(s).append('\n');
        logArea.setText(log.toString());
        label.setText(s);
    }
}

class KeyObserver implements EventHandler<KeyEvent> {
    private SpecialController controller;

    KeyObserver(SpecialController controller) {
        this.controller = controller;
    }

    @Override
    public void handle(KeyEvent event){
        controller.update(event.getCode().getName());
    }
}


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Lab 7");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 900, 300);
        Label label = new Label();
        label.setFont(new Font(100));
        label.setPrefSize(700, 300);
        label.setAlignment(Pos.CENTER);
        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setPrefSize(200, 300);
        root.setRight(label);
        root.setLeft(textArea);
        root.autosize();
        label.autosize();
        textArea.autosize();
        SpecialController specialController = new SpecialController(textArea, label);
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new KeyObserver(specialController));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
