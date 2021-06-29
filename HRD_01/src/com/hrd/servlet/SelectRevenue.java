package com.hrd.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrd.dao.MemberDAO;
import com.hrd.vo.RevenueVO;

/**
 * Servlet implementation class SelectRevenue
 */
@WebServlet("/SelectRevenue")
public class SelectRevenue extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "memberRevenue.jsp";
		
		MemberDAO dao = MemberDAO.getInstance();
		List<RevenueVO> list = dao.selectAllRevenue();
		
		request.setAttribute("revenueList", list);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
