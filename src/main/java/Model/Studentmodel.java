package Model;

public class Studentmodel {
private int studentid ;
private String sname;
private String dob;
private long aadharno;
public int getStudentid() {
	return studentid;
}
public void setStudentid(int studentid) {
	this.studentid = studentid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public long getAadharno() {
	return aadharno;
}
public void setAadharno(long aadharno) {
	this.aadharno = aadharno;
}
public Studentmodel(int studentid, String sname, String dob, long aadharno) {
	
	this.studentid = studentid;
	this.sname = sname;
	this.dob = dob;
	this.aadharno = aadharno;
}
public Studentmodel() {
	
}

}
