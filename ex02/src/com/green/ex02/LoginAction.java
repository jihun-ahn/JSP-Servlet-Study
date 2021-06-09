package com.green.ex02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpassword");
		String userName = request.getParameter("username");
		System.out.println("아이디 : "+userId);
		System.out.println("비밀번호 : "+userPwd);
		System.out.println("이름 : "+userName);
		
		System.out.println("doGet메서드 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpassword");
		String userName = request.getParameter("username");
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		
		
		System.out.println("아이디 : "+userId);
		System.out.println("비밀번호 : "+userPwd);
		System.out.println("이름 : "+userName);
		System.out.println("성별 : "+gender);
		for(String hobby:hobbys) {
			System.out.println("취미 : "+hobby);
		}
		System.out.println("doPost메서드 실행");
	}

}
