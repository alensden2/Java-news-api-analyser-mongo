package CodeC;

import APIAssets.Constants;
import java.io.*;

public class FileAccess {

  /**
   * Reads all the files and captures the data in a string from all the files
   */
  public String readAllFiles() {
    String dirPath = Constants.ALL_FILE_DIRECTORY;
    String filesContent = "";
    File dir = new File(dirPath);
    File[] files = dir.listFiles(
      (dir1, name) -> name.toLowerCase().endsWith(".txt")
    );
    for (File file : files) {
      BufferedReader reader = null;
      try {
        reader = new BufferedReader(new FileReader(file));
      } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
      }
      String line;
      while (true) {
        try {
          if (!((line = reader.readLine()) != null)) break;
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
        filesContent += line;
      }
      try {
        reader.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    return filesContent;
  }
}
