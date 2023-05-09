package news.portal.bitlab.kz.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import news.portal.bitlab.kz.db.DBConnection;
import news.portal.bitlab.kz.db.User;

import java.io.IOException;

@WebServlet(value = "/personal-info")
public class PersonalInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = LoginServlet.getUser();
        request.setAttribute("user",user);
        request.getRequestDispatcher("personal/personal_info.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("user_id"));
        String fullName = request.getParameter("full_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = DBConnection.getUserById(id);
        if(user!=null){
            user.setFullName(fullName);
            user.setEmail(email);
            user.setPassword(password);
            user.setRole_id(1);
            DBConnection.updateUserInfo(user);
            response.sendRedirect("/news");
        }else{
            String errorMessage = "Sorry, user not found";
            request.setAttribute("message",errorMessage);
            request.getRequestDispatcher("authPages/login.jsp").forward(request,response);
        }
    }
}
