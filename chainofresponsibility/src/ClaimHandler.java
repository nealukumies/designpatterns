public class ClaimHandler extends FeedbackHandler {
    @Override
    public void process(Message message) {
        if (message.getMessageType() == MessageType.CLAIM) {
            System.out.println("Reviewing customer claim");
            System.out.println("Claim: " + message.getContent());
            int random = (int) (Math.random() * 10 + 1);
            if (random <= 5) {
                System.out.println("Claim accepted");
            } else {
                System.out.println("Claim rejected");
            }
            System.out.println("Replying response to claim to " + message.getEmail());
        } else {
            super.process(message);
        }
    }
}
