package CodeA;

import CodeB.CodeB;
import java.util.HashMap;
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
public class CodeA {

  /**
   * This is the main execution class for package A
   */
  public void codeA() {
    Map<String, String> apiResponse = new HashMap<>();
    ExtractionEngine extractionEngine = new ExtractionEngine();
    apiResponse = extractionEngine.getExtractionEngine();

    // code b hook
    CodeB codeB = new CodeB(apiResponse);
    codeB.sendApiDataToDataProcessing();
  }
}
