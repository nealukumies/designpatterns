package mediator;

import component.Client;

import java.util.ArrayList;

public interface MediatorInterface {
    void sendMessage(String message, Client sender, Client recipient);
    void addUser(Client user);
    ArrayList<Client> getUsers();
}
