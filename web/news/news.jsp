<%@ page import="news.portal.bitlab.kz.db.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="news.portal.bitlab.kz.db.News" %><%--
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
<nav class="navbar navbar-expand-lg navbar-light bg-light mb-5">
  <div class="container">
    <div class="navbar-brand">
      <img src="logo.png" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
      News
    </div>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <%
          if (request.getAttribute("user") != null) {
            User user = (User) request.getAttribute("user");
            if(user.getRole_id() == 1){
        %>
            <li class="nav-item">
              <a class="nav-link" href="#">Add news</a>
            </li>
        <%
            }
          }
        %>
      </ul>
    </div>
  </div>
</nav>

<%
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
                            <button type="button" class="btn btn-outline-info">Change</button>
                        </div>
                        <form class="col-2" action="/delete-news" method="post">
                            <div>
                                <input type="hidden" name="news_id" value="<%=news.getId()%>">
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </div>
                        </form>

                        <%
                                }
                                if(user.getRole_id() == 2){

                        %>
                            <div class="col-2">
                                <button type="button" class="btn btn-outline-info">Leave comment</button>
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
<%%>
<%%>
<%%>

</body>
</html>
