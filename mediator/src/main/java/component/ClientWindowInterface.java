package component;

// This interface is not part of the meediator pattern itself,
// but it is used to simulate a client window for displaying messages.
// Without this interface, clients would only be able to print messages to the console.
public interface ClientWindowInterface {
    void displayMessage(String message);
}
