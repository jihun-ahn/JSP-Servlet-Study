package com.green.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAO;
import com.green.vo.MemberVo;


@WebServlet("/join.do")
public class joinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher("member/join.jsp");
		dispatch.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int admin = Integer.parseInt(request.getParameter("admin"));
		
		MemberVo mVo = new MemberVo();
		mVo.setName(name);
		mVo.setUserid(userid);
		mVo.setUserpwd(userpwd);
		mVo.setEmail(email);
		mVo.setPhone(phone);
		mVo.setAdmin(admin);
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.insertMember(mVo);
		
		if(result==1) {
			request.setAttribute("message", "회원가입 성공");
			request.setAttribute("userid", userid);
		}else {
			request.setAttribute("message", "회원가입 실패");
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher("member/login.jsp");
		dispatch.forward(request, response);
	}

}
