package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/AjaxQuestion01")
public class AjaxQuestion01 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		
		System.out.println("넘어온 값 : "+userId);
		
		MemberDAO dao = MemberDAO.getInstance();
		List<MemberDTO> list = dao.selectAllMember();
		PrintWriter out = response.getWriter();
		int chk = -1;
		for(MemberDTO member:list) {
			if(member.getUserId().equals(userId)){
				out.println("중복된 ID가 존재합니다.");
				chk=0;
			}
		}
		if(chk==-1) {
			out.println("사용 가능한 ID입니다.");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
