package CodeB;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WriteToFile {

  /**
   * Creates a file with the keyword and the timestamp*/
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
   * */
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
