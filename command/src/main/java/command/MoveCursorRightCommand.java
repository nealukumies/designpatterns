package command;

import view.GridController;

public class MoveCursorRightCommand implements Command {
    private GridController receiver;

    public MoveCursorRightCommand(GridController receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveCursorRight();
    }
}
