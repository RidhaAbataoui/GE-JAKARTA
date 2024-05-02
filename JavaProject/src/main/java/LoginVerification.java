
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

@WebServlet("/LogingVerification")
public class LoginVerification extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DBConnection.getConnection();
			Connection con = DBConnection.con;
		    String UserName = request.getParameter("username");
		    String Password = request.getParameter("password");
		    String sql = "SELECT UserName,Password FROM UserTable;";
		    Statement stm = con.createStatement();
		    ResultSet rs = stm.executeQuery(sql);
		    int exist =1;
		    while(rs.next()) {
		    	if(rs.getString(1).equals(UserName) && rs.getString(2).equals(Password)) {
		    		exist=0;
		    	}
		    }
		    if(exist==0) {
		    	request.getRequestDispatcher("/HomePage.jsp").forward(request, response);
		    }
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
