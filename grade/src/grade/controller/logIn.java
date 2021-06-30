package grade.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import grade.dao.GradeDAO;
import grade.dto.UserDTO;

@WebServlet("/logIn")
public class logIn extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = null;
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		GradeDAO dao = GradeDAO.getInstance();
		UserDTO dto = dao.selectStudentSignIn(id);
		if(dto.getId()==null) {
			dto = dao.selectTeacherSignIn(id);
		}
		
		if(dto!=null && id.equals(dto.getId()) && pwd.equals(dto.getPwd())) {
			HttpSession session = request.getSession();
			session.setAttribute("dto", dto);
			
			if(dto.getJob().equals("student")) {
				url = "studentMain.jsp";
			}else {
				url = "teacherMain.jsp";
			}
		}else {
			url = "failLogin.jsp";
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
