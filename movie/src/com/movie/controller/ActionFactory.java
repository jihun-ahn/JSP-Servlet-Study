package com.movie.controller;

import com.movie.controller.action.Action;
import com.movie.controller.action.MovieListAction;
import com.movie.controller.action.MovieViewAction;
import com.movie.controller.action.MovieViewFormAction;
import com.movie.controller.action.MovieWriteAction;
import com.movie.controller.action.MovieWriteFormAction;

class ActionFactory {
	
	// 싱글톤패턴	
	private ActionFactory() {}
	private static ActionFactory af = new ActionFactory();
	public static ActionFactory getInstance() {
		return af;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("movie_list")) {
			action = new MovieListAction();
		}else if(command.equals("movie_write_form")) {
			action = new MovieWriteFormAction();
		}else if(command.equals("movie_write")) {
			action = new MovieWriteAction();
		}else if(command.equals("movie_view_form")) {
			action = new MovieViewFormAction();
		}else if(command.equals("movie_view")) {
			action = new MovieViewAction();
		}
		
		return action;
	}
}
