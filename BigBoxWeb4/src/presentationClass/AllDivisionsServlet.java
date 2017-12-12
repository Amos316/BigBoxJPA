package presentationClass;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import businessClass.division;
import databaseClass.DivisionDB;

/**
 * Servlet implementation class AllDivisionsServlet
 */
@WebServlet("/AllDivisionsServlet")
public class AllDivisionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/AllDivisions.jsp";
		List<division> division = DivisionDB.listAllDivision();
		request.setAttribute("division", division);

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}