package com.green.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.beans.Member;

/**
 * Servlet implementation class inputmember
 */
@WebServlet("/IM")
public class inputmember extends HttpServlet {


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 자바빈 객체 생성
		Member member = new Member();
		
		// 2. 자바빈 객체의 프로퍼티 저장
		member.setUserId("hong");
		member.setUserName("홍길동");
		
		// 3. 리퀘스트 내장 객체에 자바빈 객체 저장
		request.setAttribute("member", member);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ex08_result.jsp");
		dispatcher.forward(request, response);
	}


}
