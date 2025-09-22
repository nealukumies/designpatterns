import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private List<FileSystemElement> foundElements;
    private String searchString;

    public SearchVisitor(String searchString) {
        this.foundElements = new ArrayList<>();
        this.searchString = searchString;
    }

    public void visit(File file) {
        if (search(file)) {;
            foundElements.add(file);
        }
    }

    public void visit(Directory directory) {
        if (search(directory)) {
            foundElements.add(directory);
        }
        for (FileSystemElement element : directory.getElements().values()) {
            element.accept(this);
        }
    }

    public boolean search(FileSystemElement element) {
        String lowerString = searchString.toLowerCase();
        return  element.getName().toLowerCase().contains(lowerString);
    }

    public List<FileSystemElement> getFoundElements() {
        return foundElements;
    }
}
