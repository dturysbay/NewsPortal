package news.portal.bitlab.kz.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import news.portal.bitlab.kz.db.DBConnection;
import news.portal.bitlab.kz.db.User;

import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("authPages/login.jsp").forward(request,response);
    }
    static User user = null;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        user = DBConnection.getUser(email,password);
        if(user!=null){
            request.setAttribute("user",user);
//            request.getRequestDispatcher("news/news.jsp").forward(request,response);
            response.sendRedirect("/news");
        }else{
            String errorMessage = "Sorry, user not found";
            request.setAttribute("message",errorMessage);
            request.getRequestDispatcher("authPages/login.jsp").forward(request,response);
        }
    }

    public static User getUser(){
        return user;
    }


}
