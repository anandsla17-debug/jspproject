package Controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
