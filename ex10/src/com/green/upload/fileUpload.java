package com.green.upload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upLoad.do")
public class fileUpload extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	// 데이터 받아올 때
		response.setContentType("text/html; charset=UTF-8"); // 작성할 때 
		
		PrintWriter out = response.getWriter();
		
		String savePath = "Upload";	// 업로드 위치
		
		int uploadFileSizeLimit = 5*1024*1024;	// 최대 업로드 파일 크기
		
		String encType= "UTF-8";
		
		ServletContext context = getServletContext();
		
		String uploadFilePath = "C:\\Study\\Upload";	// 서버상 실제 디렉토리
			// C:/study/~~
		System.out.println("서버상의 실제 디렉토리: "+uploadFilePath);
		
		try {
			MultipartRequest multi = 
					new MultipartRequest(
							request, // 폼으로부터 얻어 온 request 객체
							uploadFilePath, // 서버상 실제 디렉토리 위치
							uploadFileSizeLimit, 	// 최대 업로드 파일 크기
							encType,	// 파일 이름 인코딩 방식
							new DefaultFileRenamePolicy()	// 동일 이름의 파일이 존재할 경우 사용할 정책
							// 동일 이름 파일 존재시 이름 부여
							);
			
			String fileName = multi.getFilesystemName("fileupload");
			// 업로드가 정상적으로 되었다면 읽어 올 파일 이름 얻기

			if(fileName == null) { // 파일 업로드 실패
				System.out.println("파일 업로드 실패");
			}else {	// 파일 업로드 성공
				out.println("<br> 글쓴이 :"+multi.getParameter("name"));
				out.println("<br> 글제목 :"+multi.getParameter("title"));
				out.println("<br> 파일명 :"+fileName);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
