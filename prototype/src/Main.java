import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static Book createBookFromInput(){
        System.out.println("Enter book details (author, title, genre, publication year):");
        System.out.println("Enter author:");
        String author = scanner.nextLine();
        System.out.println("Enter title:");
        String title = scanner.nextLine();
        System.out.println("Choose genre: \n" +
                "1. FICTION\n" +
                "2. NON_FICTION\n" +
                "3. SCIENCE_FICTION\n" +
                "4. FANTASY\n" +
                "5. MYSTERY\n" +
                "6. BIOGRAPHY\n" +
                "7. HISTORY\n" +
                "8. CHILDREN\n");
        int genreChoice = scanner.nextInt();
        Genre genre = null;
        while (genre == null) {
            switch (genreChoice) {
                case 1 -> genre = Genre.FICTION;
                case 2 -> genre = Genre.NON_FICTION;
                case 3 -> genre = Genre.SCIENCE_FICTION;
                case 4 -> genre = Genre.FANTASY;
                case 5 -> genre = Genre.MYSTERY;
                case 6 -> genre = Genre.BIOGRAPHY;
                case 7 -> genre = Genre.HISTORY;
                case 8 -> genre = Genre.CHILDREN;
                default -> System.out.println("Invalid genre choice.");
            }
        }
        System.out.println("Enter publication year:");
        int publicationYear = scanner.nextInt();
        Book book = new Book(author, title, genre, publicationYear);
        System.out.println("Created book: " + book);
        return book;
    }

    private static TargetAudience askForTargetAudience() {
        System.out.println("Enter target audience:\n" +
                " 1. CHILDREN\n" +
                " 2. TEENS\n" +
                " 3. ADULTS\n" +
                " 4. SENIORS\n");
        TargetAudience targetAudience = null;
        while (targetAudience == null) {
            int audienceChoice = scanner.nextInt();
            switch (audienceChoice) {
                case 1 -> targetAudience = TargetAudience.CHILDREN;
                case 2 -> targetAudience = TargetAudience.TEENS;
                case 3 -> targetAudience = TargetAudience.ADULTS;
                case 4 -> targetAudience = TargetAudience.SENIORS;
                default -> System.out.println("Invalid audience choice. Try again.");
            }
        }
        return targetAudience;
    }

    private static void createRecommendation(RecommendationRegistry recommendationRegistry) {
        System.out.println("Creating a new Recommendation.");
        TargetAudience targetAudience = askForTargetAudience();
        Recommendation recommendation = new Recommendation(targetAudience);
        recommendationRegistry.addRecommendation(recommendation);
        System.out.println("Recommendation created: " + recommendation);
        System.out.println("Enter how many books to add:");
        int bookCount = scanner.nextInt();
        if (bookCount <= 0) {
            System.out.println("No books to add. Exiting.");
            return;
        }
        for (int i = 0; i < bookCount; i++) {
            System.out.println("Creating book " + (i + 1) + " of " + bookCount);
            Book book = createBookFromInput();
            recommendation.addBook(book);
        }
        System.out.println("Final recommendation: " + recommendation);
    }

    private static void cloneRecommendation(RecommendationRegistry recommendationRegistry) {
        System.out.println("Choose an existing recommendation.");
        int count = 1;
        for (Recommendation recommandation : recommendationRegistry.getAllRecommendations()) {
            System.out.println(count + ". " + recommandation);
            count++;
        }
        int choice = scanner.nextInt();
        if (choice < 1 || choice > recommendationRegistry.getAllRecommendations().size()) {
            System.out.println("Invalid choice. Exiting.");
            return;
        }
        Recommendation toClone = recommendationRegistry.getAllRecommendations().get(choice - 1);
        Recommendation clonedRecommendation = toClone.clone();
        recommendationRegistry.addRecommendation(clonedRecommendation);
        System.out.println("Cloned recommendation: " + clonedRecommendation);
        modifyCloneRecommendation(clonedRecommendation);
    }

    private static void modifyCloneRecommendation(Recommendation clonedRecommendation){
        System.out.println("You can choose to modify the cloned recommendation.");
        System.out.println("Choose action: 1 - Add Book, 2 - Remove Book, 3 - Change Target Audience, 0 - Exit");
        boolean modifying = true;
        while (modifying) {
            int modifyAction = scanner.nextInt();
            switch (modifyAction) {
                case 1:
                    System.out.println("Creating a new book to add to the cloned recommendation.");
                    Book newBook = createBookFromInput();
                    clonedRecommendation.addBook(newBook);
                    System.out.println("Book added. Updated cloned recommendation: " + clonedRecommendation);
                    break;
                case 2:
                    System.out.println("Choose a book to remove:");
                    int bookCountInClone = 1;
                    for (Book book : clonedRecommendation.getBooks()) {
                        System.out.println(bookCountInClone + ". " + book);
                        bookCountInClone++;
                    }
                    int bookChoice = -1;
                    while (bookChoice < 1 || bookChoice > clonedRecommendation.getBooks().size()) {
                        bookChoice = scanner.nextInt();
                        if (bookChoice < 1 || bookChoice > clonedRecommendation.getBooks().size()) {
                            System.out.println("Invalid book choice. Try again.");
                        }
                    }
                    Book bookToRemove = clonedRecommendation.getBooks().get(bookChoice - 1);
                    clonedRecommendation.removeBook(bookToRemove);
                    System.out.println("Book removed. Updated cloned recommendation: " + clonedRecommendation);
                    break;
                case 3:
                    TargetAudience newTargetAudience = askForTargetAudience();
                    clonedRecommendation.setTargetAudience(newTargetAudience);
                    System.out.println("Target audience changed. Updated cloned recommendation: " + clonedRecommendation);
                    break;
                case 0:
                    System.out.println("Exiting.");
                    modifying = false;
                    break;
                default:
                    System.out.println("Invalid action. Try again.");
                    break;
            }
        }
    }

    private static void initalizeRegistry(RecommendationRegistry recommendationRegistry) {
        Recommendation childrenRec = new Recommendation(TargetAudience.CHILDREN);
        childrenRec.addBook(new Book("Dr. Seuss", "The Cat in the Hat", Genre.CHILDREN, 1957));
        childrenRec.addBook(new Book("J.K. Rowling", "Harry Potter and the Sorcerer's Stone", Genre.FANTASY, 1997));
        recommendationRegistry.addRecommendation(childrenRec);

        Recommendation teensRec = new Recommendation(TargetAudience.TEENS);
        teensRec.addBook(new Book("Suzanne Collins", "The Hunger Games", Genre.SCIENCE_FICTION, 2008));
        teensRec.addBook(new Book("John Green", "The Fault in Our Stars", Genre.FICTION, 2012));
        recommendationRegistry.addRecommendation(teensRec);

        Recommendation adultsRec = new Recommendation(TargetAudience.ADULTS);
        adultsRec.addBook(new Book("George Orwell", "1984", Genre.SCIENCE_FICTION, 1949));
        adultsRec.addBook(new Book("Harper Lee", "To Kill a Mockingbird", Genre.FICTION, 1960));
        recommendationRegistry.addRecommendation(adultsRec);

        Recommendation seniorsRec = new Recommendation(TargetAudience.SENIORS);
        seniorsRec.addBook(new Book("Ernest Hemingway", "To Whom the Bell Tolls", Genre.FICTION, 1940));
        seniorsRec.addBook(new Book("Jane Austen", "Pride and Prejudice", Genre.FICTION, 1813));
        recommendationRegistry.addRecommendation(seniorsRec);
    }

    public static void main(String[] args) {
        RecommendationRegistry recommendationRegistry = new RecommendationRegistry();
        initalizeRegistry(recommendationRegistry);

        while (true) {
            System.out.println("Choose action: 1 - Recommendation, 2 - Clone Recommendation, 0 - Exit");
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    createRecommendation(recommendationRegistry);
                    break;
                case 2:
                    cloneRecommendation(recommendationRegistry);
                    break;
                case 0:
                    System.out.println("Exiting.");
                    return;
                default:
                    System.out.println("Invalid action. Try again.");
                    break;
            }
        }
    }
}
