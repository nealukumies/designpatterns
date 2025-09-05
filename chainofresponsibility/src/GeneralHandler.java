public class GeneralHandler extends FeedbackHandler {
    @Override
    public void process(Message message) {
        if (message.getMessageType() == MessageType.GENERAL) {
            System.out.println("Reviewing general feedback");
            System.out.println("General message: " + message.getContent());
            System.out.println("Logging general feedback for records");
            System.out.println("Analyzing if any action is needed");
            System.out.println("Replying response to general feedback to " + message.getEmail());
        } else {
            super.process(message);
        }
    }
}
