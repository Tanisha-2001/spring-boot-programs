package com.paliwal;

import java.io.*;
import java.util.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {

    private static List<Product> productList = new ArrayList<>();

    // Get all products
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "view";
        }

        // View products
        if (action.equals("view")) {
            request.setAttribute("products", productList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
            dispatcher.forward(request, response);
        }
    }

    // Add and Update products
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        // Add product
        if (action.equals("add")) {
            String name = request.getParameter("name");
            String price = request.getParameter("price");

            Product product = new Product(name, Integer.parseInt(price));
            productList.add(product);

            response.sendRedirect("ProductServlet?action=view");
        }

        // Update product
        if (action.equals("update")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String price = request.getParameter("price");

            Product product = productList.get(Integer.parseInt(id));
            product.setName(name);
            product.setPrice(Integer.parseInt(price));

            response.sendRedirect("ProductServlet?action=view");
        }
    }
}
