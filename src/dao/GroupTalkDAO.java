package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public class GroupTalkDAO extends DAO{
	public static ArrayList<ArrayList<String>> getGroupTalk(){
		getConnect();
		ArrayList<ArrayList<String>> groupTalk=new ArrayList<>();
		String sql="select * from grouptalk";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ArrayList<String>array=new ArrayList<>();
				String from=rs.getString("f");
				String sentense=rs.getString("sentense");
				String date=rs.getString("date");
				array.add(from);
				array.add(sentense);
				array.add(date);
				groupTalk.add(array);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return groupTalk;
	}
	public static void setGroupTalk(String f,String sentense,String date) {
		getConnect();
		String sql="insert into grouptalk values('"+f+"','"+sentense+"','"+date+"')";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
