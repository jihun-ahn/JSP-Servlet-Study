package com.green.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.dao.MemberDAO;
import com.green.vo.MemberVo;

@WebServlet("/login.do")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/login.jsp";
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")!=null) {	// 현재 로그인 한 상태라면
			url="main.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/login.jsp";
		
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.userCheck(userid, userpwd);
		
		if(result == 1) { // 로그인 성공
			MemberVo mVo = dao.getMember(userid);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mVo);
			request.setAttribute("message", "로그인 성공");
			
			url = "main.jsp";
			
		}else if(result == 0) { // 비밀번호가 틀린 경우
			
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
			
		}else if(result == -1) { // 아이디가 없는 경우
			
			request.setAttribute("message", "존재하지 않는 회원입니다.");
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
