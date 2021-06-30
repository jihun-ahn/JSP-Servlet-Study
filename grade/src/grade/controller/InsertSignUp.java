package grade.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grade.dao.GradeDAO;
import grade.dto.UserDTO;

@WebServlet("/InsertSignUp")
public class InsertSignUp extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "signUp.jsp";
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "index.jsp";
		
		UserDTO dto = new UserDTO();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String u_class = request.getParameter("u_class");
		String job = request.getParameter("job");
		
		dto.setId(id);
		dto.setName(name);
		dto.setPwd(pwd);
		dto.setU_class(u_class);
		dto.setJob(job);
		
		GradeDAO dao = GradeDAO.getInstance();
		dao.insertSignUp(dto);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
