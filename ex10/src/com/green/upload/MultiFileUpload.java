package com.green.upload;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upLoad2.do")
public class MultiFileUpload extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String uploadFilePath = "C:\\study\\Upload";
		int uploadFileSizeLimit = 5*1024*1024;
		String encType = "UTF-8";
		
		try {
			MultipartRequest multi = 
					new MultipartRequest(
							request, 
							uploadFilePath, 
							uploadFileSizeLimit,
							encType, 
							new DefaultFileRenamePolicy()
							);
			
			
			if(multi == null) {
				System.out.println("업로드 실패");
			}else {
				System.out.println("업로드 성공");
			}
			
			Enumeration<String> fileNames = multi.getFileNames();
			while(fileNames.hasMoreElements()) {
				String file = (String)fileNames.nextElement();	// input태그 name 값 (name="upLoadFile~")
				String fileName = multi.getFilesystemName(file);	// 실제 파일 이름
				
				String originFileName = multi.getOriginalFileName(file);	// 정책에 의해 변경되기 전 원본 파일 명
				
				out.println("<br> 업로드된 파일명: "+fileName);
				out.println("<br> 업로드된 원본 파일명: "+originFileName);
				out.println("<hr>");
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
