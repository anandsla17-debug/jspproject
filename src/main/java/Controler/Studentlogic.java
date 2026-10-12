package Controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.DbConnection;
import Model.Studentmodel;

public class Studentlogic  {

	
	
	Connection conn=DbConnection.dbconnection();
	String insert="insert into examtable(studentid,sname,dob,aadharno) value(?,?,?,?)";
	public String storestudentlogic(Studentmodel student)   {
		String result=null;
		try {
		PreparedStatement ps= conn.prepareStatement(insert);
		ps.setInt(1, student.getStudentid());
		ps.setString(2, student.getSname());
		ps.setString(3,student.getDob());
		ps.setLong(4, student.getAadharno());
	int row	=ps.executeUpdate();
	if(row==1) {
		result= "student record stored successfully";
	}
		}catch(SQLException e) {
			result= "register is failed resson:"+e.getMessage();
		}
		return result;
		
	}
	
	
	String login="select * from examtable where studentid=? and aadharno=?";
	
	public String studentlogin(Studentmodel studentmodel) {
		String result=null;
		try {
			PreparedStatement ps= conn.prepareStatement(login);
			ps.setInt(1,studentmodel.getStudentid());
			ps.setLong(2, studentmodel.getAadharno());
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				String id=String.valueOf(rs.getInt("studentid"));
				String aadharno=String.valueOf(rs.getLong("aadharno"));
				result=id+aadharno;

			}else {
				result="login failed";
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			result=e.getMessage();
		}
		return result;
	}
}
