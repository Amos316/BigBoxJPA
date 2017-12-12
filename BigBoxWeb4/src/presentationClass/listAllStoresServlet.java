package presentationClass;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import businessClass.store;
import databaseClass.StoreDB;

/**
 * Servlet implementation class listAllStoresServlet
 */
@WebServlet(urlPatterns = { "/listAllStoresServlet" }, initParams = {
		@WebInitParam(name = "relativePathToFile", value = "/WEB-INF/listAllStores.jsp") })
public class listAllStoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/listAllStores.jsp";

		List<store> stores = StoreDB.listAllStores();
		request.setAttribute("stores", stores);

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}