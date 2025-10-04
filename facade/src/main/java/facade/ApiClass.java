package facade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiClass {

    public String getFromApi(String apiUrl, String attribute) throws Exception {
        try {
            new URL(apiUrl).toURI();
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid URL: " + apiUrl);
        }
        String jsonResult = getJsonFromApi(apiUrl);
        return extractAttributeFromJson(jsonResult, attribute);
    }

    public String getJsonFromApi(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            con.disconnect();
        }
    }

    public String extractAttributeFromJson(String jsonResult, String attribute) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(jsonResult);
        return (String) jsonObject.get(attribute);
    }
}


