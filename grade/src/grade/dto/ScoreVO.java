package grade.dto;

import java.util.List;

public class ScoreVO {
	private String name;
	private List<Integer> scores;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getScores() {
		return scores;
	}
	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}
}
