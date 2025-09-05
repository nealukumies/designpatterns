public class SuggestionHandler extends FeedbackHandler {
    @Override
    public void process(Message message) {
        if (message.getMessageType() == MessageType.SUGGESTION) {
            System.out.println("Reviewing customer suggestion");
            System.out.println("Suggestion: " + message.getContent());
            int random = (int) (Math.random() * 10 + 1);
            if (random <= 3) {
                System.out.println("Suggestion priority: High");
            } else if (random <= 7) {
                System.out.println("Suggestion priority: Medium");
            } else {
            System.out.println("Suggestion priority: " + "Low");
            }
            System.out.println("Forwarding suggestion to product team");
            System.out.println("Replying response to suggestion to " + message.getEmail());
        } else {
            super.process(message);
        }
    }
}
