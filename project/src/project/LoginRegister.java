package project;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginRegister() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO studentd = new StudentDAO();
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		String submitType=request.getParameter("submit");
		Student student=new Student();
		student=studentd.getStudent(userName, password);
		if(submitType.equals("login")&&student!=null&&student.getName()!=null) {
			request.setAttribute("message",student.getName() );
			request.getRequestDispatcher("welcome.jsp").forward(request,response);
		}
		else if(submitType.equals("registration")) {
			student=new Student();
			student.setName(request.getParameter("name"));
			student.setPassword(password);
			student.setUsername(userName);
			studentd.insertStudent(student);
			request.setAttribute("successMessage","Registration done, please login to countinue");
			request.getRequestDispatcher("login.jsp").forward(request, response);
				}
        else {
		request.setAttribute("message","Data not found!!,click on Register");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	}
}

