package presentationClass;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import businessClass.User;
import databaseClass.UserDB;

@WebServlet("/UsersServlet")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String url = "/index.jsp";
		String message = "";
		// get current action
		String action = request.getParameter("action");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (action != null && action.equalsIgnoreCase("login")) {
			url = "/index.jsp";
			User user = UserDB.selectUser(userName);
			if (user != null) {
				url = "/Welcome.jsp";

			} else {

				if (userName == null || password == null || userName.isEmpty() || password.isEmpty() || user == null) {
					message = "Please try again";
					url = "/index.jsp";

				}

			}

			request.setAttribute("user", user);
			session.setAttribute("user", user);
			request.setAttribute("message", message);

		}

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}