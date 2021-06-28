package course.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.dao.CourseDAO;
import course.dto.CourseDTO;
import course.dto.CourseVO;

/**
 * Servlet implementation class ReviseCourse
 */
@WebServlet("/ReviseCourse")
public class ReviseCourse extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "reviseCourse.jsp";
		
		int id = Integer.parseInt(request.getParameter("id"));
		CourseDAO dao = CourseDAO.getInstance();
		CourseVO cVo = dao.selectTargetCourse(id);
		CourseDTO cDto = new CourseDTO();
		
		cDto.setId(cVo.getId());
		cDto.setName(cVo.getName());
		cDto.setCredit(Integer.toString(cVo.getCredit()));
		cDto.setLecturer(cVo.getLecturer());
		cDto.setWeek(Integer.toString(cVo.getWeek()));
		String sHour = "";
		if(cVo.getStart_hour()<1000) {
			sHour="0"+cVo.getStart_hour();
		}else {
			sHour = Integer.toString(cVo.getStart_hour());
		}
		String eHour = "";
		if(cVo.getEnd_hour()<1000) {
			eHour="0"+cVo.getEnd_hour();
		}else {
			eHour = Integer.toString(cVo.getEnd_hour());
		}
		cDto.setStart_hour(sHour);
		cDto.setEnd_hour(eHour);	
		
		request.setAttribute("cDto", cDto);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "SelectAllCourse";
		
		CourseDAO dao = CourseDAO.getInstance();
		CourseVO cVo = new CourseVO();
		cVo.setId(request.getParameter("id"));
		cVo.setName(request.getParameter("name"));
		cVo.setCredit(Integer.parseInt(request.getParameter("credit")));
		cVo.setLecturer(request.getParameter("lecturer"));
		cVo.setWeek(Integer.parseInt(request.getParameter("week")));
		cVo.setStart_hour(Integer.parseInt(request.getParameter("start_hour")));
		cVo.setEnd_hour(Integer.parseInt(request.getParameter("end_hour")));
		
		dao.updateCourse(cVo);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
