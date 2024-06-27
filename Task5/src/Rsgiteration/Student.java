package Rsgiteration;

public class Student {
    private String studentID;
    private String name;
	public Student(String studentID, String name) {
		super();
		this.studentID = studentID;
		this.name = name;
	}
	public final String getStudentID() {
		return studentID;
	}
	public final void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", name=" + name + "]";
	}

   
 
}

