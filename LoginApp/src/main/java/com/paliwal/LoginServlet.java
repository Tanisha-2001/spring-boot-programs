package com.paliwal;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get user inputs
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Set content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Hardcoded credentials (for demonstration purposes)
        String validUsername = "admin";
        String validPassword = "1234";

        // Check credentials
        if (username != null && password != null && username.equals(validUsername) && password.equals(validPassword)) {
            out.println("<html><body>");
            out.println("<h1>Welcome, " + username + "!</h1>");
            out.println("<p>Login Successful.</p>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h1>Login Failed!</h1>");
            out.println("<p>Invalid username or password.</p>");
            out.println("<a href='index.html'>Try Again</a>");
            out.println("</body></html>");
        }

        out.close();
    }
}
