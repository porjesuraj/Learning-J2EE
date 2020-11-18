package pojo;

public class voters {

	private int id;
	private String name;
	private String email;
	private String password;
	private boolean status;
	private String role;
	
	
	public voters() {
		this(0,"","","",false,""); 
	}
	
	
	public voters(int id, String name, String email, String password, boolean status, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.status = status;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "voters [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", status="
				+ status + ", role=" + role + "]";
	} 
	
	
	
}
