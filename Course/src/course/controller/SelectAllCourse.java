package course.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.dao.CourseDAO;
import course.dto.CourseDTO;
import course.dto.CourseVO;

@WebServlet("/SelectAllCourse")
public class SelectAllCourse extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "selectCourse.jsp";
		CourseDAO dao = CourseDAO.getInstance();
		List<CourseVO> list = dao.selectAllCourse();
		List<CourseDTO> courseList = new ArrayList<>();
		
		for(CourseVO cVo:list) {
			CourseDTO cDto = new CourseDTO();
			cDto.setId(cVo.getId());
			cDto.setName(cVo.getName());
			cDto.setCredit(Integer.toString(cVo.getCredit()));
			cDto.setLecturer(cVo.getLecturer());
			String week = "";
			switch(cVo.getWeek()) {
			case 1:
				week="월";
				break;
			case 2:
				week="화";
				break;
			case 3:
				week="수";
				break;
			case 4:
				week="목";
				break;
			case 5:
				week="금";
				break;
			case 6:
				week="토";
				break;
			}
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
			cDto.setWeek(week);
			cDto.setStart_hour(sHour);
			cDto.setEnd_hour(eHour);
			
			courseList.add(cDto);
		}
		
		request.setAttribute("courseList", courseList);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
