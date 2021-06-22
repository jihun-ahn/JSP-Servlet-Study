package com.hrd.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrd.dao.MemberDAO;
import com.hrd.vo.MemberVO;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "memberInsert.jsp";
		MemberDAO dao = MemberDAO.getInstance();
		request.setAttribute("lastCustno", dao.selectLastNum());		
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "insertSucess.jsp";
		
		MemberVO mVo = new MemberVO();
		mVo.setCustno(Integer.parseInt(request.getParameter("custno")));
		mVo.setCustname(request.getParameter("custname"));
		mVo.setPhone(request.getParameter("phone"));
		mVo.setAddress(request.getParameter("address"));
		Timestamp joindate = null;
		try {
		   joindate = 
		         new Timestamp(new SimpleDateFormat("yyyyMMdd").parse(request.getParameter("joindate")).getTime());
		}catch (ParseException e) {
		   e.printStackTrace();
		}
		mVo.setJoindate(joindate);
		mVo.setGrade(request.getParameter("grade"));
		mVo.setCity(request.getParameter("city"));
		MemberDAO dao = MemberDAO.getInstance();
		dao.insertMember(mVo);

//		response.sendRedirect(url);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
