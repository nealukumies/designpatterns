package command;

// Command interface for executing actions
// The concrete command classes will implement this interface to perform specific actions
public interface Command {
    void execute();
}
