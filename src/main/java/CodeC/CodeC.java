package CodeC;

import java.util.ArrayList;
import java.util.List;

public class CodeC {
  FileAccess fileAccess = new FileAccess();
  Transformation transformation = new Transformation();
  MongoAccess mongoAccess = new MongoAccess();
  String allContent = "";
  String transformedString = "";
  List<String> titles = new ArrayList<>();
  List<String> contents = new ArrayList<>();

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
