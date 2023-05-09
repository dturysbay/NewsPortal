<%--
  Created by IntelliJ IDEA.
  User: dinmukhambetturysbay
  Date: 10.05.2023
  Time: 03:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add News</title>
    <%@include file="../config.jsp"%>
</head>
<body>
<%@include file="../navbar.jsp"%>
<div class="card">
    <h5 class="card-header">Change</h5>
    <form action="/add-news" method="post">
        <input type="hidden" name="news_id" >
        <div class="card-body">
            <div class="form-floating pb-2">
                <input type="text" class="form-control" id="title" placeholder="" name="title">
                <label for="title">Title</label>
            </div>
            <div class="form-floating">
                    <textarea rows="10" style="height:100%;" class="form-control" name="content" placeholder="Leave a comment here" id="floatingTextarea">

                    </textarea>
                <label for="floatingTextarea">Comments</label>
            </div>
            <div class="card-footer text-body-secondary">
                <div class="row">
                    <div class="col-1">
                        <button type="submit" class="btn btn-outline-success">Add</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>

</body>
</html>
