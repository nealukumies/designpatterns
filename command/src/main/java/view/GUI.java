package view;

import command.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//This is the invoker class that sets up the GUI and binds commands to user actions.
//Holds references to command objects and executes them based on user input.
//In this setup this is also the client of command pattern.
public class GUI extends Application {
    private GridController receiver;

    @Override
    public void start(Stage stage) {
        receiver = new GridController();
        Command moveUpCommand = new MoveCursorUpCommand(receiver);
        Command moveDownCommand = new MoveCursorDownCommand(receiver);
        Command moveLeftCommand = new MoveCursorLeftCommand(receiver);
        Command moveRightCommand = new MoveCursorRightCommand(receiver);
        Command togglePixelCommand = new TogglePixelCommand(receiver);
        Command generateDataCommand = new GenerateCodeCommand(receiver);

        GridPane grid = receiver.buildGruid();

        Button button = new Button("Get Pixel Data");
        button.setFocusTraversable(false);
        button.setOnAction(e -> generateDataCommand.execute());
        BorderPane pane = new BorderPane(grid, null, null, button, null);
        pane.setAlignment(button, Pos.BOTTOM_LEFT);
        Scene scene = new Scene(pane);

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP -> moveUpCommand.execute();
                case DOWN -> moveDownCommand.execute();
                case LEFT -> moveLeftCommand.execute();
                case RIGHT -> moveRightCommand.execute();
                case SPACE -> togglePixelCommand.execute();
                default -> {
                }
            }
        });

        stage.setScene(scene);
        stage.setTitle("Command Pattern with Pixel Grid");
        stage.show();
        grid.requestFocus();
    }
}
