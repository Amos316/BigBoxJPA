package presentationClass;

import java.io.IOException;
import java.text.NumberFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import databaseClass.StoreDB;

@WebServlet("/SalesServlet")
public class SalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/Sales.jsp";
		String message = " ";
		String sales1 = request.getParameter("id1");
		NumberFormat c = NumberFormat.getCurrencyInstance();

		if (sales1 != null && sales1.equals("DIV001")) {
			message = "";

			double amt = StoreDB.getSalesSummary(001);
			message = String.valueOf(c.format(amt));

		} else if (sales1 != null && sales1.equals("DIV111")) {
			message = "";

			double atm = StoreDB.getSalesSummary(002);
			message = String.valueOf(c.format(atm));

		} else if (sales1 != null && sales1.equals("TOTALSALES")) {
			message = "";

			double m = StoreDB.getSalesSummary();
			message = String.valueOf(c.format(m));

		} else {
			message = "choose an option below";

		}
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
