package CodeA;

import APIAssets.Constants;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public class ApiResponse {
  String url1 = Constants.API_URL_1;
  String url2 = Constants.API_URL_2;
  String API_ENDPOINT = null;
  String api_key = null;

  /**
   * Sets the url for the api
   * using the keywords and the api keys
   * sets the method and then sets URL
   */
  public void setApiUrl(String keyword) {
    Properties props = new Properties();
    try {
      FileInputStream input = new FileInputStream(
        "src/main/java/APIAssets/keys.prop"
      );
      props.load(input);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    api_key = props.getProperty("API_KEYS");
    API_ENDPOINT = url1 + keyword + url2 + api_key;
  }

  /**
   * Gets the response of the entire api call in a string and
   * returns that string
   */
  public String getHeadlinesForKeyWord(String keyword) {
    String response = "";
    try {
      URL url = new URL(API_ENDPOINT);
      HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
      httpURLConnection.setRequestMethod("GET");
      httpURLConnection.setRequestProperty("User-Agent", "Java/1.8");
      InputStream inputStream = httpURLConnection.getInputStream();
      byte[] responseInByes = inputStream.readAllBytes();
      response = new String(responseInByes);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return response;
  }
}
