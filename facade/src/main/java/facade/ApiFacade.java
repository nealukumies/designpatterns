package facade;

import java.io.IOException;

public class ApiFacade {
    public String getAttributeValue(String apiUrl, String attribute) throws IllegalArgumentException, IOException {
        ApiClass apiClass = new ApiClass();
        try {
            return apiClass.getFromApi(apiUrl, attribute);
        } catch (IllegalArgumentException e) {
            throw e; //Client sees IllegalArgumentException directly (invalid URL)
        } catch (IOException e) {
            throw e; //Client sees IOException directly (for network issues)
        } catch (Exception e) {
            throw new IOException("Error fetching data from API: " + e.getMessage()); // Client sees IOException for other exceptions (for example JSON parsing issues)
        }
    }
}
