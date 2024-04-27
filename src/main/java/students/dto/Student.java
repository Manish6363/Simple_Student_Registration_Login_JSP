package students.dto;

public class Student {
	private String name;
	private int id;
	private String email;
	private long phone;
	private int age;
	private String gender;
	private String address;
	private String password;
	
	public Student(String name, int id, String email, long phone, int age, String gender, String address,
			String password) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", email=" + email + ", phone=" + phone + ", age=" + age
				+ ", gender=" + gender + ", address=" + address + ", password=" + password + "]";
	}
	
}

