public class CheckboxA extends Checkbox {

    public CheckboxA(String text, boolean checked) {
        super(text, checked);
    }

    @Override
    public void display() {
        if (checked) {
        System.out.println("[x] " + text);}
        else {
            System.out.println("[ ] " + text);
        }
    }
}
