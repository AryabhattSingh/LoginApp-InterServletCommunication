package interServletCommunication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	@Override
	public void init() {
		try {

			// Created an object of ServletContext to access context params set by web.xml
			ServletContext context = getServletContext();

			// Loading the MySQL Driver
			Class.forName(context.getInitParameter("SQLDriver"));

			// Creating a connection to the database.
			connection = DriverManager.getConnection(context.getInitParameter("dbUrl"),
					context.getInitParameter("dbUser"), context.getInitParameter("dbPassword"));

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Retrieving data submitted by the login form for processing
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {

			// Creating a Statement object in order to execute a sql query
			Statement statement = connection.createStatement();

			// Creating a ResultSet object to store records returned after statement object
			// executes sql query
			ResultSet resultSet = statement.executeQuery(
					"select firstName from user where email = '" + username + "' and password = '" + password + "'");

			// Creating a RequestDispatcher object to forward request to HomeServlet
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeServlet");

			if (resultSet.next()) { // next() checks if the resultSet has records and moves the cursor pointer to
									// the row

				// Retrieving firstName of user from the resultSet as returned by database;
				// In resultSet the indexing starts from 1'
				String firstName = resultSet.getString(1);

				// Setting the message and it's value. setAttribute() will store this in the
				// request.
				request.setAttribute("message", firstName + ", welcome to the world of Inter Servlet Communication");

				// The request is forwarded to another servlet
				requestDispatcher.forward(request, response);

			} else {

				// In case of login failure, below things will happen

				// Setting the requestDispatcher object to new value
				requestDispatcher = request.getRequestDispatcher("login.html");

				// Includes the content of login.html in the response
				requestDispatcher.include(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void destroy() {
		try {
			// closing the database connection of this servlet
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
