public class Main {
    public static void main(String[] args) {
        Message claimMessage = new Message("I want refund for my chair", "claimer@claim.fi", MessageType.CLAIM);
        Message contactMessage = new Message("I want the head of sales to contact me", "contact@contact.fi", MessageType.CONTACT);
        Message suggestionMessage = new Message("I think your door should be painted blue", "suggestion@suggestion.fi", MessageType.SUGGESTION);
        Message generalMessage = new Message("I´m just writing in general that your company makes me happy", "general@general.fi", MessageType.GENERAL);

        FeedbackHandler claimHandler = new ClaimHandler();
        FeedbackHandler contactHandler = new ContactHandler();
        FeedbackHandler suggestionHandler = new SuggestionHandler();
        FeedbackHandler generalHandler = new GeneralHandler();

        claimHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(generalHandler);

        System.out.println("--- Claim Message ---");
        claimHandler.process(claimMessage);
        System.out.println("\n--- Contact Message ---");
        claimHandler.process(contactMessage);
        System.out.println("\n--- Suggestion Message ---");
        claimHandler.process(suggestionMessage);
        System.out.println("\n--- General Message ---");
        claimHandler.process(generalMessage);


    }
}