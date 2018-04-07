import java.sql.*;
import java.util.ArrayList;

/**
 * @author JustinSaunders
 *Class to query the SQL server
 *Manipulates and calls data from webdev.cislabs.uncw.edu server
 */
public class RQ {

	static ResultSet rs = null;
	static Database data = new Database();
	static Statement stmt = null;
	
	
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
	public static ResultSet GetMovies() {
		
	      //Create a statement and execute a query
		  stmt = null;
	      try {
	    	  stmt = data.conn.createStatement();
	    	  String sql;
	    	  sql = "SELECT * FROM movies ORDER BY title";
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
	public static ResultSet GetCustomers() {
		
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
	
	/**
	 * Searches the database for movies whose titles contain the search string
	 * @param search - string used to query the database
	 * @return result set of matching movies
	 */
	public static ResultSet SelectTitle(String search) {
		
	      //Create a statement and execute a query
		  stmt = null;
	      try {
	    	  stmt = data.conn.createStatement();
	    	  String sql;
	    	  sql = "SELECT * FROM movies WHERE title like \"%" + search + "%\" ORDER BY title";
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
	 * Searches the database for movies whose genre contains the search string
	 * @param search - string used to query the database
	 * @return result set of matching movies
	 */
	public static ResultSet SelectGenre(String search) {
		  
		  //Create a statement and execute a query
		  stmt = null;
	      try {
	    	  stmt = data.conn.createStatement();
	    	  String sql;
	    	  sql = "SELECT * FROM movies WHERE genre like \"%" + search + "%\" ORDER BY title";
	    	  rs = stmt.executeQuery(sql);

	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();
	          }
			return rs;
	}
	
	/**
	 * Searches the database for movies whose lead actor contains the search string
	 * @param search - string used to query the database
	 * @return result set of matching movies
	 */
	public static ResultSet SelectActor(String search) {
		
		  //Create a statement and execute a query
		  Statement stmt = null;
	      try {
	    	  stmt = data.conn.createStatement();
	    	  String sql;
	    	  sql = "SELECT * FROM movies WHERE lead_role like \"%" + search + "%\" ORDER BY title";
	    	  rs = stmt.executeQuery(sql);

	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();
	          }
	          
			return rs;
		
	}
	
	/**
	 * Removes movies from the database whose titles contain the input string
	 * @param title - movie intended to be deleted from the database
	 */
	public static void RemoveMovie(String title) {
		
		  //Create a statement and execute a query
		  Statement stmt = null;
	      try {
	      stmt = data.conn.createStatement();
	      String sql;
	      //Delete movie from database
	      sql = "DELETE FROM movies WHERE title = " + "\'" + title + "\'";
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
	
	/**
	 * Adds a movie to the database with given details
	 * @param title - title of the movie being added
	 * @param genre - genre of the movie being added
	 * @param lead - lead actor of the movie being added
	 * @param director - director of the movie being added 
	 * @param year - production year of the movie being added
	 * @param qty - quantity in stock of the movie being added
	 * @param rating - mpaa rating of the movie being added
	 * @param URL - image url of the movie being added
	 */
	public static void AddMovie(String title, String genre, String lead, String director, int year, int qty, String rating, String URL) {
	      try {
	    	  String sql = "INSERT INTO movies VALUES(" + "\'" + title + "\'" +  ", \'" + genre + "\', " + "\'" + lead + "\', " +  "\'" + director + "\', " + year + ", " + qty + ", " + "\'" + rating + "\', " + "\'" + URL + "\')";	      	      
	    	  Statement stmt = data.conn.createStatement();
	    	  stmt.executeUpdate(sql);	   
	      //Clean-up environment
	      stmt.close();
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}

		
	}
	
	/**
	 * Removes a user from the database whose ID is the given ID
	 * @param user_id - ID of the user being removed
	 */
	public static void RemoveUser(String email) {
		
		  //Create a statement and execute a query
		  Statement stmt = null;
	      try {
	      stmt = data.conn.createStatement();
	      String sql;
	      //Delete movie from database
	      sql = "DELETE FROM cust WHERE  email = " + "\'" + email + "\'";
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
	
	/**
	 * Adds a user to the database with given details
	 * Sets check out movie to null by default
	 * @param c_first - first name of the new user
	 * @param c_last - last name of the new user
	 * @param phone_num - phone number of the new user
	 * @param email - email of the new user
	 */
	public static void AddUser(String c_first, String c_last, String phone_num, String email) {

	      try {
	    	  int high_id = 0;
	    	  Statement stmt = data.conn.createStatement();
	    	  String sql = "SELECT * from cust ORDER BY c_id";
	    	  rs = stmt.executeQuery(sql);
	    	  while(rs.next()) {
	    		  high_id = rs.getInt("c_id");
	    	  }
	    	  int C_ID = high_id + 1;
	    	  
	    	  sql = "INSERT INTO cust VALUES(" + C_ID + ", \'" + c_first + "\', " + "\'" + c_last + "\', " +  "\'" + phone_num + "\', " + "\'" + email +"\', " + "null)";	      	      
		      stmt.executeUpdate(sql);
	      //Clean-up environment
	      stmt.close();
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}

		
	}
	
	/**
	 * Checks out a movie to user and decreases the stock of the movie by one if the movie is in stock
	 * @param email - email of the customer checking out a movie
	 * @param title - title of the movie being checked out
	 * @return - string message displaying thank you message or out of stock message
	 */
	public static String CheckOut(String email, String title) {
		String output = "";
		ResultSet temp_set = null;
		try {		  
		  temp_set = SelectTitle(title);
		  while (temp_set.next()) {
			  int quantity = temp_set.getInt("qty");
			  ArrayList<String> userList = new ArrayList<String>();
			  ResultSet userSet = GetCustomers();
			  while(userSet.next()) {
				  String userEmail  = userSet.getString("email");
				  userList.add(userEmail);
			  }

			  if (quantity > 0 && userList.contains(email)) {
				  Statement stmt = data.conn.createStatement();
				  int new_quantity = quantity - 1;
				  String sql = "UPDATE cust set checked_out = " +  "\'" + title + "\'" +  " WHERE email = " + "\'" + email + "\'";
	    	  		stmt.executeUpdate(sql);	   
	    	  		sql = "UPDATE movies set qty = " + new_quantity + " WHERE title = " + "\'" + title + "\'";
	    	  		stmt.executeUpdate(sql);
	    	  		output = "Movie Rented, please return in three days.";
	    	  		//Clean-up environment
	    	  		stmt.close();
	    	  		}
			  else {
				 output = "Out of stock or invalid email address. Please try again.";
			  }
		  }
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}
		return output;
		  }
	
	/**
	 * Checks in a movie and increases the stock of that movie by one
	 * @param email - email of the customer who the movie was checked out to
	 * @param title - title of the movie being checked in
	 * @return - string message thanking customer
	 */
	public static String CheckIn(String email, String title) {
		String output = "";
		ResultSet temp_set = null;
		try {		  
		  temp_set = SelectTitle(title);
		  while (temp_set.next()) {
		  int quantity = temp_set.getInt("qty");
		  ArrayList<String> userList = new ArrayList<String>();
		  ResultSet userSet = GetCustomers();
		  while(userSet.next()) {
			  String userEmail  = userSet.getString("email");
			  userList.add(userEmail);
		  }

		  if (userList.contains(email)) {
			Statement stmt = data.conn.createStatement();
			int new_quantity = quantity + 1;
			String sql = "UPDATE cust set checked_out = null " + " WHERE email = " + "\'" + email + "\'";
	    	  	stmt.executeUpdate(sql);	   
	    	  	sql = "UPDATE movies set qty = " + new_quantity + " WHERE title = " + "\'" + title + "\'";
	    	  	stmt.executeUpdate(sql);
	    	  	output = "Thank you.";
	      //Clean-up environment
	      stmt.close();}
		  else {
			  output = "Invalid Email.";
		  }}
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}
		return output;
		  }	    	  
	
	
	/**
	 * Edits the title of a movie in the database
	 * @param movie_name - movie being changed
	 * @param changed - new title
	 */
	public static void EditTitle(String movie_name, String changed) {
		try {
		  String sql = "UPDATE movies set title = " + "\'" + changed + "\'" + "WHERE title = " + "\'" + movie_name + "\'";
	    	  Statement stmt = data.conn.createStatement();
	    	  stmt.executeUpdate(sql);	   
	      //Clean-up environment
	      stmt.close();
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}		
	}
	
	/**
	 * Edits the genre of a movie in the genre
	 * @param movie_name - movie being changed
	 * @param changed - new genre
	 */
	public static void EditGenre(String movie_name, String changed) {
		try {
		  String sql = "UPDATE movies set genre = " + "\'" + changed + "\'" + "WHERE title = " + "\'" + movie_name + "\'";
	    	  Statement stmt = data.conn.createStatement();
	    	  stmt.executeUpdate(sql);	   
	      //Clean-up environment
	      stmt.close();
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}		
	}
	
	/**
	 * Edits the lead actor of a movie in the database
	 * @param movie_name - movie being changed
	 * @param changed - new lead actor
	 */
	public static void EditLead(String movie_name, String changed) {
		try {
		  String sql = "UPDATE movies set lead_role = " + "\'" + changed + "\'" + "WHERE title = " + "\'" + movie_name + "\'";
	    	  Statement stmt = data.conn.createStatement();
	    	  stmt.executeUpdate(sql);	   
	      //Clean-up environment
	      stmt.close();
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}		
	}
	
	/**
	 * Edits the director of a movie in the database
	 * @param movie_name - movie being changed
	 * @param changed - new director
	 */
	public static void EditDirector(String movie_name, String changed) {
		try {
		  String sql = "UPDATE movies set director = " + "\'" + changed + "\'" + "WHERE title = " + "\'" + movie_name + "\'";
	    	  Statement stmt = data.conn.createStatement();
	    	  stmt.executeUpdate(sql);	   
	      //Clean-up environment
	      stmt.close();
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}		
	}
	
	/**
	 * Edits the year of a movie in the database
	 * @param movie_name - movie being changed
	 * @param changed - new year
	 */
	public static void EditYear(String movie_name, int changed) {
		try {
		  String sql = "UPDATE movies set year = " + changed +  " WHERE title = " + "\'" + movie_name + "\'";
	    	  Statement stmt = data.conn.createStatement();
	    	  stmt.executeUpdate(sql);	   
	      //Clean-up environment
	      stmt.close();
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}		
	}
	
	/**
	 * Edits the quantity of a movie in the database
	 * @param movie_name - movie being changed
	 * @param changed - new quantity
	 */
	public static void EditQty(String movie_name, int changed) {
		try {
		  String sql = "UPDATE movies set qty = " + changed  + " WHERE title = " + "\'" + movie_name + "\'";
	    	  Statement stmt = data.conn.createStatement();
	    	  stmt.executeUpdate(sql);	   
	      //Clean-up environment
	      stmt.close();
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}		
	}
	
	/**
	 * Edits the rating of a movie in the database
	 * @param movie_name - movie being changed
	 * @param changed - new rating
	 */
	public static void EditRating(String movie_name, String changed) {
		try {
		  String sql = "UPDATE movies set mpaa_rating = " + "\'" + changed + "\'" + "WHERE title = " + "\'" + movie_name + "\'";
	    	  Statement stmt = data.conn.createStatement();
	    	  stmt.executeUpdate(sql);	   
	      //Clean-up environment
	      stmt.close();
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}		
	}
	
	/**
	 * Edits the image url of a movie in the database
	 * @param movie_name - movie being changed
	 * @param changed - new url
	 */
	public static void EditURL(String movie_name, String changed) {
		try {
		  String sql = "UPDATE movies set movie_image = " + "\'" + changed + "\'" + "WHERE title = " + "\'" + movie_name + "\'";
	    	  Statement stmt = data.conn.createStatement();
	    	  stmt.executeUpdate(sql);	   
	      //Clean-up environment
	      stmt.close();
	      }catch(SQLException se){
	          //Handle errors for JDBC
	          se.printStackTrace();
	       }catch(Exception e){
	          //Handle errors for Class.forName
	          e.printStackTrace();}		
	}
	
	/**
	 * Shows the information on file for a given customer
	 * @param email - email of the customer for lookup
	 * @return - result set of client's information
	 */
	public static ResultSet ViewCustomer(String email) {
		try {
			  String sql = "SELECT * from cust where email = " + "\'" + email + "\'";
		    	  Statement stmt = data.conn.createStatement();
		    	  rs = stmt.executeQuery(sql);	   
		      }catch(SQLException se){
		          //Handle errors for JDBC
		          se.printStackTrace();
		       }catch(Exception e){
		          //Handle errors for Class.forName
		          e.printStackTrace();}
		return rs;	
	}
	
	/**
	 * Shows the current checked out movie for a given customer
	 * @param email - email of the customer for lookup
	 * @return - string movie title
	 */
	public static String ViewRented(String email) {
		String rented = "";
		try {
			  String sql = "SELECT checked_out from cust where email = " + "\'" + email + "\'";
		    	  Statement stmt = data.conn.createStatement();
		    	  rs = stmt.executeQuery(sql);	
		    	  while(rs.next()) {
		    		  rented = rs.getString("checked_out");
		    	  }
		    	  if(rented == null) {
		    		  rented = "No movie currently rented.";
		    	  }
		      }catch(SQLException se){
		          //Handle errors for JDBC
		          se.printStackTrace();
		       }catch(Exception e){
		          //Handle errors for Class.forName
		          e.printStackTrace();}
		return rented;	
	}
}
