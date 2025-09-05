abstract class FeedbackHandler {
    private FeedbackHandler nextHandler;

    public void process(Message message){
        if (nextHandler != null) {
            nextHandler.process(message);
        }
    }

    public void setNextHandler(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
