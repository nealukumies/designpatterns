public class SizeCalculatorVisitor implements FileSystemVisitor{

    private int totalSize;

    public void visit(File file) {
        totalSize += file.getSize();
    }

    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getElements().values()) {
            element.accept(this);
        }
    }

    public int getTotalSize() {
        return totalSize;
    }
}
