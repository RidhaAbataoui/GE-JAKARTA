
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.educationalsystem.bean.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DBConnection.getConnection();
			Connection con = DBConnection.con;
		    int studentID = Integer.parseInt(request.getParameter("studentIDdelete"));
		    String sql ="SELECT id_etd FROM Etudiant WHERE id_etd="+studentID+";";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                sql = "DELETE FROM Etudiant WHERE id_etd="+studentID+";";
                stm.executeUpdate(sql);
            }
            request.getRequestDispatcher("/Students.jsp").forward(request, response);;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
