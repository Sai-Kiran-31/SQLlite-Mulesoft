import java.sql.*;
import java.io.*;
public class Movies {
	public static void main(String []args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	try{  
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/","root",""); 
		Statement stmt=con.createStatement();  
		String sql = "CREATE DATABASE IF NOT EXISTS MOVIES;";
		stmt.execute(sql);
		stmt.execute("USE MOVIES;");
		stmt.execute("CREATE TABLE IF NOT EXISTS MOVIE(name VARCHAR(60),actor VARCHAR(60),actress VARCHAR(60),director VARCHAR(60),year_of_release VARCHAR(60));");
			String stsql = "insert into movie " + " (name,actor,actress,director,Year_of_release)" + " values (?, ?, ?, ?, ?)";
			PreparedStatement myStmt = con.prepareStatement(stsql);
			System.out.println("Enter Data");
			String data=br.readLine();
			String data_A[]=data.split("\\s+");
			for(int i=0;i<data_A.length;i++) {
				myStmt.setString(i+1, data_A[i]);
			}
			myStmt.executeUpdate();
			System.out.println("Inserted");
		
}
	catch(Exception e) {
		System.out.println(e);
	}
	
}
}

