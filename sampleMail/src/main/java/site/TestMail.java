package site;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mail.MailSend;

/**
 * Servlet implementation class TestMail
 */
@WebServlet("/TestMail")
public class TestMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestMail() {
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
		
		response.getWriter().append("メール送信 ").append(request.getContextPath());
		
		//テスト　ダミー データ
		String[][] strs = {
				{"衣類","5000","2",""},
				{"食品","300","10", ""},
				{"ドリンク","250","20", ""},
		 };

		// データ  datas 
		List<List<String>> datas = new ArrayList<List<String>>();
	

		int sum= 0;
		for(int i = 0; i < strs.length; i++) {
			strs[i][3] = String.format("%,d", Integer.parseInt(strs[i][1]) * Integer.parseInt(strs[i][2]));
			sum += Integer.parseInt(strs[i][1]) * Integer.parseInt(strs[i][2]);
			datas.add(Arrays.asList(strs[i]));
		}

		
		//テスト　データ合計　goukei
		String goukei = String.format("%,d", sum);
		
		//　テスト ユーザー
		String uname = "横浜 花子" + " : 04-12";
		String umail = "sendai.ts@gmail.com";
		
		//メール 送信
		 MailSend send = new MailSend();
	     send.mail( datas , uname,  umail,  goukei);

	     //	     send.mail( request,  response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
