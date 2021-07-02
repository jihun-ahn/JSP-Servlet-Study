package grade.dto;

import java.util.List;

public class ScoreClassDTO {
	private String class_name;
	private List<Double> class_avg;
	private double total_avg;
	private double all_avg;
	
	public ScoreClassDTO(String class_name) {
		this.class_name = class_name;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public List<Double> getClass_avg() {
		return class_avg;
	}
	public void setClass_avg(List<Double> class_avg) {
		this.class_avg = class_avg;
	}
	public double getTotal_avg() {
		return total_avg;
	}
	public void setTotal_avg(double total_avg) {
		this.total_avg = total_avg;
	}
	public double getAll_avg() {
		return all_avg;
	}
	public void setAll_avg(double all_avg) {
		this.all_avg = all_avg;
	}
	
}
