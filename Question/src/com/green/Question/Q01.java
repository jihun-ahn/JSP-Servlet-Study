package com.green.Question;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		
		HttpSession session = request.getSession(); // 서블릿에서 세션 사용할 때 선언
		
		
		int sumScore = score1+score2+score3;
		double avg = sumScore/3.0;
		System.out.println("총점 : "+sumScore);
		System.out.println("평균 : "+avg);
		
		request.setAttribute("score1", score1);
		request.setAttribute("score2", score2);
		request.setAttribute("score3", score3);
		request.setAttribute("sumScore", sumScore);
		request.setAttribute("avg", avg);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("q01.jsp");
		dispatcher.forward(request, response);
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
