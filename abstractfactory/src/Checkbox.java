public abstract class Checkbox extends UIElement{
    protected boolean checked;
    public Checkbox(String text, boolean checked) {
        super(text);
        this.checked = checked;
    }
    public abstract void display();
}
