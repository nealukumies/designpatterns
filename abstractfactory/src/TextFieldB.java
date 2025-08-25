public class TextFieldB extends TextField {
    private String start;
    private String end;

    public TextFieldB(String text) {
        super(text);
        this.start = "<<<";
        this.end = ">>>";
    }
    @Override
    public void display() {
        System.out.println(start + text + end);
    }
}
