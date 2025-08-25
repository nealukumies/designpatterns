public class ButtonB extends Button {
    private String start;
    private String end;

    public ButtonB(String text) {
        super(text);
        this.start = "< ";
        this.end = " >";
    }

    @Override
    public void display() {
        System.out.println(start + text + end);
    }
}
