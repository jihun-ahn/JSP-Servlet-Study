package com.movie.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.dao.MovieDAO;
import com.movie.vo.MovieVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/IS")
public class InsertServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String savePath = "upload";
		ServletContext context = getServletContext();
		String path = context.getRealPath(savePath);
		int fileSize = 100*1024*1024;
		String encType = "UTF-8";
		
		try {
			MultipartRequest multi =
					new MultipartRequest(
							request,
							path,
							fileSize,
							encType,
							new DefaultFileRenamePolicy()
							);
			
			MovieVO mVo = new MovieVO();
			
			mVo.setTitle(multi.getParameter("title"));
			mVo.setDirector(multi.getParameter("director"));
			mVo.setActor(multi.getParameter("actor"));
			mVo.setCost(Integer.parseInt(multi.getParameter("cost")));
			mVo.setImageurl(multi.getFilesystemName("imageurl"));
			mVo.setScore(Double.parseDouble(multi.getParameter("score")));
			
			System.out.println(multi.getFilesystemName("imageurl"));
			MovieDAO dao = MovieDAO.getInstance();
			
			dao.insertMovie(mVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("MS?command=movie_list");
		
	}

}
