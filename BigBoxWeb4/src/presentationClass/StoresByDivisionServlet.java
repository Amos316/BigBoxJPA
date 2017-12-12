package presentationClass;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessClass.store;
import databaseClass.StoreDB;

/**
 * Servlet implementation class StoresByDivisionServlet
 */
@WebServlet("/StoresByDivisionServlet")
public class StoresByDivisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/StoresByDivision.jsp";
		int divisionID = Integer.parseInt(request.getParameter("Division"));
		List<store> store = StoreDB.listAllStores(divisionID);
		request.setAttribute("store", store);
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}