public class AFactory extends UIFactory{
    @Override
    public Button createButton(String text) {
        return new ButtonA(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldA(text);
    }

    @Override
    public Checkbox createCheckbox(String text, boolean checked) {
        return new CheckboxA(text, checked);
    }
}
