package news.portal.bitlab.kz.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import news.portal.bitlab.kz.db.Comment;
import news.portal.bitlab.kz.db.DBConnection;
import news.portal.bitlab.kz.db.News;
import news.portal.bitlab.kz.db.User;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/news")
public class NewsServlet extends HttpServlet {
    User user = LoginServlet.getUser();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<News> news = DBConnection.getNews();
        ArrayList<User> userArrayList = DBConnection.getUsers();
        ArrayList<Comment> commentArrayList = DBConnection.getComments();

        request.setAttribute("news",news);
        request.setAttribute("user",user);
        request.setAttribute("userArrayList",userArrayList);
        request.setAttribute("commentArrayList",commentArrayList);
        request.getRequestDispatcher("news/news.jsp").forward(request,response);
    }
}
