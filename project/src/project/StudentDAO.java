package project;
import project.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class StudentDAO {	
	static Connection con;
    static PreparedStatement ps;
	public int insertStudent(Student student)
	{
		 String username = student.getUsername();
		 String password = student.getPassword();
		 String name = student.getName();
		int status=0;
		try {
			con=connection.createConnection();
			ps=con.prepareStatement("Insert into student1 value(?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, name);
			status=ps.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
	public Student getStudent(String username, String password) {
		Student student= new Student();
	try {
		con=connection.createConnection();
		ps=con.prepareStatement("Select* from student1 where username=? and password=?");
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			student.setUsername(rs.getString(1));
			student.setPassword(rs.getString(2));
		    student.setName(rs.getString(3));
		}
	}
	catch(Exception e){
		System.out.println(e);
	}
	return student;
	}
}
