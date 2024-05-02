
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

@WebServlet("/ModifyClass")
public class ModifyClass extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DBConnection.getConnection();
			Connection con = DBConnection.con;
			int ClassID = Integer.parseInt( request.getParameter("classIDModify"));
		    String year = request.getParameter("modifyYear");
		    String major = request.getParameter("modifyMajor");
		    String grade = request.getParameter("modifyGrade");
		    String sql=null;
		    Statement stm = con.createStatement();
		    if(request.getParameter("studentsNumber").isBlank()==false) {
		    	int studentNumber = Integer.parseInt(request.getParameter("studentsNumber"));
		    	sql = "UPDATE Classe SET nombre_etudiant = "+studentNumber+" WHERE id_classe = "+ClassID+";";
		    	stm.executeUpdate(sql);
		    }
		    if(year.isBlank()==false) {
		    	sql = "UPDATE Classe SET anneScolaire = '"+year+"' WHERE id_classe = "+ClassID+";";
		    	stm.executeUpdate(sql);
		    }
		    if(major.isBlank()==false) {
		    	sql = "UPDATE Classe SET filier = '"+major+"' WHERE id_classe = "+ClassID+";";
		    	stm.executeUpdate(sql);
		    }
		    if(grade.isBlank()==false) {
		    		sql = "UPDATE Classe SET niveux = '"+grade+"' WHERE id_classe = "+ClassID+";";
		    		stm.executeUpdate(sql);
		    }
            request.getRequestDispatcher("/Classes.jsp").forward(request, response);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
