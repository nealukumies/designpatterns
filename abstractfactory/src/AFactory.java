public class AFactory extends UIFactory{
    @Override
    public ButtonA createButton(String text) {
        return new ButtonA(text);
    }

    @Override
    public TextFieldA createTextField(String text) {
        return new TextFieldA(text);
    }

    @Override
    public CheckboxA createCheckbox(String text, boolean checked) {
        return new CheckboxA(text, checked);
    }
}
