
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

@WebServlet("/ModifyStudent")
public class ModifyStudent extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DBConnection.getConnection();
			Connection con = DBConnection.con;
			int StudentID = Integer.parseInt( request.getParameter("studentIDmodify"));
		    String firstName = request.getParameter("firstnameModify");
		    String lastName = request.getParameter("lastnameModify");
		    String birthdate = request.getParameter("birthdateModify");
		    String ifleader = request.getParameter("ifleaderModify");
		    String sql=null;
		    Statement stm = con.createStatement();
		    if(firstName.isBlank()==false) {
		    	sql = "UPDATE Etudiant SET nom = '"+firstName+"' WHERE id_etd = "+StudentID+";";
		    	stm.executeUpdate(sql);
		    }
		    if(lastName.isBlank()==false) {
		    	sql = "UPDATE Etudiant SET prenom = '"+lastName+"' WHERE id_etd = "+StudentID+";";
		    	stm.executeUpdate(sql);
		    }
		    if(birthdate.isBlank()==false) {
		    	sql = "UPDATE Etudiant SET date_naissance = '"+birthdate+"' WHERE id_etd = "+StudentID+";";
		    	stm.executeUpdate(sql);
		    }
		    if(ifleader.isBlank()==false) {
		    	if(ifleader.equals("true")) {
		    		sql = "UPDATE Etudiant SET si_respo = 1 WHERE id_etd = "+StudentID+";";
		    		stm.executeUpdate(sql);
		    	}
		    	else {
		    		sql = "UPDATE Etudiant SET si_respo = 0 WHERE id_etd = "+StudentID+";";
		    		stm.executeUpdate(sql);
		    	}
		    }
		    if(request.getParameter("classIDModify").isBlank()==false) {
			    int ClassID = Integer.parseInt( request.getParameter("classIDModify"));
		    	sql = "UPDATE Etudiant SET id_classe = '"+ClassID+"' WHERE id_etd = "+StudentID+";";
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
