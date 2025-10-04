package facade;

public class Main {
    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();
        String apiUrl = "https://api.chucknorris.io/jokes/random";
        String attribute = "value";
        try {
            String joke = facade.getAttributeValue(apiUrl, attribute);
            System.out.println("Random Joke: " + joke);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
