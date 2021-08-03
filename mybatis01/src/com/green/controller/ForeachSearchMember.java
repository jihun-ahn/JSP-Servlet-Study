package com.green.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAO2;
import com.green.vo.MemberVO;

/**
 * Servlet implementation class ForeachSearchMember
 */
@WebServlet("/FSM")
public class ForeachSearchMember extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> names = new ArrayList<>();
		names.add("김길동");
		names.add("이길동");
		names.add("홍길동");
		MemberDAO2 dao2 = MemberDAO2.getInstance();
		List<MemberVO> lists = dao2.foreachSearchMember(names);
		
		request.setAttribute("lists", lists);
		
		String url = "member/lists.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
