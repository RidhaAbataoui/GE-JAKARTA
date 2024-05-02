
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.educationalsystem.bean.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ADDTeacher")
public class ADDTeacher extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DBConnection.getConnection();
			Connection con = DBConnection.con;
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String birthdate = request.getParameter("birthdate");
			String email = request.getParameter("email");
			String cin = request.getParameter("cin");
			String subject = request.getParameter("subject");
			String sql ="INSERT INTO Professeur(Nom,Prenom,Date_Naissance,Email,CIN,Sujet) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, birthdate);
            ps.setString(4, email);
            ps.setString(5, cin);
            ps.setString(6, subject);
            ps.executeUpdate();
            request.getRequestDispatcher("/Teachers.jsp").forward(request, response);;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
