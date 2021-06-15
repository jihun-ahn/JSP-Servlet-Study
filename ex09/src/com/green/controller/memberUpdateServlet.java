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

@WebServlet("/memberUpdate.do")
public class memberUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVo mVo = dao.getMember(userid);
		
		request.setAttribute("mVo", mVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberUpdate.jsp");
		dispatcher.forward(request, response);
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
		dao.updateMember(mVo);
		
		response.sendRedirect("login.do");
		
		
	}

}
