package command;

import view.GridController;

public class MoveCursorUpCommand implements Command {
    private GridController receiver;

    public MoveCursorUpCommand(GridController receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveCursorUp();
    }
}
