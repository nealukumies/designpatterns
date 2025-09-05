public class ContactHandler extends FeedbackHandler{
    @Override
    public void process(Message message) {
        if (message.getMessageType() == MessageType.CONTACT) {
            System.out.println("Responding to customer contact");
            System.out.println("Contact message: " + message.getContent());
            System.out.println("Replying response to contact to " + message.getEmail());
        } else {
            super.process(message);
        }
    }
}
