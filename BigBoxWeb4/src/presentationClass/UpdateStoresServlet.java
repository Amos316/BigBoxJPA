package presentationClass;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessClass.store;
import databaseClass.StoreDB;

/**
 * Servlet implementation class UpdateStoresServlet
 */
@WebServlet("/UpdateStoresServlet")
public class UpdateStoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/AddStore.jsp";

		String storeNumber = request.getParameter("StoreNumber");
		store Store = new store();
		Store.setStoreNumber(storeNumber);
		request.setAttribute("store", Store);
		int divisionID = Integer.parseInt(request.getParameter("divisionID"));
		double sales = Double.parseDouble(request.getParameter("sales"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		Store.setDivisionID(divisionID);
		Store.setName(name);
		Store.setAddress(address);
		Store.setCity(city);
		Store.setState(state);
		Store.setZip(zip);
		Store.setSales(sales);
		StoreDB.addStore(Store);

		url = "/listAllStoresServlet";
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
