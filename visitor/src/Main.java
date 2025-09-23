public class Main {
    public static void main(String[] args) {
        FileSystemElement file1 = new File("file1.txt", 100);
        FileSystemElement file2 = new File("file2.txt", 200);
        FileSystemElement file3 = new File("file3.txt", 300);
        FileSystemElement file4 = new File("file4.txt", 400);
        FileSystemElement file5 = new File("löydätkö.txt", 500);
        Directory dir = new Directory("First Directory");
        Directory dir2 = new Directory("Second Directory");
        Directory dir3 = new Directory("Third Directory");
        dir.addElement(file1);
        dir.addElement(file2);
        dir.addElement(dir2);
        dir2.addElement(file3);
        dir2.addElement(file4);
        dir2.addElement(dir3);
        dir3.addElement(file5);

        FileSystemVisitor sizeVisitor = new SizeCalculatorVisitor();
        dir.accept(sizeVisitor);
        System.out.println("Total size: " + ((SizeCalculatorVisitor) sizeVisitor).getTotalSize() + " MB");

        FileSystemVisitor searchVisitor1 = new SearchVisitor("i");
        dir.accept(searchVisitor1);
        System.out.println("Found files: " + ((SearchVisitor) searchVisitor1).getFoundElements());

        FileSystemVisitor searchVisitor2 = new SearchVisitor("dir");
        dir.accept(searchVisitor2);
        System.out.println("Found files: " + ((SearchVisitor) searchVisitor2).getFoundElements());

        FileSystemVisitor searchVisitor3 = new SearchVisitor("ö");
        dir.accept(searchVisitor3);
        System.out.println("Found files: " + ((SearchVisitor) searchVisitor3).getFoundElements());
   }
}
