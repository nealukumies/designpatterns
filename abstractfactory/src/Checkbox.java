public abstract class Checkbox {
    protected String text;
    protected boolean checked;
    public Checkbox(String text, boolean checked) {
        this.text = text;
        this.checked = checked;
    }
    public abstract void display();
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
