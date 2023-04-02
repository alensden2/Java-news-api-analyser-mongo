package CodeA;

import APIAssets.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a Java Application that fetches data from a news api (https://newsapi.org/docs/endpoints/top-headlines)
 * And then processes the data by restricting the articles to five per keyword. It then processes it to remove any special
 * Characters and emoticons and stores it in a NOSQL MongoDB Database.
 *
 * @author Alen John
 * @version 1.0
 * @since Apr 02, 2023
 *
 * @see Java Docs reference - "https://www.tutorialspoint.com/java/java_documentation.htm"
 */
public class ExtractionEngine {
  ApiResponse apiResponse = new ApiResponse();
  List<String> keywords = Constants.SEARCH_KEYWORDS;
  Map<String, String> apiResponseFromCall = new HashMap<>();

  /**
   * This is the extraction engine
   * it loops through the keyword and stores the resulting response in the hashmap
   * the hashmap after the async call completes has all the headlines in the form
   * ( keyword -> NEWS )
   * @return this returns the news
   */
  public Map<String, String> getExtractionEngine() {
    for (String s : keywords) {
      apiResponse.setApiUrl(s);
      String response = apiResponse.getHeadlinesForKeyWord(s);
      apiResponseFromCall.put(s, response);
    }
    return apiResponseFromCall;
  }
}
