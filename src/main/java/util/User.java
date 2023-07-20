package util;

public class User {
	
	private int id;
	private String name;
	private Long phone;
	private String email;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(int id, String name, Long phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	public User(int id, String name, Long phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	
}
