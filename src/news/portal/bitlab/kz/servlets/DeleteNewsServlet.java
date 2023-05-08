package news.portal.bitlab.kz.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import news.portal.bitlab.kz.db.DBConnection;

import java.io.IOException;

@WebServlet(value = "/delete-news")
public class DeleteNewsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("news_id"));
        DBConnection.deleteNews(id);
        response.sendRedirect("/news");
    }
}
