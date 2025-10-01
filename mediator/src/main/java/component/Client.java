package component;

import mediator.MediatorInterface;

public class Client {
    private String username;
    private MediatorInterface mediator;
    private ClientWindowInterface clientWindow;

    public Client(String username, MediatorInterface mediator) {
        this.username = username;
        this.mediator = mediator;
        mediator.addUser(this);
    }

    public void setClientWindow(ClientWindowInterface clientWindow) {
        this.clientWindow = clientWindow;
    }

    public String getUsername() {
        return username;
    }

    public void receiveMessage(String message) {
        if (clientWindow != null) {
            clientWindow.displayMessage(message);
        } else {
            System.out.println("[" + username + "] " + message);
        }
    }

    public MediatorInterface getMediator() {
        return mediator;
    }
}
