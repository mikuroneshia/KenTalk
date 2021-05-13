package javaBeans;
import java.io.*;

public class Account implements Serializable{
	private String name;
	private int age;
	private String birthplace;
	private String birthday;
	private String pass;
	private String hobby;
	public Account() {
		
	}
	public Account(String name,int age,String birthplace,String birthday,String pass,String hobby) {
		this.name=name;
		this.age=age;
		this.birthplace=birthplace;
		this.birthday=birthday;
		this.pass=pass;
		this.hobby=hobby;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public void setBirthplace(String birthplace) {
		this.birthplace=birthplace;
	}
	public void setBirthday(String birthday) {
		this.birthday=birthday;
	}
	public void setPass(String pass) {
		this.pass=pass;
	}
	public void setHobby(String hobby) {
		this.hobby=hobby;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getBirthplace(){
		return birthplace;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getPass() {
		return pass;
	}
	public String getHobby() {
		return hobby;
	}
}
