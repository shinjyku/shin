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
@WebServlet("/init")
public class CreateTable extends HttpServlet implements Names {
	private static final long serialVersionUID = 1L;
       
	private static  ConDb con;
	private static Statement stmt;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTable() {
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
		
		response.getWriter().append("<p>[Served at: ").append(request.getContextPath()+ "]</p>");
		
		try {
		
			 con = new ConDb(DBNAME);
		
			 stmt = con.getStatement();
			 
			     String sql = null;
			     int x = 0;
		     ////////////////////////////////
			     sql ="CREATE TABLE IF NOT EXISTS " + BUNRUI + 
			    	"(bcode INTEGER NOT NULL, bname VARCHAR(30) NOT NULL," + 
			    	" delflg INTEGER DEFAULT 0 NOT NULL, stamp timestamp,"
			    	                + " PRIMARY KEY(bcode))";
		     
			   x = stmt.executeUpdate(sql);
			     
 			 response.getWriter().append("<p>※ " + BUNRUI + " : " + x + "</p>");
 	         System.out.println("※ " + BUNRUI + " : " + x); 

		     ////////////////////////////////
		     sql ="CREATE TABLE IF NOT EXISTS " + SHOHIN + 
		    	"(scode INTEGER NOT NULL, " +
		    	"sname VARCHAR(80) NOT NULL, ssetumei VARCHAR(160), " +
		    	"sprice INTEGER NOT NULL, sphoto VARCHAR(80), " +
		    	"sbunrui INTEGER NOT NULL REFERENCES "+ BUNRUI +"(bcode), " +
		    	" delflg INTEGER DEFAULT 0 NOT NULL, stamp timestamp,"
		    	                + " PRIMARY KEY(scode))";
	     
		     x = stmt.executeUpdate(sql);
		     
 			 response.getWriter().append("<p>※ " + SHOHIN + " : " + x + "</p>");
	          System.out.println("※ " + SHOHIN + " : " + x); 
 	         
		     ////////////////////////////////
		     sql ="CREATE TABLE IF NOT EXISTS " + ZAIKO + 
		    	"(zcode INTEGER NOT NULL, " +
		    	"zstock INTEGER  DEFAULT 0 NOT NULL, " +
		    	"zshohin INTEGER NOT NULL REFERENCES "+ SHOHIN +"(scode), " +
		    	" delflg INTEGER DEFAULT 0 NOT NULL, stamp timestamp,"
		    	                + " PRIMARY KEY(zcode))";
	     
		     x = stmt.executeUpdate(sql);
		     
 			 response.getWriter().append("<p>※ " + ZAIKO + " : " + x + "</p>");
	         System.out.println("※ " + ZAIKO + " : " + x); 
 	         
		     ////////////////////////////////
		     sql ="CREATE TABLE IF NOT EXISTS " + KOKYAKU + 
		    	"(kcode INTEGER NOT NULL, " +
		    	"kname VARCHAR(80) NOT NULL, kmail VARCHAR(160) NOT NULL, " +
		    	"kaddress VARCHAR(120) NOT NULL, " +
		    	" delflg INTEGER DEFAULT 0 NOT NULL, stamp timestamp,"
		    	                + " PRIMARY KEY(kcode))";
	     
		     x = stmt.executeUpdate(sql);
		     
 			 response.getWriter().append("<p>※ " + KOKYAKU + " : " + x + "</p>");
	         System.out.println("※ " + KOKYAKU + " : " + x); 

		     ////////////////////////////////
		     sql ="CREATE TABLE IF NOT EXISTS " + TYUMON + 
		    	"(tcode INTEGER NOT NULL AUTO_INCREMENT, " +
		    	"tkokyaku INTEGER NOT NULL REFERENCES "+ KOKYAKU +"(kcode), " +
		    	"thizuke DATE NOT NULL, " +
		    	" delflg INTEGER DEFAULT 0 NOT NULL, stamp timestamp,"
		    	                + " PRIMARY KEY(tcode))";
	     
		     x = stmt.executeUpdate(sql);
		     
 			 response.getWriter().append("<p>※ " + TYUMON + " : " + x + "</p>");
	         System.out.println("※ " + TYUMON + " : " + x); 
 	         
		     ////////////////////////////////
		     sql ="CREATE TABLE IF NOT EXISTS " + MEISAI + 
		    	"(mcode INTEGER NOT NULL AUTO_INCREMENT, " +
		    	"mtyumon INTEGER NOT NULL REFERENCES "+ TYUMON +"(tcode), " +
		    	"mshohin INTEGER NOT NULL REFERENCES "+ SHOHIN +"(scode), " +
		    	"mkosuu INTEGER DEFAULT 1 NOT NULL, " +
		    	" delflg INTEGER DEFAULT 0 NOT NULL, stamp timestamp,"
		    	                + " PRIMARY KEY(mcode))";
	     
		     x = stmt.executeUpdate(sql);
		     
 			 response.getWriter().append("<p>※ " + MEISAI + " : " + x + "</p>");
	       System.out.println("※ " + MEISAI + " : " + x); 
 	         
	         
	         
		     ////////////////////////////////
		     sql ="CREATE TABLE IF NOT EXISTS " + KANRI + 
		    	"(acode INTEGER NOT NULL, " +
		    	"aname VARCHAR(80) NOT NULL, apass VARCHAR(100) NOT NULL, " +
		    	" delflg INTEGER DEFAULT 0 NOT NULL, stamp timestamp,"
		    	                + " PRIMARY KEY(acode))";
	     
		     x = stmt.executeUpdate(sql);
		     
 			 response.getWriter().append("<p>※ " + KANRI + " : " + x + "</p>");
	      System.out.println("※ " + KANRI + " : " + x); 
 	         
	         
			
		}catch (Exception e) {
	         e.printStackTrace();
		}

		 con.closeDb();

			 response.getWriter().append("<p>※ END ※</p>");
		 // System.out.println("※ END ※"); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
