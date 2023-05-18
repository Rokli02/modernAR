package hu.uni.miskolc.second.repositories;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.codecs.DocumentCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;

@Component
public class GeneralRepository {
  @Autowired
  private Environment env;

  public List<Document> query(String collectionName, String query) {
    System.out.println("GeneralRepository - query");
    List<Document> list = new ArrayList<Document>();

    try (MongoClient client = MongoClients.create(env.getProperty("spring.data.mongodb.uri"))) {
      final MongoCollection<Document> collection = client.getDatabase(env.getProperty("spring.data.mongodb.database")).getCollection(collectionName);
      var filter = Document.parse(query, new DocumentCodec());
      var result = collection.find(filter);
      for (var element : result) {
        list.add(element);
      }

      return list;
    } catch (RuntimeException re) {
      re.printStackTrace();
    }

    return null;
  }

  public List<String> collectionNames() {
    List<String> names = new ArrayList<String>();

    try (MongoClient client = MongoClients.create(env.getProperty("spring.data.mongodb.uri"))) {
      var cNames = client.getDatabase(env.getProperty("spring.data.mongodb.database")).listCollectionNames();
      cNames.forEach(name -> names.add(name));

      return names;
    } catch (RuntimeException re) {
      re.printStackTrace();
    }

    return null;
  }
}
