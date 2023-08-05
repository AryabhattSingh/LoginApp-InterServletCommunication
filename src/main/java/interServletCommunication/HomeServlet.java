package interServletCommunication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/homeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.print("<html>" + "<head>" + "<title>Login Successful</title>" + "</head>"
				+ "<body style='overflow-y: hidden'>"
				+ "<h2 style='border: 2px solid green; height: 97vh; display: flex; flex-direction: column; "
				+ "justify-content: center; align-items: center;}'>" + request.getAttribute("message") + "</h2>"
				+ "</body>" + "</html");

		System.out.println("doPost() used");

	}

}
