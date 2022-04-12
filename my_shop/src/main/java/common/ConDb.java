package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConDb implements Names{
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private static final String USER = "SC";
	private static final String PASS = "sc";

	

	private static   Connection con; 
	private static   Statement st;
	private static   ResultSet rs;
	
public ConDb()  throws  ClassNotFoundException, SQLException{
	
		String url = DB_URL;
	
/* 2) JDBCドライバの定義 */
      Class.forName("com.mysql.cj.jdbc.Driver");

/* 3) DBへの接続 */
      con = DriverManager.getConnection(url, USER, PASS);

      st = con.createStatement();

	
}

public ConDb(String dbname)  throws  ClassNotFoundException, SQLException{
	
	String url = DB_URL + dbname;
	
	System.out.println(url);

/* 2) JDBCドライバの定義 */
  Class.forName("com.mysql.cj.jdbc.Driver");

/* 3) DBへの接続 */
  con = DriverManager.getConnection(url, USER, PASS);

  st = con.createStatement();


}

public List<String> getCnames(String tbl){

	 try {
		 
		 String sql = "SELECT * FROM " + tbl + " LIMIT 1;";
		 
		rs = st.executeQuery(sql);
		
		/////////////////////////////////
		ResultSetMetaData rm = rs.getMetaData();
		int  cnum = rm.getColumnCount();
		ArrayList<String>  cnames = new ArrayList<>();
		
		for(int i = 1; i <= cnum; i++) {
			cnames.add(rm.getColumnName(i).toString());
		}
		//////////////////////////////////  
		return cnames;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	   return null;
}

public List<ArrayList<String>> getAll(String tbl){

	 try {
		 
		 String sql = "SELECT * FROM " + tbl + ";";
		 
		rs = st.executeQuery(sql);
		ResultSetMetaData rm = rs.getMetaData();
		int  cnum = rm.getColumnCount();

		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		
		   while ( rs.next() ) {
			  ArrayList<String> rowdata = new ArrayList<>();
				for(int i = 1; i <= cnum; i++) {
					rowdata.add(rs.getObject(i).toString());
				}
					data.add(rowdata);
		     }		
		   
		   		return data;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 		return null;
}


public void  closeDb() {
	try {
			if(rs != null)	rs.close(); 
			if(rs != null)	st.close();
			if(rs != null)	con.close();
	}catch (Exception e) {
	
}
	
 }

public Connection getConnection() {
	return con;
}
public Statement getStatement() {
	return st;
 }
public ResultSet getResultSet() {
	return rs;
 }


}
