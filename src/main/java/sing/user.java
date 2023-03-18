package sing;

public class user {
	int id;
	String name;
	String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public user(int id, String name, String email, String password, String mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
	}

	public user(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	String password;
	String mobileNo;

	public user(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public user(String name, String email, String password, String mobileNo) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

}
