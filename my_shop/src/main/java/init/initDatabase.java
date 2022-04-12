package init;

import java.io.IOException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ConDb;
import common.Names;

/**
 * Servlet implementation class init
 */
@WebServlet("/initDatabase")
public class initDatabase extends HttpServlet implements Names{
	private static final long serialVersionUID = 1L;
       
	private static  ConDb con;
	private static Statement stmt;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public initDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html; charset=UTF-8");  
         request.setCharacterEncoding("UTF-8");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
		
			 con = new ConDb();
		
			 stmt = con.getStatement();
			 
			     String sql = null;
			     
			     sql ="CREATE DATABASE IF NOT EXISTS " + DBNAME + 
			    " CHARACTER SET = 'utf8' COLLATE = 'utf8_general_ci'";
		     
			   int x = stmt.executeUpdate(sql);
			     
 	         System.out.println("Database created successfully... " + x); 
	         
			 con.closeDb();
			 
			 
			 
			
		}catch (Exception e) {
	         e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
