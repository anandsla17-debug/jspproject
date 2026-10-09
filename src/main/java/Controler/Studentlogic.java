package Controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.DbConnection;
import Model.Studentmodel;

public class Studentlogic  {

	Studentmodel student= new Studentmodel();
	Connection conn=DbConnection.dbconnection();
	String insert="insert into examtable(studentid,sname,dob,aadhar) value(?,?,?,?)";
	public void storestudentlogic()   {
		
		try {
		PreparedStatement ps= conn.prepareStatement(insert);
		ps.setInt(1, student.getStudentid());
		ps.setString(2, student.getSname());
		ps.setString(3,student.getDob());
		ps.setLong(4, student.getAadharno());
	int row	=ps.executeUpdate();
	if(row==1) {
		System.out.println("student record stored successfully");
	}
		}catch(SQLException e) {
			System.out.println("error:"+e.getMessage());
		}
		
	}
}
