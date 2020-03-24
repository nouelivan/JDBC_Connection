package jdbc_Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connect {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test_database";

	static final String USER = "root";
	static final String PASS = "nouelivan1234";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			System.out.println("Creating statement..." + "\n");
			stmt = conn.createStatement();

			String sql = "SELECT * FROM fast_food_burger_calories";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				int bigMac = rs.getInt("Big Mac");
				int whopper = rs.getInt("Whopper");
				int impossibleWhopper = rs.getInt("Impossible Whopper");
				int quarterPounder = rs.getInt("Quarter Pounder");
				int davesSingle = rs.getInt("Daves Single");
				int davesDouble = rs.getInt("Daves Double");

				// Display values
				System.out.print("ID: " + id);
				System.out.print(", Big Mac: " + bigMac);
				System.out.print(", Whopper: " + whopper);
				System.out.print(", Impossible Whopper: " + impossibleWhopper);
				System.out.print(", Quarter Pounder: " + quarterPounder);
				System.out.print(", Daves Single: " + davesSingle);
				System.out.print(", Daves Double: " + davesDouble);
			}

			rs.close();

		} catch (SQLException se) {

			se.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			// finally block used to close resources
			try {

				if (stmt != null)

					conn.close();

			} catch (SQLException se) {
			}

			try {
				if (conn != null)

					conn.close();

			} catch (SQLException se) {

				se.printStackTrace();
			}

		}

	}

}
