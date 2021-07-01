package grade.dto;

public class ScoreClassDTO {
	private String name;
	private double class_kor;
	private double class_eng;
	private double class_math;
	private double class_sci;
	private double class_soc;
	private double class_total;
	private double class_avg;
	
	
	public ScoreClassDTO(String name) {
		this.name = name;
		this.class_kor = 0;
		this.class_eng = 0;
		this.class_math = 0;
		this.class_sci = 0;
		this.class_soc = 0;
		this.class_total = 0;
		this.class_avg = 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getClass_kor() {
		return class_kor;
	}
	public void setClass_kor(double class_kor) {
		this.class_kor = class_kor;
	}
	public double getClass_eng() {
		return class_eng;
	}
	public void setClass_eng(double class_eng) {
		this.class_eng = class_eng;
	}
	public double getClass_math() {
		return class_math;
	}
	public void setClass_math(double class_math) {
		this.class_math = class_math;
	}
	public double getClass_sci() {
		return class_sci;
	}
	public void setClass_sci(double class_sci) {
		this.class_sci = class_sci;
	}
	public double getClass_soc() {
		return class_soc;
	}
	public void setClass_soc(double class_soc) {
		this.class_soc = class_soc;
	}
	public double getClass_total() {
		return class_total;
	}
	public void setClass_total(double class_total) {
		this.class_total = class_total;
	}
	public double getClass_avg() {
		return class_avg;
	}
	public void setClass_avg(double class_avg) {
		this.class_avg = class_avg;
	}
		
}
