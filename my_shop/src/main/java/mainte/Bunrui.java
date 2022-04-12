package mainte;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ConDb;
import common.Names;
/**
/**
 * Servlet implementation class Bunrui
 */
@WebServlet("/Bunrui")
public class Bunrui extends HttpServlet implements Names{

	private static final long serialVersionUID = 1L;

    private static ConDb db;
    private static List<String> cols; 
    private static List<ArrayList<String>> datas; 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bunrui() {
        super();
        // TODO Auto-generated constructor stub
        try {
            
        	db = new ConDb(DBNAME);
        	
       	   cols = db.getCnames(BUNRUI);
        	
        	db.closeDb();
        	
        }catch (Exception e) {}
    }

    private void getDatas() {
        try {
            
        	db = new ConDb(DBNAME);
        	
       		datas = db.getAll(BUNRUI);
        	
        	db.closeDb();
        	
        }catch (Exception e) {}
    	
    }
    
    private void getData(int code) {
        try {
            
        	db = new ConDb(DBNAME);
        	
        	if(code == 0) {
        		datas = db.getAll(BUNRUI);
        	}
        	
        	
        	
        	
        	
        	
        	db.closeDb();
        	
        }catch (Exception e) {}
    	
    }
	private void insert(HttpServletRequest request, HttpServletResponse response) {
		
        try {

          String bcode = request.getParameter("bcode");
          String bname = request.getParameter("bname");
          String delflg = request.getParameter("delflg");
            
            System.out.println(bcode + " " + bname + " " + delflg);
            
        	
        }catch (Exception e) {
			// TODO: handle exception
		}

	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 response.setContentType("text/html; charset=UTF-8");  
         request.setCharacterEncoding("UTF-8");

         request.setAttribute("cols", cols);

         if(request.getParameter("insert") != null && !request.getParameter("insert").equals("")) {
             insert(request,response);
             	getDatas();
         }
         
         if(request.getParameter("search") != null && !request.getParameter("search").equals("")) {
        	String code = request.getParameter("code");
        	if(code == null || code.equals("")) code = "0";
             getData(Integer.parseInt(code));
         }
         
         request.setAttribute("datas", datas);         

         ServletContext sc = getServletContext();
         
        sc.getRequestDispatcher("/mainte/Bunrui.jsp").forward(request, response);

         

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
