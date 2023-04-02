package CodeB;

import CodeC.CodeC;
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
/**
 * This is the driver code for the second class
 */
public class CodeB {
  Map<String, String> API_DATA;

  /**
   * This captures all the api data for further processing
   * @param apiData
   */
  public CodeB(Map<String, String> apiData) {
    API_DATA = apiData;
  }

  /**
   * This is the main data processing unit
   * This goes through the articles selects 5 and
   * stores then in the local storage in .txt files
   */
  public void sendApiDataToDataProcessing() {
    DataProcessing dataProcessing = new DataProcessing();
    dataProcessing.findFiveArticlesForKeywords(API_DATA);
    initiateCodeC();
  }

  /**
   * Initiate code C*/
  public void initiateCodeC() {
    CodeC codeC = new CodeC();
    codeC.runTransformationEngine();
  }
}
