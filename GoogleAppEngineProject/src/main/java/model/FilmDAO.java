package model;
import java.util.ArrayList;
import java.sql.*;


public class FilmDAO {
	Film oneFilm = null;
	Connection conn = null;
    Statement stmt = null;
	//String user = "jackbroomhead";
    //String password = "19092943";
    String user = "broomhej";
    String password = "Maqpolit6";
    
    // Note none default port used, 6306 not 3306

    //String url = "jdbc:mysql://cloudsql/melodic-subject-270914:europe-west1:mysqlfilmsdatabase/";
    String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/"+user;
	public FilmDAO() {}

	
	private void openConnection(){
		// loading jdbc driver for mysql
		try{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch(Exception e) { System.out.println(e); }

		// connecting to database
		try{
			// connection string for demos database, username demos, password demos
 			conn = DriverManager.getConnection(url, user, password);
		    stmt = conn.createStatement();
		} catch(SQLException se) { System.out.println(se); }	   
    }
	private void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Film getNextFilm(ResultSet rs){
    	Film thisFilm=null;
		try {
			thisFilm = new Film(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getInt("year"),
					rs.getString("director"),
					rs.getString("stars"),
					rs.getString("review"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return thisFilm;		
	}
	
	
	
   public ArrayList<Film> getAllFilms(){
	   
		ArrayList<Film> allFilms = new ArrayList<Film>();
		openConnection();
		
	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from films limit 20";
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    	allFilms.add(oneFilm);
		   }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return allFilms;
   }

   public Film getFilmByID(int id){
	   
		openConnection();
		oneFilm=null;
	    // Create select statement and execute it
		try{
		    String selectSQL = "SELECT * FROM films WHERE id =" + id;
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    }

		    stmt.close();
		    closeConnection();
		    
		} catch(SQLException se) { System.out.println(se); }

	   return oneFilm;
   }
   
   public ArrayList<Film> getFilmByTitle(String searchStr) {
	   ArrayList<Film> Titlefilms = new ArrayList<Film>();
	   openConnection();
	  
	   //Create statement and execute it
	   try {
		   String selectSQL = "SELECT * FROM films WHERE title =" + "'" + searchStr + "'";
		   ResultSet rs1 = stmt.executeQuery(selectSQL);
		   //Retrieve the results
		   while(rs1.next()) {
			   oneFilm = getNextFilm(rs1);
			   Titlefilms.add(oneFilm);
		   }
		   stmt.close();
		   closeConnection();
	   } catch(SQLException se) {System.out.println(se); }
	   return Titlefilms;
   }
   
   public Film insertFilm(Film fi) {
	   openConnection();
	   
	   //Create Insert statement and execute it
	   try
	   {
		   String selectSQL = "INSERT INTO films (`id`, `title`, `year`, `director`, `stars`, `review`) values (?, ?, ?, ?, ?, ?)";
		   
		   //create the mysql insert preparedstatement
		    //
		   
		   PreparedStatement preparedStmt = conn.prepareStatement(selectSQL);
		   preparedStmt.setInt (1, fi.getId());
		   preparedStmt.setString (2, fi.getTitle());
		   preparedStmt.setInt(3, fi.getYear());
		   preparedStmt.setString(4, fi.getDirector());
		   preparedStmt.setString (5, fi.getStars());
		   preparedStmt.setString (6, fi.getReview());
		   
		   //execute prepared statement
		  // preparedStmt.executeUpdate();
		   int rowsinserted = preparedStmt.executeUpdate();
		   if (rowsinserted > 0) {
			   System.out.println(fi +" successfully inserted");
		   } else {
			   System.out.println("Film not inserted");
		   }
		   
		   preparedStmt.close();
		   closeConnection();
	   }
	   catch (Exception e) {
		   System.err.println("Got an exception!");
		   System.err.println(e.getMessage());
	   }
	return fi;
   }
   
   public boolean deleteFilm(int id) {
	openConnection();
	
	//create statement and execute it
	try {
		String selectSQL = "DELETE FROM films WHERE id =" + id;
		int rowdeleted = stmt.executeUpdate(selectSQL);
	    
		if (rowdeleted > 0) {
			System.out.println("if " + id + " successfully deleted will return 1: 1");
		} else {
			System.out.println("if " + id + " successfully deleted will return 1: 0");
		}
		
		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }
	return false;

	  	}
   
   public Film amendFilm(Film fa) {
	   openConnection();
	   //create statement and execute it 
	   try {
		   String selectSQL = "UPDATE films SET ('title', 'year', 'director', 'stars', 'review') values (?, ?, ?, ?, ?)";
		selectSQL += " WHERE ('id') values (?)"; 
		   
		   PreparedStatement preparedStmt = conn.prepareStatement(selectSQL);
		   preparedStmt.setInt (6, fa.getId());
		   preparedStmt.setString (1, fa.getTitle());
		   preparedStmt.setInt(2, fa.getYear());
		   preparedStmt.setString(3, fa.getDirector());
		   preparedStmt.setString (4, fa.getStars());
		   preparedStmt.setString (5, fa.getReview());
		   
		   //execute prepared statement
		   //preparedStmt.executeUpdate(selectSQL);
		   int rowsinserted = preparedStmt.executeUpdate(selectSQL);
		   if (rowsinserted > 0) {
			   System.out.println("Film successfully updated");
		   } else {
			   System.out.println("film not updated");
		   }
		   
		   preparedStmt.close();
		   closeConnection();
	   }
	   catch (Exception e) {
		   System.err.println("Got an exception!");
		   System.err.println(e.getMessage());
	   }
	return fa;
	   }
   }