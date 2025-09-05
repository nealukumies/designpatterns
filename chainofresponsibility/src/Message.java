public class Message {

    private String content;
    private String email;
    private MessageType messageType;

    public Message(String content, String email, MessageType messageType){
        this.content = content;
        this.email = email;
        this.messageType = messageType;
    }

    public String getContent(){
        return content;
    }
    public String getEmail(){
        return email;
    }
    public MessageType getMessageType(){
        return messageType;
    }


}
