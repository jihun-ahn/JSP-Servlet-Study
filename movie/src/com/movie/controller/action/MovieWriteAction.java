package com.movie.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.dao.MovieDAO;
import com.movie.vo.MovieVO;

public class MovieWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String url = "MS?command=movie_list";
//		MovieVO mVo = new MovieVO();
//		mVo.setTitle(request.getParameter("title"));
//		mVo.setDirector(request.getParameter("director"));
//		mVo.setActor(request.getParameter("actor"));
//		mVo.setCost(Integer.parseInt(request.getParameter("cost")));
//		mVo.setImageurl((request.getParameter("imageurl")));
//		mVo.setScore(Double.parseDouble(request.getParameter("score")));
//		
//		MovieDAO dao = MovieDAO.getInstance();
//		dao.insertMovie(mVo);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
