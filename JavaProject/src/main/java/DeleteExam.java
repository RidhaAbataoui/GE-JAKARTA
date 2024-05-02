
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

@WebServlet("/DeleteExam")
public class DeleteExam extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DBConnection.getConnection();
			Connection con = DBConnection.con;
		    int StudentID = Integer.parseInt(request.getParameter("studentIDdelete"));
		    int TeacherID = Integer.parseInt(request.getParameter("teacherIDdelete"));
		    String sql ="SELECT * FROM Examinier WHERE id_etd="+StudentID+" AND id_prof = "+TeacherID+";";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                sql = "DELETE FROM Examinier WHERE id_etd="+StudentID+" AND id_prof="+TeacherID+";";
                stm.executeUpdate(sql);
            }
            request.getRequestDispatcher("/Exams.jsp").forward(request, response);;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
