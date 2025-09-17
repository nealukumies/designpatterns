import java.util.Date;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private Date creationDate;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        System.out.println("Memento created");
        this.creationDate = new Date();
    }

    public int[] getOptions() {
        return options;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}