package board.dto;

import java.sql.Timestamp;

public class BoardDTO {
	private int idx;
	private String writer;
	private String subject;
	private String content;
	private Timestamp t_date;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getT_date() {
		return t_date;
	}
	public void setT_date(Timestamp t_date) {
		this.t_date = t_date;
	}
}
