package lumpofyums;

public class User {

	int id;
	String username;
	String email;
	String address;
	String password;
	String first_name;
	String last_name;
	int phone;
	String gender;
	String question;
	String answer;

	public User(String username, String email, String address, String password, String first_name, String last_name,
			int phone, String gender, String question, String answer) {
		this.username = username;
		this.email = email;
		this.address = address;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.gender = gender;
		this.question = question;
		this.answer = answer;

	}

	// Id declaration

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Username declaration

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	// Email declaration

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Address declaration

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// Password declaration

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// first_name declaration

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	// last_name declaration

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	// phone number declaration

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	// gender declaration

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void getAnswer(String answer) {
		this.answer = answer;
	}

}
