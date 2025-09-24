import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Part> parts;

    public Computer() {
        this.parts = new ArrayList<>();
    }

    public void addPart(Part part) {
        parts.add(part);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Part part : parts) {
            sb.append(part.getName());
            sb.append("\n");
        }
        return sb.toString();
    }
}
