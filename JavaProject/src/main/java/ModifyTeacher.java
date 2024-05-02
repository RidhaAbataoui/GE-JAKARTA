
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.educationalsystem.bean.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ModifyTeacher")
public class ModifyTeacher extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DBConnection.getConnection();
			Connection con = DBConnection.con;
			int TeacherID = Integer.parseInt( request.getParameter("TeacherIDmodify"));
		    String firstName = request.getParameter("firstnameModify");
		    String lastName = request.getParameter("lastnameModify");
		    String birthdate = request.getParameter("birthdateModify");
		    String email = request.getParameter("EmailModify");
		    String Subject = request.getParameter("subjectModify");
		    String sql=null;
		    Statement stm = con.createStatement();
		    if(firstName.isBlank()==false) {
		    	sql = "UPDATE Professeur SET nom = '"+firstName+"' WHERE id_prof = "+TeacherID+";";
		    	stm.executeUpdate(sql);
		    }
		    if(lastName.isBlank()==false) {
		    	sql = "UPDATE Professeur SET prenom = '"+lastName+"' WHERE id_prof = "+TeacherID+";";
		    	stm.executeUpdate(sql);
		    }
		    if(birthdate.isBlank()==false) {
		    	sql = "UPDATE Professeur SET date_naissance = '"+birthdate+"' WHERE id_prof = "+TeacherID+";";
		    	stm.executeUpdate(sql);
		    }
		    if(email.isBlank()==false) {
		    		sql = "UPDATE Professeur SET Email = '"+email+"' WHERE id_prof = "+TeacherID+";";
		    		stm.executeUpdate(sql);
		    }
		    if(Subject.isBlank()==false) {
		    	sql = "UPDATE Professeur SET Sujet = '"+Subject+"' WHERE id_prof = "+TeacherID+";";
		    	stm.executeUpdate(sql);
		    }
            request.getRequestDispatcher("/Teachers.jsp").forward(request, response);;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
