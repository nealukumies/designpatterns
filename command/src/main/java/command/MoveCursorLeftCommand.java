package command;

import view.GridController;

public class MoveCursorLeftCommand implements Command {
    private GridController receiver;

    public MoveCursorLeftCommand(GridController receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveCursorLeft();
    }
}
