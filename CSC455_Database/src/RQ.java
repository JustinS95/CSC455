import java.sql.*;

/**
 * @author JustinSaunders
 *Class to query the SQL server
 *Manipulates and calls data from the database hosted on the satoshi.cis.uncw.edu site
 */
public class RQ {

	static ResultSet rs = null;
	static Database data = new Database();
	static Statement stmt = null;
	
	public static ResultSet mostRecentMember() {
		stmt = null;
	      try {
	    	  stmt = data.conn.createStatement();
	    	  String sql;
	    	  sql = "SELECT m_id FROM members ORDER BY m_id DESC LIMIT 1;";
	    	  rs = stmt.executeQuery(sql);
	      }catch(SQLException se) {
	    	      //Handle errors for JDBC
	          se.printStackTrace();
	       
	       }catch(Exception e){	
	    	      //Handle errors for Class.forName
	          e.printStackTrace();
	          }

			return rs;
	}
	
	public static ResultSet mostRecentSale() {
		stmt = null;
	      try {
	    	  stmt = data.conn.createStatement();
	    	  String sql;
	    	  sql = "SELECT sale_num FROM sales ORDER BY sale_num DESC LIMIT 1;";
	    	  rs = stmt.executeQuery(sql);
	      }catch(SQLException se) {
	    	      //Handle errors for JDBC
	          se.printStackTrace();
	       
	       }catch(Exception e){	
	    	      //Handle errors for Class.forName
	          e.printStackTrace();
	          }

			return rs;
	}
	
	public static ResultSet mostRecentRental() {
		stmt = null;
	      try {
	    	  stmt = data.conn.createStatement();
	    	  String sql;
	    	  sql = "SELECT rental_num FROM rentals ORDER BY rental_num DESC LIMIT 1;";
	    	  rs = stmt.executeQuery(sql);
	      }catch(SQLException se) {
	    	      //Handle errors for JDBC
	          se.printStackTrace();
	       
	       }catch(Exception e){	
	    	      //Handle errors for Class.forName
	          e.printStackTrace();
	          }

			return rs;
	}
	
	public static ResultSet getOutstanding() {
		stmt = null;
	      try {
	    	  stmt = data.conn.createStatement();
	    	  String sql;
	    	  sql = "SELECT rental_num, m_id, due_date FROM rentals where date_in is null;";
	    	  rs = stmt.executeQuery(sql);
	      }catch(SQLException se) {
	    	      //Handle errors for JDBC
	          se.printStackTrace();
	       
	       }catch(Exception e){	
	    	      //Handle errors for Class.forName
	          e.printStackTrace();
	          }

			return rs;
	}
	
	public static ResultSet getRentals() {
		stmt = null;
	      try {
	    	  stmt = data.conn.createStatement();
	    	  String sql;
	    	  sql = "SELECT rental_num, m_id, date_out, date_in FROM rentals;";
	    	  rs = stmt.executeQuery(sql);
	      }catch(SQLException se) {
	    	      //Handle errors for JDBC
	          se.printStackTrace();
	       
	       }catch(Exception e){	
	    	      //Handle errors for Class.forName
	          e.printStackTrace();
	          }

			return rs;
	}
	
	public static ResultSet getDue(String date) {
		stmt = null;
	      try {
	    	  stmt = data.conn.createStatement();
	    	  String sql;
	    	  sql = "SELECT rental_num, m_id FROM rentals where date_in = " + "\'" + date + "\';" ;
	    	  rs = stmt.executeQuery(sql);
	      }catch(SQLException se) {
	    	      //Handle errors for JDBC
	          se.printStackTrace();
	       
	       }catch(Exception e){	
	    	      //Handle errors for Class.forName
	          e.printStackTrace();
	          }

			return rs;
	}
	
	public static void returnVideo(String rental_num) {
		stmt = null;
	      try {
	    	  stmt = data.conn.createStatement();
	    	  String sql;
	    	  sql = "UPDATE rentals set date_in = CURDATE() where rental_num = " + rental_num;
	    	  stmt.executeUpdate(sql);
	      }catch(SQLException se) {
	    	      //Handle errors for JDBC
	          se.printStackTrace();
	       
	       }catch(Exception e){	
	    	      //Handle errors for Class.forName
	          e.printStackTrace();
	          }		
	}
	
	public static void addStore(String store_num, String address) {
		stmt = null;
	      try {
	    	  stmt = data.conn.createStatement();
	    	  String sql;
	    	  sql = "INSERT INTO store values(" + store_num + ", " + "\'" + address + "\'" + ");";
	    	  stmt.executeUpdate(sql);
	      }catch(SQLException se) {
	    	      //Handle errors for JDBC
	          se.printStackTrace();
	       
	       }catch(Exception e){	
	    	      //Handle errors for Class.forName
	          e.printStackTrace();
	          }		
	}
	
	public static void addMember(String m_id, String lname, String fname, String address) {
		stmt = null;
	      try {
	    	  stmt = data.conn.createStatement();
	    	  String sql;
	    	  sql = "INSERT INTO members values(" + m_id + ", " + "\'" + lname + "\'" + ", " + "\'" + fname + "\'" + ", " + "\'" + address + "\'" + ", 0" + ");";
	    	  stmt.executeUpdate(sql);
	      }catch(SQLException se) {
	    	      //Handle errors for JDBC
	          se.printStackTrace();
	       
	       }catch(Exception e){	
	    	      //Handle errors for Class.forName
	          e.printStackTrace();
	          }		
	}
	
	public static void addEmployee(String employee_id, String name, String store_num, String commission_rate) {
		stmt = null;
	      try {
	    	  stmt = data.conn.createStatement();
	    	  String sql;
	    	  sql = "INSERT INTO employees values(" + employee_id + ", " + "\'" + name + "\'" + ", " + store_num + ", " + commission_rate +  ");";
	    	  stmt.executeUpdate(sql);
	      }catch(SQLException se) {
	    	      //Handle errors for JDBC
	          se.printStackTrace();
	       
	       }catch(Exception e){	
	    	      //Handle errors for Class.forName
	          e.printStackTrace();
	          }		
	}
	
	public static ResultSet getCommission() {
		stmt = null;
	      try {
	    	  stmt = data.conn.createStatement();
	    	  String sql;
	    	  sql = "SELECT e_id,commission_rate FROM employees ORDER BY commission_rate";
	    	  rs = stmt.executeQuery(sql);
	      }catch(SQLException se) {
	    	      //Handle errors for JDBC
	          se.printStackTrace();
	       
	       }catch(Exception e){	
	    	      //Handle errors for Class.forName
	          e.printStackTrace();
	          }

			return rs;
	}
	
	/** 
	 * Gets an alphabetical list of movies from the database 
	 * @return result set storing all movies in the database
	 */
	public static ResultSet getMovies() {
		
	      //Create a statement and execute a query
		  stmt = null;
	      try {
	    	  stmt = data.conn.createStatement();
	    	  String sql;
	    	  sql = "SELECT * FROM movies ORDER BY v_id";
	    	  rs = stmt.executeQuery(sql);
	      }catch(SQLException se) {
	    	      //Handle errors for JDBC
	          se.printStackTrace();
	       
	       }catch(Exception e){	
	    	      //Handle errors for Class.forName
	          e.printStackTrace();
	          }

			return rs;
	       }
	
	/**
	 * Gets a list of customers ordered by the ID's in ascending order
	 * @return result set of all customers in the database
	 */
	public static ResultSet getMembers() {
		
	      //Create a statement and execute a query
		  stmt = null;
	      try {
	    	  stmt = data.conn.createStatement();
	    	  String sql;
	    	  sql = "SELECT * FROM members ORDER BY m_id";
	    	  rs = stmt.executeQuery(sql);
	      }catch(SQLException se) {
	    	      //Handle errors for JDBC
	          se.printStackTrace();
	       
	       }catch(Exception e){	
	    	      //Handle errors for Class.forName
	          e.printStackTrace();
	          }

			return rs;
	       }
	
	public static ResultSet getNotRented() {
		
	      //Create a statement and execute a query
		  stmt = null;
	      try {
	    	  stmt = data.conn.createStatement();
	    	  String sql;
	    	  sql = "SELECT * FROM notRented ORDER BY m_id";
	    	  rs = stmt.executeQuery(sql);
	      }catch(SQLException se) {
	    	      //Handle errors for JDBC
	          se.printStackTrace();
	       
	       }catch(Exception e){	
	    	      //Handle errors for Class.forName
	          e.printStackTrace();
	          }

			return rs;
	       }
	
	public static ResultSet getTimesRented() {
		
	      //Create a statement and execute a query
		  stmt = null;
	      try {
	    	  stmt = data.conn.createStatement();
	    	  String sql;
	    	  sql = "SELECT m_id, COUNT(m_id) AS times_rented from rentals GROUP BY m_id;";
	    	  rs = stmt.executeQuery(sql);
	      }catch(SQLException se) {
	    	      //Handle errors for JDBC
	          se.printStackTrace();
	       
	       }catch(Exception e){	
	    	      //Handle errors for Class.forName
	          e.printStackTrace();
	          }

			return rs;
	       }
	
	public static ResultSet getEmployees() {
		
	      //Create a statement and execute a query
		  stmt = null;
	      try {
	    	  stmt = data.conn.createStatement();
	    	  String sql;
	    	  sql = "SELECT * FROM employees ORDER BY e_id";
	    	  rs = stmt.executeQuery(sql);
	      }catch(SQLException se) {
	    	      //Handle errors for JDBC
	          se.printStackTrace();
	       
	       }catch(Exception e){	
	    	      //Handle errors for Class.forName
	          e.printStackTrace();
	          }

			return rs;
	       }
	
	/**
	 * Removes a user from the database whose ID is the given ID
	 * @param user_id - ID of the user being removed
	 */
	public static void removeUser(String member_id) {
		
		  //Create a statement and execute a query
		  Statement stmt = null;
	      try {
	      stmt = data.conn.createStatement();
	      String sql;
	      //Delete movie from database
	      sql = "DELETE FROM members WHERE  m_id = " + "\'" + member_id + "\'";
	      stmt.executeUpdate(sql);
	      //Clean-up environment
	      stmt.close();
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}
	          try{
	              if(stmt!=null)
	                 stmt.close();
	           }catch(SQLException se2){
	           }	
	}
	
	public static void removeEmployee(String employee_id) {
		
		  //Create a statement and execute a query
		  Statement stmt = null;
	      try {
	      stmt = data.conn.createStatement();
	      String sql;
	      //Delete movie from database
	      sql = "DELETE FROM employees WHERE  e_id = " + "\'" + employee_id + "\'";
	      stmt.executeUpdate(sql);
	      //Clean-up environment
	      stmt.close();
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}
	          try{
	              if(stmt!=null)
	                 stmt.close();
	           }catch(SQLException se2){
	           }	
		}
	
	public static void addRental(String rental_num, String m_id, String stock_num, String v_id, String e_id) {
		
		  //Create a statement and execute a query
		  Statement stmt = null;
	      try {
	      stmt = data.conn.createStatement();
	      String sql;
	      //Delete movie from database
	      sql = "INSERT INTO rentals VALUES(" + rental_num + ", " + m_id + ", " + stock_num + ", " + v_id + ", " + e_id + ", " + "\'" + "2-3/month" + "\'" + ", null, null, null);";
	      stmt.executeUpdate(sql);
	      //Clean-up environment
	      stmt.close();
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}
	          try{
	              if(stmt!=null)
	                 stmt.close();
	           }catch(SQLException se2){
	           }	
		}
	
	public static void addSale(String sale_num, String m_id, String stock_num, String v_id, String e_id) {
		
		  //Create a statement and execute a query
		  Statement stmt = null;
	      try {
	      stmt = data.conn.createStatement();
	      String sql;
	      //Delete movie from database
	      sql = "INSERT INTO sales VALUES(" + sale_num + ", " + m_id + ", " + stock_num + ", " + v_id + ", " + e_id + ", null);";
	      stmt.executeUpdate(sql);
	      //Clean-up environment
	      stmt.close();
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}
	          try{
	              if(stmt!=null)
	                 stmt.close();
	           }catch(SQLException se2){
	           }	
		}
}

