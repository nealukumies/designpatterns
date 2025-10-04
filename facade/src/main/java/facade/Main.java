package facade;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();
        System.out.println("Facade Pattern with API Call");
        System.out.println("Fetching a random Chuck Norris joke from the API...");
        String apiUrl = "https://api.chucknorris.io/jokes/random";
        String attribute = "value";
        try {
            String joke = facade.getAttributeValue(apiUrl, attribute);
            System.out.println("Random Joke: " + joke);
        } catch (IllegalArgumentException e) {
            System.out.println("The provided URL is invalid.");
        } catch (IOException e) {
            System.out.println("There was an error fetching data from the API: " + e.getMessage());
        }

        System.out.println("Fetching latest exchange rate from USD to EUR...");
        String apiUrl2 = "https://api.fxratesapi.com/latest";
        String attribute2 = "rates.EUR";
        try{
            String rate = facade.getAttributeValue(apiUrl2, attribute2);
            System.out.println("Latest USD to EUR exchange rate: " + rate);
        } catch (IllegalArgumentException e) {
            System.out.println("The provided URL is invalid.");
        } catch (IOException e) {
            System.out.println("There was an error fetching data from the API: " + e.getMessage());
        }
    }
}
