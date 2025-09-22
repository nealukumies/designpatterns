import java.util.HashMap;

public class Directory implements FileSystemElement{
    private String name;
    private HashMap<String, FileSystemElement> elements;

    public Directory(String name) {
        this.name = name;
        this.elements = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addElement(FileSystemElement element) {
        if (element instanceof File) {
            elements.put(((File) element).getName(), element);
        } else if (element instanceof Directory) {
            elements.put(((Directory) element).getName(), element);
        }
    }

    public HashMap<String, FileSystemElement> getElements() {
        return elements;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Directory{name='" + name + "'}";
    }
}
