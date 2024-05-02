
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button_para = request.getParameter("button");
		RequestDispatcher rd = null;
		if(button_para.equals("Students")) {
			rd=request.getRequestDispatcher("/Students.jsp");
		}
		if(button_para.equals("Teachers")) {
			rd=request.getRequestDispatcher("/Teachers.jsp");
		}
		if(button_para.equals("Classes")) {
			rd=request.getRequestDispatcher("/Classes.jsp");
		}
		if(button_para.equals("Exams")) {
			rd=request.getRequestDispatcher("/Exams.jsp");
		}
		rd.forward(request, response);
	}
}
