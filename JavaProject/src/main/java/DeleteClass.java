
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

@WebServlet("/DeleteClass")
public class DeleteClass extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DBConnection.getConnection();
			Connection con = DBConnection.con;
		    int calssID = Integer.parseInt(request.getParameter("classIDdelete"));
		    String sql ="SELECT id_classe FROM Classe WHERE id_classe="+calssID+";";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                sql = "DELETE FROM Classe WHERE id_classe="+calssID+";";
                stm.executeUpdate(sql);
            }
            request.getRequestDispatcher("/Classes.jsp").forward(request, response);;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
