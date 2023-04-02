package APIAssets;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;

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
public class Constants {
  public static final String API_URL_1 =
    "https://newsapi.org/v2/top-headlines?q=";
  public static final String API_URL_2 = "&apiKey=";
  public static final String TITLE_REGEX_PATTERN = "\"title\":\"([^\"]+)\"";
  public static final String CONTENT_REGEX_PATTERN = "\"content\":\"([^\"]+)\"";
  public static final String TOTAL_ARTICLE_REGEX = "\"totalResults\":(\\d+)";
  public static final int FINAL_ARTICLE_PER_FILE = 5;
  public static final String ALL_FILE_DIRECTORY = "src/main/java/ArticlesFiles";
  public static final String CLEAN_STRING_REGEX = "[^A-Za-z0-9: ]+";
  /**
   * FORMAT TO USE API STRING -
   * API_CALLED = API_URL_1+NEWS-HEADLINE+API_URL_2+API-KEY
   **/
  public static final List<String> SEARCH_KEYWORDS = Arrays.asList(
    "Canada",
    "University",
    "Dalhousie",
    "Halifax",
    "Canada Education",
    "Moncton",
    "hockey",
    "Fredericton",
    "celebration"
  );
}
