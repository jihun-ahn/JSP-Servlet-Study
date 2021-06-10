<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		double temp = Double.parseDouble(request.getParameter("temp"));
		
		session.setAttribute("name", name);
		RequestDispatcher rd;
		if(temp<=37.5){
			rd = request.getRequestDispatcher("q04_negative.jsp");
			rd.forward(request, response);
		}else{
			rd = request.getRequestDispatcher("q04_chkbox.jsp");
			rd.forward(request, response);
		}
	
	%>
</body>
</html>