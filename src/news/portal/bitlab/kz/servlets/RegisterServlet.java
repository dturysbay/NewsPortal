package news.portal.bitlab.kz.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import news.portal.bitlab.kz.db.DBConnection;
import news.portal.bitlab.kz.db.User;

import java.io.IOException;



@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("authPages/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String role_id = request.getParameter("role_id");
        if (email == null || email.isEmpty() || password == null || password.isEmpty() || fullName == null || fullName.isEmpty()) {
            request.setAttribute("errorMessage", "Please fill out all form fields.");
            request.getRequestDispatcher("authPages/register.jsp").forward(request, response);
            return;
        }else{
            User user = new User(email.toLowerCase(),password,fullName,Integer.parseInt(role_id));
            DBConnection.createUser(user);
            request.setAttribute("successMessage", "Registered Successfully");
            request.getRequestDispatcher("/home.jsp").forward(request,response);
        }
    }
}
