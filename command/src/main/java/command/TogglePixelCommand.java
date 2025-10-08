package command;

public class TogglePixelCommand implements Command {
    private view.GridController receiver;

    public TogglePixelCommand(view.GridController receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.toggleCell();
    }
}
