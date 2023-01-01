package datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UseMap {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Map that includes storing and retrieving elements.
		 * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 */
		ArrayList<String> listSet=new ArrayList<>();
		listSet.add("hashSet");
		listSet.add("LinkedHashSet");
		ArrayList<String> list=new ArrayList<>();
		list.add("arrayList");
		list.add("linkedList");
		list.add("vector");
		list.add("stack");
		ArrayList<String> queue=new ArrayList<>();
		queue.add("priorityQueue");
		Map<String, List<String>> collection =new HashMap<>();
		collection.put("sets",listSet);
		collection.put("lists",list);
		collection.put("queues",queue);
		for (Map.Entry enter:collection.entrySet()
		) {
			System.out.println(enter.getKey()+"    "+enter.getValue());
		}


	}

}
