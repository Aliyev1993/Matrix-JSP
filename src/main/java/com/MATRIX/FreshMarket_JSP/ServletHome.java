package com.MATRIX.FreshMarket_JSP;

import dao.Repository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletHome", value = "/ServletHome")
public class ServletHome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        int age=Integer.parseInt(request.getParameter("age"));
        String email=request.getParameter("email");
        String comment=request.getParameter("comment");

        System.out.println(firstName+lastName+age+email+comment);



        Repository repository=new Repository();
        try {
            repository.connection("jdbc:mysql://localhost:3306/freshmarketform","root","opel999999");
            repository.insert(firstName,lastName,age,email,comment);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }finally {
            try {
                repository.closeConnection();

            } catch (SQLException throwables) {
                throwables.printStackTrace();

            }
        }
    }
}
