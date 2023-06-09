package CodeC;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.bson.Document;
import org.bson.types.ObjectId;

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
public class MongoAccess {
  String username = "";
  String password = "";
  MongoDatabase mongoDatabase = null;
  MongoClientSettings settings = null;
  MongoClient mongoClient = null;
  MongoCollection mongoCollection = null;

  /**
   * Sets Up Mongo DB
   * And the collection
   * reference - https://dal.brightspace.com/d2l/le/content/248902/viewContent/3548833/View
   * LAB 6
   * */
  public void setupMongo() {
    Properties props = new Properties();
    try {
      FileInputStream input = new FileInputStream(
        "src/main/java/APIAssets/keys.prop"
      );
      props.load(input);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    username = props.getProperty("username");
    password = props.getProperty("password");
  }

  /**
   * Takes the titles and the contents array lists
   * and stores it in the monogo DB
   *
   * @param titles the titles array
   * @param contents the contents array
   */
  public void insertToDatabase(List<String> titles, List<String> contents) {
    String connectionURI =
      "mongodb+srv://" +
      username +
      ":" +
      password +
      "@cluster0.50pq1ka.mongodb.net/?retryWrites=true&w=majority";
    ConnectionString connectionString = new ConnectionString(connectionURI);
    settings =
      MongoClientSettings
        .builder()
        .applyConnectionString(connectionString)
        .build();
    mongoClient = MongoClients.create(settings);
    mongoDatabase = mongoClient.getDatabase("MyMongoNews");
    MongoCollection<Document> collection = mongoDatabase.getCollection(
      "Alen-MyMongoNews"
    );

    List<Document> documents = new ArrayList<>();
    for (int i = 0; i < titles.size(); i++) {
      Document doc = new Document();
      doc.append("title", titles.get(i));
      doc.append("content", contents.get(i));
      documents.add(doc);
      collection.insertOne(doc);
    }
  }
}
