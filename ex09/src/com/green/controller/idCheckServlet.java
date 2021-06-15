package com.green.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAO;

/**
 * Servlet implementation class idCheckServlet
 */
@WebServlet("/idCheck.do")
public class idCheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.confirmID(userid);
		
		request.setAttribute("userid", userid);
		request.setAttribute("result", result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/idCheck.jsp");
		dispatcher.forward(request, response);
	}

}
