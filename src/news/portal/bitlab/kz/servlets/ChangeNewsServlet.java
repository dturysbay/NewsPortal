package news.portal.bitlab.kz.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import news.portal.bitlab.kz.db.DBConnection;
import news.portal.bitlab.kz.db.News;
import news.portal.bitlab.kz.db.User;

import java.io.IOException;

@WebServlet(value = "/change")
public class ChangeNewsServlet extends HttpServlet {
    User user = LoginServlet.getUser();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(-1);
        try {
            id = Long.parseLong(request.getParameter("news_id"));
        }catch (Exception e){}

        News newsById = DBConnection.getNewsById(id);
        request.setAttribute("newsById",newsById);
        request.setAttribute("user",user);
        request.getRequestDispatcher("news/details.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Long id = Long.parseLong(request.getParameter("news_id"));
       String title = request.getParameter("title");
       String content = request.getParameter("content");

       News newsById = DBConnection.getNewsById(id);
       if(newsById != null){
           newsById.setTitle(title);
           newsById.setContent(content);
           DBConnection.updateNews(newsById);
           response.sendRedirect("/news");
       }else{
           response.sendRedirect("/change?news_id="+id);
       }
    }
}
