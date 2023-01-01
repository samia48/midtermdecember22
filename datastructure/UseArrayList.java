package datastructure;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import databases.ConnectToMongoDB;
import org.bson.Document;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class UseArrayList {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use ArrayList that includes add,peek,remove,retrieve elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * Store all the sorted data into one of the databases.
		 *
		 */
		ArrayList<String> arr=new ArrayList<>(Arrays.asList("nyc","boston","california","miami"));
		LinkedList<String> lists=new LinkedList<>(arr);
		lists.push("chicago");
		lists.push("huston");
		lists.push("florida");
		lists.push("denver");
		System.out.println(lists.getFirst());
		System.out.println(lists.getLast());

		//lists.removeFirst();
		for (String i :lists) {
			System.out.println(i);
		}
		System.out.println("----------------------");
		for(int i =lists.size()-1;i>4;i--){
			System.out.println(lists.get(i));
		}
		System.out.println(lists.peek());

		String[]arrayTOdb=new String[arr.size()];
		for(int i = 0 ; i< arrayTOdb.length;i++){
			arrayTOdb[i]=arr.get(i);
		}

		databases.ConnectToSqlDB connectToSqlDB1 = new databases.ConnectToSqlDB();
		Connection con = null;
		try {
			con = connectToSqlDB1.connectToSqlDatabase();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {

			String query = " INSERT INTO cities(names) VALUES(?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			for(int n=0; n<arrayTOdb.length; n++) {
				preparedStmt = con.prepareStatement(query);
				preparedStmt.setString(1, arrayTOdb[n]);
				preparedStmt.execute();
				System.out.println("data inserted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		//insert to mongodb
		ConnectToMongoDB connectToMongoDB=new ConnectToMongoDB();
		connectToMongoDB.connectToMongoDB();
		MongoClient client=new MongoClient();
		MongoDatabase database=client.getDatabase("cities");
		MongoCollection collection=database.getCollection("names");
		Document doc= new Document("boston","bo");
		collection.insertOne(doc);
		List<Document> listDoc=new ArrayList<Document>();
		Document doc1=null;

		for(int i =0;i< arr.size();i++){
			doc1=new Document();
			doc1.put(arr.get(i),arr.get(i).substring(0,2));
			listDoc.add(i,doc1);

		}
		collection.insertMany(listDoc);
		System.out.println("inserted ");





		//retrive data from mongo db
		List<String> list = new ArrayList<String>();

		FindIterable<Document> iterDoc = collection.find();
		Iterator it = iterDoc.iterator();
		while (it.hasNext()) {
			list.add(it.next().toString());
		}
		System.out.println(list);










	}

}