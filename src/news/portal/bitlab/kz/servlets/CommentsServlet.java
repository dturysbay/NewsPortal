package news.portal.bitlab.kz.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import news.portal.bitlab.kz.db.Comment;
import news.portal.bitlab.kz.db.DBConnection;

import java.io.IOException;

@WebServlet(value = "/add-comment")
public class CommentsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comment = request.getParameter("comment");
        Long user_id = Long.parseLong(request.getParameter("user_id"));
        Long news_id = Long.parseLong(request.getParameter("news_id"));

        Comment commentObj = new Comment();
        commentObj.setComment(comment);
        commentObj.setUser_id(user_id);
        commentObj.setNews_id(news_id);

        DBConnection.addComment(commentObj);
        response.sendRedirect("/news");
    }
}
