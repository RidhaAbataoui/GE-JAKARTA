
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

@WebServlet("/ADDClass")
public class ADDClass extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DBConnection.getConnection();
			Connection con = DBConnection.con;
			String StudentsNumber = request.getParameter("stdNumber");
			String year = request.getParameter("year");
			String major = request.getParameter("major");
			String grade = request.getParameter("grade");
			String sql ="INSERT INTO Classe(nombre_etudiant,anneScolaire,filier,niveux) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, StudentsNumber);
            ps.setString(2, year);
            ps.setString(3, major);
            ps.setString(4, grade);
            ps.executeUpdate();
            request.getRequestDispatcher("/Classes.jsp").forward(request, response);;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
