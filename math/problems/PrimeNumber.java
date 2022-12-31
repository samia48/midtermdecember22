package math.problems;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class PrimeNumber {


	/*
	 * Find list of Prime numbers from number 2 to 1 million.
	 * Try the best solution as possible.Which will take less CPU life cycle.
	 * Out put number of Prime numbers on the given range.
	 *
	 *
	 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
	 *
	 */

	public static ArrayList<Integer> prime() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int count = 2;
		for (int i = 1; i < 20000; i++) {
			for (int j = 1; j < 100; j++) {
				if (i % j == 0) {
					count++;
				}
			}
			if (count == 2) {
				arr.add(i);
			}
			count = 0;
		}
		return arr;
	}

	public static void main(String[] args) throws SQLException {

		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = PrimeNumber.prime();
		//int[] arrayStatic=new int [arr.size()];
		//turn an arrayList into array
		int[] array = arr.stream().mapToInt(i -> i).toArray();


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


		//List<String> lowestValue = new ArrayList<String>();
		try {
			String query = " insert into prime (idprime)"
					+ " values (?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			for (int n = 0; n < array.length; n++) {
				preparedStmt = con.prepareStatement(query);
				preparedStmt.setInt(1, array[n]);
				preparedStmt.execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		//display the data
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery("select * from prime");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		while (rs.next()) {
			try {
				System.out.println(rs.getInt(1));
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		try {
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
}