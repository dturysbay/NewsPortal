<%@ page import="news.portal.bitlab.kz.db.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="news.portal.bitlab.kz.db.News" %>
<%@ page import="news.portal.bitlab.kz.db.Comment" %><%--
  Created by IntelliJ IDEA.
  User: dinmukhambetturysbay
  Date: 09.05.2023
  Time: 04:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>News</title>
  <%@include file="../config.jsp"%>
</head>
<body>
<%--  header--%>
<%@include file="../navbar.jsp"%>

<%
    ArrayList<Comment> commentArrayList  = (ArrayList<Comment>) request.getAttribute("commentArrayList");
    ArrayList<User> userArrayList  = (ArrayList<User>) request.getAttribute("userArrayList");
    userArrayList.size();
    commentArrayList.size();
    ArrayList<News> newsArrayList = (ArrayList<News>) request.getAttribute("news");
    if(newsArrayList != null){
        for (News news :
                newsArrayList) {
%>
        <div class="container mb-3">
            <div class="card mx-auto" style="width: 50%">
                <div class="card-body">
                    <h5 class="card-title"><%=news.getTitle()%></h5>
                    <p class="card-text"><%=news.getContent()%></p>
                </div>
                <div class="card-footer text-muted align-content-center align-items-center justify-content-center">
                    <div class="row">
                        <div class="col-8">
                            <p><%=news.getPost_date()%></p>
                        </div>

                        <%
                            if (request.getAttribute("user") != null) {
                                User user = (User) request.getAttribute("user");
                                if(user.getRole_id() == 1){
                        %>

                        <div class="col-2">
                            <a class="btn btn-outline-info" href="/change?news_id=<%=news.getId()%>">Change</a>
                        </div>

                        <form class="col-2" action="/delete-news" method="post">
                            <div>
                                <input type="hidden" name="news_id" value="<%=news.getId()%>">
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </div>
                        </form>

                        <%
                            }
                        %>



<%--                        COMMENTS SECTION--%>
                        <%
                            if(commentArrayList != null){
                                for(Comment comment: commentArrayList){
                                    if(comment.getNews_id() == news.getId()){
                        %>
                            <div class="card-footer">
                                <blockquote class="blockquote mb-0">
                                        <p><%=comment.getComment()%></p>
                                        <footer class="blockquote-footer">
                                            <%
                                                for (User user1: userArrayList) {
                                                    if(user1.getId() == comment.getUser_id()){
                                            %>
                                                <%=user1.getFullName()%>
                                            <%
                                                    }
                                                }
                                            %>
                                        </footer>
                                </blockquote>
                            </div>

                        <%
                                    }
                                }
                            }

                        %>

                        <%

                                if(user.getRole_id() == 2){

                        %>
                            <div class="card-footer">
                                <form action="/add-comment" method="post">
                                    <input type="hidden" name="news_id" value="<%=news.getId()%>">
                                    <input type="hidden" name="user_id" value="<%=user.getId()%>">
                                    <div class="form-floating">
                                        <textarea rows="2" style="height:10%;" class="form-control" name="comment" placeholder="Leave a comment here" id="floatingTextarea">
                                        </textarea>
                                        <label for="floatingTextarea">Comments</label>
                                    </div>
                                    <div class="col-4 pt-2">
                                        <button type="submit" class="btn btn-outline-info">Leave comment</button>
                                    </div>
                                </form>

                            </div>
                        <%
                                }
                            }
                       %>
                    </div>
                </div>
            </div>
        </div>
<%
        }
    }
%>
</body>
</html>
