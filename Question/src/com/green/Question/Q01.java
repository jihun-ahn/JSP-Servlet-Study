package com.green.Question;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Q01
 */
@WebServlet("/Q01")
public class Q01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Q01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int score1 = Integer.parseInt(request.getParameter("score1"));
		int score2 = Integer.parseInt(request.getParameter("score2"));
		int score3 = Integer.parseInt(request.getParameter("score3"));
		int score4 = Integer.parseInt(request.getParameter("score4"));
		int score5 = Integer.parseInt(request.getParameter("score5"));
		
		int sumScore = score1+score2+score3+score4+score5;
		
		System.out.println("총점 : "+sumScore);
		System.out.println("평균 : "+sumScore/5.0);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpassword");
		
		if(userId.equals("green") && userPwd.equals("1234")) {
			System.out.println("로그인 성공");
		}else{
			System.out.println("로그인 실패");
		}
	}

}
