package CodeB;

import APIAssets.Constants;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataProcessing {
  WriteToFile writeToFile = new WriteToFile();
  String contentToBeWritten = "";

  List<String> keywords = Constants.SEARCH_KEYWORDS;

  /**
   * Iterates over the keywords and the respective headlines
   * */
  public void findFiveArticlesForKeywords(Map<String, String> apiData) {
    for (String s : keywords) {
      getNewsToFile(apiData.get(s), s);
    }
  }

  /**
   * This takes the headlines in the keyword and iterated over till it gets five headlines (or less in the case if less headlines)
   * Once this is done it saves the five headlines to the file
   * */
  public void getNewsToFile(String api_response, String key) {
    int totalArticles = 0;
    /**
     * To find the total articles in a file
     * This tells if the news for the keyword is having no articles
     * */
    Pattern totalArticlesPattern = Pattern.compile(Constants.TOTAL_ARTICLE_REGEX);
    Matcher totalArticlesMatcher = totalArticlesPattern.matcher(api_response);
    if (totalArticlesMatcher.find()) {
      totalArticles = Integer.parseInt(totalArticlesMatcher.group(1));
    }
    /** End */

    /**
     * Regex to extract the title
     * */
    Pattern titleExtractionRegex = Pattern.compile(
      Constants.TITLE_REGEX_PATTERN
    );

    /**
     * Regex to extract the content
     * */
    Pattern contentExtractionRegex = Pattern.compile(
      Constants.CONTENT_REGEX_PATTERN
    );
    Matcher titleMatcher = titleExtractionRegex.matcher(api_response);
    Matcher contentMatcher = contentExtractionRegex.matcher(api_response);

    /**
     * This loop saves the content and the title in the string,
     * this string is saved, it stops when it finds 5 or fewer headlines for a keyword
     * */
    int counter = 0;
    while (titleMatcher.find() && contentMatcher.find() && counter < Constants.FINAL_ARTICLE_PER_FILE) {
      String content = contentMatcher.group(1);
      String title = titleMatcher.group(1);
      if (content != null || !content.isEmpty()) {
        contentToBeWritten =
          contentToBeWritten +
          "Title: " +
          title +
          "\n" +
          "Content: " +
          content +
          "\n";
      }
      counter++;
    }
    /**
     * Creates a new file and saves the articles
     * It checks and only saves if the keyword has headlines
     * */
    if (
      contentToBeWritten != null ||
      !contentToBeWritten.isEmpty() ||
      !(contentToBeWritten == "")
    ) {
      if (totalArticles != 0) {
        String path = writeToFile.createNewFile(key);
        writeToFile.writetoNew(path, contentToBeWritten);
        contentToBeWritten = "";
      }
    }
  }
}
