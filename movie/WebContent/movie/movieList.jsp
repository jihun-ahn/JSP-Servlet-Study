<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@	page import="java.util.ArrayList"%>
<%@ page import="com.movie.vo.MovieVO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 목록</title>
<link type="text/css" rel="stylesheet" href="css/movie.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>영화 목록</h1>
		
		<table>
			<tr>
				<td colspan="6" style="text-align: right; border:white">
					<a href="MS?command=movie_write_form">영화 등록</a>
				</td>
			</tr>
			<tr>
				<th>포스터</th>
				<th>번호</th>
				<th>제목</th>
				<th>감독/배우</th>
				<th>제작비</th>
				<th>평점</th>
			</tr>
			<%
				List<MovieVO> movieList = (List<MovieVO>)request.getAttribute("movieList");
				for(MovieVO movie:movieList){
					out.println("<tr>");
					out.println("<td class='poster'>"+"<img src='upload/"+movie.getImageurl()+"'>"+"</td>");
					out.println("<td>"+movie.getCode()+"</td>");
					out.println("<td>"+"<a href="+"'MS?command=movie_view_form&num="+movie.getCode()+"'>"+movie.getTitle()+"</a>"+"</td>");
					out.println("<td>"+movie.getDirector()+"/"+movie.getActor()+"</td>");
					out.println("<td>"+movie.getCost()+"</td>");
					out.println("<td>"+movie.getScore()+"</td>");
					out.println("</tr>");
				}
			
			%>
		</table>
	</div>
</body>
</html>