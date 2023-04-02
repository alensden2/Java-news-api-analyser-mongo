package CodeB;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
public class WriteToFile {

  /**
   * Creates a file with the keyword and the timestamp
   * @param keyword This is the keyword
   * @return The path of the new file
   */
  public String createNewFile(String keyword) {
    LocalDateTime now = LocalDateTime.now();

    // Format the time string
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
      "yyyyMMdd_HHmmss"
    );
    String timestamp = now.format(formatter);

    // Create file name using the timestamp
    String fileName = "file_" + keyword + timestamp + ".txt";
    String path = "src/main/java/ArticlesFiles/" + fileName;
    File file = new File(path);
    try {
      file.createNewFile();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return path;
  }

  /**
   * Writes to the created file
   * @param path The path of the file
   * @param content the content to be written
   */
  public void writetoNew(String path, String content) {
    try {
      FileWriter writer = new FileWriter(path);
      writer.write(content);
      writer.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
