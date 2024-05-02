
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

@WebServlet("/ADDStudent")
public class ADDStudent extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DBConnection.getConnection();
			Connection con = DBConnection.con;
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String birthdate = request.getParameter("birthdate");
			String cne = request.getParameter("cne");
			String ifleader = request.getParameter("ifleader");
			String classid = request.getParameter("classid");
			String sql ="INSERT INTO Etudiant(Nom,Prenom,Date_Naissance,id_classe,CNE,si_respo) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, birthdate);
            ps.setString(4, classid);
            ps.setString(5, cne);
            if(ifleader.equals("true")){
                ps.setInt(6, 1);
            }
            else{
                ps.setInt(6, 0);
            }
            ps.executeUpdate();
            request.getRequestDispatcher("/Students.jsp").forward(request, response);;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
