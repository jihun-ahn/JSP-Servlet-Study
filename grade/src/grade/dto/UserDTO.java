package grade.dto;

public class UserDTO {
	private String id;
	private String name;
	private String pwd;
	private String u_class;
	private String job;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getU_class() {
		return u_class;
	}
	public void setU_class(String u_class) {
		this.u_class = u_class;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
}
