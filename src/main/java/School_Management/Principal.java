package School_Management;

import javax.persistence.Entity;

@Entity
public class Principal {
	
	
	private int Id;
	private String Name;
	private int Age;
	private long Mobile_Number;
	@javax.persistence.Id
	private String Email;
	private String Password;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public long getMobile_Number() {
		return Mobile_Number;
	}
	public void setMobile_Number(long mobile_Number) {
		Mobile_Number = mobile_Number;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
}
