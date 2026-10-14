package Controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	String display="select * from examtable";
	
	
	public ArrayList<Studentmodel>  Alldisplay() {
		ArrayList<Studentmodel>  transfer=new ArrayList<Studentmodel>();
		
		try {
			Connection conn= DbConnection.dbconnection();
			Statement st= conn.createStatement();
		ResultSet rs	=st.executeQuery(display);
		while(rs.next()) {
			
		System.out.println("Studentid:"+rs.getInt("studentid")+",student name:"+rs.getString("sname")
		+"dob:"+rs.getString("dob")+",aadharno:"+rs.getLong("aadharno"));
		Studentmodel studentmodel= new Studentmodel();
		studentmodel.setStudentid(rs.getInt("studentid"));
		studentmodel.setSname(rs.getString("sname"));
		studentmodel.setDob(rs.getString("dob"));
		studentmodel.setAadharno(rs.getLong("aadharno"));
		transfer.add(studentmodel);
		}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("error:"+e.getMessage());
		}
		return transfer;
	}
	
	String update ="update examtable set studentid=?,sname=?,dob=?,aadharno=? where studentid=?";
	public String update(Studentmodel studentmodel) {
		String result=null;
		try {
			PreparedStatement ps=conn.prepareStatement(update);
			ps.setInt(1,studentmodel.getStudentid());
			ps.setString(2,studentmodel.getSname());
			ps.setString(3, studentmodel.getDob());
			ps.setLong(4, studentmodel.getAadharno());
			ps.setInt(5, studentmodel.getStudentid());
			int row = ps.executeUpdate();
			if(row==1) {
				result="updated";
			}else {
				result="not updated";
			}
			
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	String delete="delete from examtable where studentid=?";
	public String studentdelete(Studentmodel studentmodel) {
		String result=null;
		try {
			PreparedStatement ps=conn.prepareStatement(delete);
			ps.setInt(1,studentmodel.getStudentid());
			int row= ps.executeUpdate();
			if(row==1) {
				result="deleted";
			}else {
				result ="not deleted";
			}
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	
	
	
//	public static void main(String[] args) {
//		Studentlogic studentlogic= new Studentlogic();
//		studentlogic.Alldisplay();
//	}
}
