package component;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mediator.ChatMediator;
import mediator.MediatorInterface;


public class ClientWindow extends Application implements ClientWindowInterface{
    public void start(Stage stage) {
        MediatorInterface mediator = new ChatMediator();
        Client pelle = new Client("Muumipeikko", mediator);
        Client anna  = new Client("Niiskuneiti", mediator);
        Client bob   = new Client("Pikkumyy", mediator);

        createWindow(pelle, stage, 100, 100);
        createWindow(anna, new Stage(), 750, 100);
        createWindow(bob, new Stage(), 400, 400);
    }

    @Override
    public void displayMessage(String message) {
        // Metho is implemented in createWindow for each client so each client´s chat area is updated
    }

    public void createWindow(Client client, Stage stage, double x, double y) {

        Label textAreaLabel = new Label("Messages:");
        TextArea chatArea = new TextArea();
        client.setClientWindow(new ClientWindowInterface() {
            @Override
            public void displayMessage(String message) {
                chatArea.appendText(message + "\n");
            }
        });
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.getChildren().addAll(textAreaLabel, chatArea);

        Label messageLabel = new Label("New message:");
        TextField message = new TextField();
        HBox hBox2 = new HBox();
        hBox2.setSpacing(10);
        hBox2.getChildren().addAll(messageLabel, message);

        Label recipientLabel = new Label("Recipient:");
        ComboBox<Client> recipient = new ComboBox<>();
        recipient.getItems().addAll(client.getMediator().getUsers());
        recipient.getItems().add(0, null); // null represents broadcast
        recipient.setPromptText("Send to all");
        recipient.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Client item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item == null ? "All" : item.getUsername());
            }
        });
        recipient.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Client item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item == null ? "All" : item.getUsername());
            }
        });
        recipient.getSelectionModel().selectFirst();
        HBox hBox3 = new HBox();
        hBox3.setSpacing(10);
        hBox3.getChildren().addAll(recipientLabel, recipient);

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        Button send = new Button("Send");
        send.setOnAction(event -> {
            Client rec = recipient.getValue();
            String msg = message.getText();
            if (!msg.isEmpty()) {
                client.getMediator().sendMessage(msg, client, rec);
                message.clear();
            }
        });
        vBox.getChildren().addAll(hBox, hBox2, hBox3, send);

        stage.setTitle(client.getUsername());
        stage.setScene(new Scene(vBox, 600, 250));
        stage.setX(x);
        stage.setY(y);
        stage.show();
    }


}
