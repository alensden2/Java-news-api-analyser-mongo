package CodeC;

import APIAssets.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class Transformation {
  List<String> titles = new ArrayList<>();
  List<String> contents = new ArrayList<>();

  /**
   * Transforms the code and removes all the special chars
   */
  public String transformSpecialChar(String nonTransformedString) {
    // Remove all special characters except ":"
    Pattern pattern = Pattern.compile(Constants.CLEAN_STRING_REGEX);
    Matcher matcher = pattern.matcher(nonTransformedString);
    String cleanText = matcher.replaceAll("");
    return cleanText;
  }

  /**
   * Sorts the data into title and content and pushes it to a array to be stored in the
   * noSQL DB
   */
  public void sortDataInList(String transformedString) {
    String[] splitString = transformedString.split("Title:");
    for (int i = 1; i < splitString.length; i++) {
      String[] splitContent = splitString[i].split("Content:");
      String title = splitContent[0].trim();
      String content = splitContent[1].replaceAll("\\r\\n|\\r|\\n", "").trim();
      titles.add(title);
      contents.add(content);
    }
  }

  public List<String> getTitles() {
    return titles;
  }

  public List<String> getContents() {
    return contents;
  }
}
