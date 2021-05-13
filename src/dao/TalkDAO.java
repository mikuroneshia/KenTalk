package dao;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class TalkDAO extends DAO{
	public static void setTalkRec(String room,String f,String t,String sentense,String date) {
		getConnect();
		String sql="insert into talk values('"+room+"','"+f+"','"+t+"','"+sentense+"','"+date+"')";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<ArrayList<String>> getSentense(String from,String to){
		getConnect();
		ArrayList<ArrayList<String>> sentenseList=new ArrayList<>();
		String sql="select f,sentense,date from talk where room='"+from+"&"+to+"' or room='"+to+"&"+from+"'";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ArrayList<String> list=new ArrayList<>();
				String f=rs.getString("f");
				String sentense=rs.getString("sentense");
				String date=null;
				date=rs.getString("date");
				list.add(f);
				list.add(sentense);
				list.add(date);
				sentenseList.add(list);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return sentenseList;
	}
	
	public static void main(String[]args) {
		getConnect();
		String sql="select * from talk";
		try {
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		ResultSetMetaData meta = rs.getMetaData();
		System.out.println("カラム数：" + meta.getColumnCount());
		System.out.println("5つ目のカラム名：" + meta.getColumnName(5));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		getSentense("miyosi","吉岡裕貴");
	}
}
