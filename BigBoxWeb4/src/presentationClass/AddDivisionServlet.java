package presentationClass;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import businessClass.division;
import databaseClass.DivisionDB;

/**
 * Servlet implementation class AddDivisionServlet
 */
@WebServlet("/WelcomeServlet")
public class AddDivisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/AddDivisions.jsp";

		int iD = Integer.parseInt(request.getParameter("dID"));
		String divisionNumber = request.getParameter("dNum");
		String name = request.getParameter("dname");
		String address = request.getParameter("daddress");
		String city = request.getParameter("dcity");
		String state = request.getParameter("dstate");
		String zip = request.getParameter("dzip");

		division division = new division();
		division.setID(iD);
		division.setDivisionNumber(divisionNumber);
		division.setName(name);
		division.setAddress(address);
		division.setCity(city);
		division.setState(state);
		division.setZip(zip);
		DivisionDB.addDivision(division);
		request.setAttribute("Division", division);
		url = "/AllDivisionsServlet";

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
}