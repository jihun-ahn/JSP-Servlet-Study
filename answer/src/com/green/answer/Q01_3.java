package com.green.answer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Q01_3
 */
@WebServlet("/Q01_3")
public class Q01_3 extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String[] dans = request.getParameterValues("gugudan");
		String str="";
		
		List<String> result = new ArrayList<>();
		for(String dan: dans) {
			str="***"+dan+"단***<br>";
			for(int i=1;i<=9;i++) {
				str += dan+"X"+i+"="+Integer.parseInt(dan)*i+"<br>";
			}
			result.add(str);
		}
		
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("q03.jsp");
		dispatcher.forward(request, response);
	}

}
