package math.problems;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LowestNumber {
	// find the lowest number
	public static int findLowest(int array[]) {
		int lowest = array[0];
		for (int i = 0; i < array.length; i++) {
			if (lowest > array[i]) {
				lowest = array[i];
			}
		}
		return lowest;
	}

	public static void main(String[] args) throws SQLException {
		/*
		 * Write java solution to find the lowest number from this array.
		 * Use one of the databases from mysql or mongodb to store and to retrieve.
		 */
		int array[] = new int[]{211, 110, 99, 34, 67, 89, 67, 456, 321, 456, 78, 90, 45, 32, 56, 78, 90, 54, 32, 123, 67, 5, 679, 54, 32, 65};

		//find lowest number from the array
		int lowest = LowestNumber.findLowest(array);
		//System.out.println(lowest);
		// insert the lowest to mysql  database  (lowest)
		databases.ConnectToSqlDB connectToSqlDB = new databases.ConnectToSqlDB();
		Connection con = null;
		try {
			con = connectToSqlDB.connectToSqlDatabase();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		List<String> lowestValue = new ArrayList<String>();
		try {
			//	connectToSqlDB.insertDataFromArrayToSqlTable(array, "tbl_lowestNumber", "column_lowestNumber");
			//lowestValue = connectToSqlDB.readDataBase("tbl_lowestNumber", "column_lowestNumber");
			String query = " insert into lowest (lowestVal)"
					+ " values (?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, lowest);

			// execute the preparedstatement
			preparedStmt.execute();
			//con.close();


		} catch (Exception e) {
			e.printStackTrace();
		}
		//display the database
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery("select * from lowest");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		while (rs.next()) {
			try {
				System.out.println(rs.getInt(1) );
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



//		System.out.println("Data is reading from the Table (tbl_primenumber) and displaying to the console");
//		for(String st:lowestValue){
//			System.out.println(st);
//		}
}