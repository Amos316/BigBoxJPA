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
 * Servlet implementation class AddStoresServlet.This for the update store
 * function
 */
@WebServlet("/AddstoresServlet")
public class AddStoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/UpdateStore.jsp";
		String storeNumber = request.getParameter("StoreNumber");
		store Store = new store();
		Store.setStoreNumber(storeNumber);
		double SALES = Double.parseDouble(request.getParameter("sales"));
		String NAME = request.getParameter("name");
		String ADDRESS = request.getParameter("address");
		String CITY = request.getParameter("city");
		String STATE = request.getParameter("state");
		String ZIP = request.getParameter("zip");
		Store.setAddress(ADDRESS);
		Store.setCity(CITY);
		Store.setName(NAME);
		Store.setSales(SALES);
		Store.setState(STATE);
		Store.setZip(ZIP);
		request.setAttribute("store", Store);
		StoreDB.UpdatetStore(Store, storeNumber);

		url = "/listAllStoresServlet";

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
}
