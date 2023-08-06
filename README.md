# Inter-Servlet Communication Login Usecase

This Java project demonstrates a simple yet popular usecase for inter-servlet communication. The project simulates a login functionality similar to what you would find in applications like Gmail, Facebook, or any other web app.

## Project Overview

The project comprises a login form named `login.html`, through which users can enter their email id and password.
It contains two main servlets: `LoginServlet.java` and `HomeServlet.java` as well.

### Usecase Flow

1. The user accesses the application and is presented with the `login.html` form.
2. Upon submitting the form, the data is sent to the `LoginServlet`.
3. The `LoginServlet` then queries the database to check if the provided email id and password are valid.
4. If the credentials are not valid, the `LoginServlet` includes the `login.html` again using request dispatching.
5. If the credentials are valid, the `LoginServlet` uses forward request dispatching to forward the request to the `HomeServlet`.
6. The `HomeServlet` displays a welcome message to the user.

   ![UseCaseFlow](https://github.com/AryabhattSingh/LoginApp-InterServletCommunication/assets/63608694/a2eb39ba-a7af-4cb2-bf51-5ad1b90cccf1)


## Setup and Usage

To run this project on your local machine, follow these steps:

1. Ensure you have Java Development Kit (JDK) installed on your system.
2. Clone or download the project from this GitHub repository.
3. Make sure you have MySQL installed.
4. Set MySql username as `root` and password as `root`. If you have something else then you need to update accordingly in `web.xml`.
5. A database named `mydb` with `user` table in it.
6. The `user` table will have 4 columns - `email`, `firstName`, `lastName` and `password` all of varchar datatype.
7. Open the project in your preferred Java development environment (e.g., Eclipse, IntelliJ IDEA, or Visual Studio Code).
8. Deploy the project on a servlet container like Apache Tomcat (open `login.html`, right click on anywhere, click on `Run as` -> `Run on Server`
9. Access the application in your web browser at the appropriate URL (e.g., `http://localhost:8080/login.html`).

Please note that you may need to adjust the servlet container's port number or context path depending on your configuration.

## Project Structure

```
|-- src
|   |-- main
|       |--java
|          |--interServletCommunication  
|             |-- LoginServlet.java
|             |-- HomeServlet.java
|       |--webapp
|          |--META-INF
|              |--MANIFEST.MF
|          |--WEB-INF
|              |--lib
|                  |--mysql-connector-j-8.1.0.jar
|              |--web.xml
|          |--login.css
|          |--login.html
```

- `src`: Contains the Java source files for the project.
  - `interServletCommunication`: Package containing the `LoginServlet` and `HomeServlet`.
- `webapp`: Contains the static content of the web application.
  - `WEB-INF`: Contains the web deployment descriptor file.
    -`lib`: Contains the MySQL jar file
    - `web.xml`: The deployment descriptor file that maps servlets and configures the application.
  - `login.html`: The HTML login form.

## Contributions

Contributions to this project are welcome! If you find any issues or want to add more features to improve the usecase, feel free to create pull requests or raise issues in this GitHub repository.

## License

This project is open-source and distributed under the [MIT License](LICENSE). Feel free to use, modify, and distribute it according to the terms of the license.

Happy coding!
