package CodeC;

import java.util.ArrayList;
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
public class CodeC {
  FileAccess fileAccess = new FileAccess();
  Transformation transformation = new Transformation();
  MongoAccess mongoAccess = new MongoAccess();
  String allContent = "";
  String transformedString = "";
  List<String> titles = new ArrayList<>();
  List<String> contents = new ArrayList<>();

  /**
   * This is the main class of the code C
   * The transformation engine.
   */
  public void runTransformationEngine() {
    allContent = fileAccess.readAllFiles();
    transformedString = transformation.transformSpecialChar(allContent);
    transformation.sortDataInList(transformedString);
    titles = transformation.getTitles();
    contents = transformation.getContents();
    mongoAccess.setupMongo();
    mongoAccess.insertToDatabase(titles, contents);
  }
}
