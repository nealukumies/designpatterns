package mediator;

import component.Client;

import java.util.ArrayList;

public class ChatMediator implements MediatorInterface {
    private ArrayList<Client> users;

    public ChatMediator() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(Client user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String message, Client sender, Client recipient) {
        if (recipient != null) {
            recipient.receiveMessage(sender.getUsername() + ": " + message);
        } else {
            //This is a broadcast message to all users except the sender
            for (Client user : users) {
                if (user != sender) {
                    user.receiveMessage(sender.getUsername() + ": " + message);
                }
            }
        }
    }

    public ArrayList<Client> getUsers() {
        return users;
    }
}
