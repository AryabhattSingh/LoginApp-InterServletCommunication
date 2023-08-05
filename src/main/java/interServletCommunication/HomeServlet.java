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

		// Getting a PrintWriter object in order to write back to the browser
		PrintWriter out = response.getWriter();

		// Setting the content type / MIME type, so that the browser understands the
		// things written to it
		response.setContentType("text/html");

		// Writing back to the browser
		out.print("<html>" + "<head>" + "<title>Login Successful</title>" + "</head>"
				+ "<body style='overflow-y: hidden'>"
				+ "<h2 style='border: 2px solid green; height: 97vh; display: flex; flex-direction: column; "
				+ "justify-content: center; align-items: center;}'>"
				// Getting the message which was set in LoginServlet
				+ request.getAttribute("message") + "</h2>" + "</body>" + "</html");

		System.out.println("doPost() used");

	}

}
