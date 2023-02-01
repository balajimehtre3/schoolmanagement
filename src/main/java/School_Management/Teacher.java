package School_Management;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher {
	
	@Id
	private int id;
	private String Name;
	private String Subject;
	private double Salarys;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public double getSalarys() {
		return Salarys;
	}
	public void setSalarys(double salarys) {
		Salarys = salarys;
	}
	
	
}
