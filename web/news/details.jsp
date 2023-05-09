<%@ page import="news.portal.bitlab.kz.db.News" %><%--
  Created by IntelliJ IDEA.
  User: dinmukhambetturysbay
  Date: 09.05.2023
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
  <%@include file="../config.jsp"%>
</head>
<body>

<%@include file="../navbar.jsp"%>
<%
    News news = (News) request.getAttribute("newsById");
    if(news != null){

%>
    <div class="card">
        <h5 class="card-header">Change</h5>
        <form action="/change" method="post">
            <input type="hidden" name="news_id" value="<%=news.getId()%>">
            <div class="card-body">
                  <div class="form-floating pb-2">
                    <input type="text" class="form-control" id="title" placeholder="" name="title" value="<%=news.getTitle()%>">
                    <label for="title">Title</label>
                  </div>
                <div class="form-floating">
                    <textarea rows="10" style="height:100%;" class="form-control" name="content" placeholder="Leave a comment here" id="floatingTextarea">
                        <%=news.getContent()%>
                    </textarea>
                    <label for="floatingTextarea">Content</label>
                </div>
                <div class="card-footer text-body-secondary">
                    <div class="row">
                        <div class="col-1">
                            <button type="submit" class="btn btn-outline-secondary">Change</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
<%
    }
%>
<%%>
<%%>

</body>
</html>
