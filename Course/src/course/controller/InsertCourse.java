package course.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.dao.CourseDAO;
import course.dto.CourseVO;

/**
 * Servlet implementation class InsertCourse
 */
@WebServlet("/InsertCourse")
public class InsertCourse extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "insertCourse.jsp";
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "SelectAllCourse";
		
		CourseVO cVo = new CourseVO();
		cVo.setId(request.getParameter("id"));
		cVo.setName(request.getParameter("name"));
		cVo.setLecturer(request.getParameter("lecturer"));
		cVo.setCredit(Integer.parseInt(request.getParameter("credit")));
		cVo.setWeek(Integer.parseInt(request.getParameter("week")));
		cVo.setStart_hour(Integer.parseInt(request.getParameter("start_hour")));
		cVo.setEnd_hour(Integer.parseInt(request.getParameter("end_hour")));
		
		CourseDAO dao = CourseDAO.getInstance();
		dao.insertCourse(cVo);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
