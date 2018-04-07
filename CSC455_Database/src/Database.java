import java.sql.*;

/**
 * @author JustinSaunders
 * Class for Database constructor and connection object
 */
public class Database {
	
	//  Database credentials
   static final String USER = "jds8328";
   static final String PASS = "25yaZrzzM";
	
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://152.20.12.152/jds8328?noAccessToProcedureBodies=true&useSSL=false&user="+USER+"&password="+PASS;
   

   
   //creates a new Connection object
   public Connection conn = null;
   
   /**
    * Database constructor
    */
   public Database()
   {
	   try{
		   	Class.forName("com.mysql.jdbc.Driver");
		   	System.out.println("Driver instance ok...");
		   	conn = DriverManager.getConnection(DB_URL);
	   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
   }

}//end class
