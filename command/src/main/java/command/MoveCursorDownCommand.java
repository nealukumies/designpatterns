package command;

import javafx.scene.layout.GridPane;
import view.GridController;

public class MoveCursorDownCommand implements Command {
    private GridController receiver;

    public MoveCursorDownCommand(GridController receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveCursorDown();
    }
}
