package CodeA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import APIAssets.Constants;

public class ExtractionEngine {
  ApiResponse apiResponse = new ApiResponse();
  List<String> keywords = Constants.SEARCH_KEYWORDS;
  Map<String, String> apiResponseFromCall = new HashMap<>();

  /**
   * This is the extraction engine
   * it loops through the keyword and stores the resulting response in the hashmap
   * the hashmap after the async call completes has all the headlines in the form
   * ( keyword -> NEWS )
   * */
  public Map<String, String> getExtractionEngine() {
    for (String s : keywords) {
      apiResponse.setApiUrl(s);
      String response = apiResponse.getHeadlinesForKeyWord(s);
      apiResponseFromCall.put(s, response);
    }
    return apiResponseFromCall;
  }
}
