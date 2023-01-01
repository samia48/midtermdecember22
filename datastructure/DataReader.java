package datastructure;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import databases.ConnectToMongoDB;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static databases.ConnectToMongoDB.mongoDatabase;

public class DataReader {

	public static void main(String[] args) {
		/*
		 * User API to read the below textFile and print to console.
		 * Use BufferedReader class.
		 * Use try....catch block to handle Exception.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 * After reading from file using BufferedReader API, store each word into Stack and LinkedList. So each word
		 * should construct a node in LinkedList.Then iterate/traverse through the list to retrieve as FIFO
		 * order from LinkedList and retrieve as FILO order from Stack.
		 *
		 * Demonstrate how to use Stack that includes push,peek,search,pop elements.
		 * Use For Each loop/while loop/Iterator to retrieve data.
		 */

		String textFile = System.getProperty("user.dir") + "/src/data/self-driving-car";
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(textFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String str = "";
		LinkedList<String> listWords=new LinkedList<>();
		Stack<String> listWord2=new Stack<>();
		//connection to mongo db
		ConnectToMongoDB con=new ConnectToMongoDB();
		con.connectToMongoDB();
		MongoClient m=new MongoClient();
		MongoDatabase db = m.getDatabase("words");
		MongoCollection collection = db.getCollection("word");
		Document doc1 = null;


		List<Document> ListToDb= new ArrayList<Document>();


		try {
			while ((str = bufferedReader.readLine()) != null){
				String []StringArr=str.split(" ");
				for (int i =0;i<StringArr.length;i++){
					doc1 =  new Document();
					doc1.put(StringArr[i],StringArr[i]);
					ListToDb.add(i,doc1);

					//System.out.println(doc);
					listWords.add(StringArr[i]);
					listWord2.add(StringArr[i]);
				}


				//System.out.println(doc);
				//	collection.insertOne(doc);


				//System.out.println(str);
			}

			//insert the last element
			collection.insertOne(doc1);

			//read from mongodb database
			List<String> list = new ArrayList<String>();
			//MongoDatabase mongoDatabase = connectToMongoDB();
			MongoCollection<Document> collection1 = mongoDatabase.getCollection("word");
			FindIterable<Document> iterDoc = collection.find();
			Iterator it = iterDoc.iterator();
			while (it.hasNext()) {
				list.add(it.next().toString());
			}
			System.out.println("**************");
			System.out.println(list);
			System.out.println("**************");


//			for (Document l :lpp) {
//				collection.insertMany((List) l.values());
//				i++;
//			}



			//System.out.println(MOngoList);
			//System.out.println(MOngoList);
			//collection.insertMany(MOngoList);
			//MOngoList.add(doc);


			//collection.insertMany(MOngoList);
			//collection.insertMany(MOngoList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listWords.push("drive safe");
		listWords.pop();
		listWord2.push("drive safe");
		Iterator itt = listWords.iterator();
		while(itt.hasNext()){
			System.out.println(itt.next());
		}
		System.out.println("----------------");
		Iterator it = listWord2.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("----------------");
		System.out.println(listWords.peek());
		System.out.println(listWord2.peek());
		System.out.println(listWords.contains("right"));
		System.out.println("----------------");
		for (int i = 0 ;i< 10;i++){
			System.out.println(listWords.get(i));
		}


		System.out.println("--------------------------");
		System.out.println(listWords);
		System.out.println(listWord2);

	}

}