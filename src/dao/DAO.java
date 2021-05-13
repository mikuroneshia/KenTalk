package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javaBeans.Account;

import java.sql.Connection;

public class DAO {
	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	//static String driver="jdbc:mysql://35.243.126.151/kentalk?characterEncoding=UTF-8";
	static String driver="jdbc:mysql://localhost/kentalk?characterEncoding=UTF-8";
	public static void getConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(driver, "root", "");
			System.out.println("接続成功");
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();  
		}
	}
	
	public static void setName(String oldName,String newName) {
		getConnect();
		String sql="update kentalk set name='"+newName+"'where name='"+oldName+"';";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void setAge(String name,int newAge) {
		getConnect();
		try {
			String sql="update kentalk set age='"+newAge+"'where name='"+name+"';";
			pstmt=con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			
		}
	}
	
	public static void setHobby(String name,String newHobby) {
		getConnect();
		String sql="update kentalk set hobby='"+newHobby+"'where name='"+name+"';";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void setAccount(String name,int age,String birthplace,String birthday,String pass) {
		getConnect();
		String sql="insert into kentalk(name,age,birthplace,birthday,pass) values('"+name+"',"+age+",'"+birthplace+"','"+birthday+"','"+
				pass+"');";
		try {
		pstmt=con.prepareStatement(sql);
		pstmt.executeUpdate();
		//System.out.println("書き込み完了");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<String> getName() {
		ArrayList<String>nameList=new ArrayList<>();
		getConnect();
		String sql="select name from kentalk";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String name=rs.getString("name");
				nameList.add(name);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return nameList;
	}
	public static Account getAccount(String name) {
		getConnect();
		String sql="select * from kentalk where name='"+name+"';";
		Account account=null;
		try {
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			name=rs.getString("name");
			int age=rs.getInt("age");
			String birthplace=rs.getString("birthplace");
			String birthday=rs.getString("birthday");
			String pass=rs.getString("pass");
			String hobby=rs.getString("hobby");
			account=new Account(name,age,birthplace,birthday,pass,hobby);
		}
		System.out.println("got account");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return account;
	}
	
	public static String getPass(String name) {
		String pass=null;
		String sql="select pass from kentalk where name='"+name+"'";
		getConnect();
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				pass=rs.getString("pass");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return pass;
	}
	
	public static void select() {
		getConnect();
		String sql="select * from sampledb.kentalk";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String rsName=rs.getString("name");
				int rsAge=rs.getInt("age");
				String rsBirthplace=rs.getString("birthplace");
				String rsBirthday=rs.getString("birthday");
				System.out.println("name:"+rsName);
				System.out.println("age:"+rsAge);
				System.out.println("birthplace:"+rsBirthplace);
				System.out.println("birthday:"+rsBirthday);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		//setAccount("yamada",22,"山形県","1998-06-27");
		//getAccount("miyosi");
	}
}
