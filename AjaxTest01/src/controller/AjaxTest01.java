package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AjaxTest01")
public class AjaxTest01 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		System.out.println("넘어온 값 : "+userId);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String _userId = request.getParameter("userId");
		System.out.println("넘어온 값 1: "+_userId);
		
		String userId = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		
		InputStream is = request.getInputStream();
		
		if(is!=null) {
//			System.out.println("is소환");
			br = new BufferedReader(new InputStreamReader(is));
			char[] charBuffer = new char[128];
			int byteRead = -1;
			while((byteRead = br.read(charBuffer))>0) {
				System.out.println("chk: "+byteRead);
				sb.append(charBuffer,0,byteRead);
			}
			
		}
		
		br.close();
		is.close();
		
		userId = sb.toString();
		System.out.println("넘어온 값 2: "+userId);
		
	}

}
