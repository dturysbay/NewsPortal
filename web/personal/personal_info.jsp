<%--
  Created by IntelliJ IDEA.
  User: dinmukhambetturysbay
  Date: 10.05.2023
  Time: 03:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personal Info</title>
    <%@include file="../config.jsp"%>
</head>
<body>
<%@include file="../navbar.jsp"%>
<%
    if (request.getAttribute("user") != null) {
        User user  = (User) request.getAttribute("user");
%>
<form action="/personal-info" method="post">
    <div class="container">
        <input type="hidden" name="user_id" value="<%=user.getId()%>">
        <div class="card-body">
            <div class="form-floating pb-2">
                <input type="text" class="form-control" id="full_name" placeholder="" name="full_name" value="<%=user.getFullName()%>">
                <label for="full_name">Full Name</label>
            </div>
            <div class="form-floating pb-2">
                <input type="text" class="form-control" id="email" placeholder="" name="email" value="<%=user.getEmail()%>">
                <label for="email">Email</label>
            </div>
            <div class="form-floating pb-2">
                <input type="text" class="form-control" id="password" placeholder="" name="password" value="<%=user.getPassword()%>">
                <label for="password">Password</label>
            </div>


            <div class="card-footer text-body-secondary">
                <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Change
                </button>
            </div>
    </div>
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        Are you sure you to change personal info?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

<%
    }
%>
</body>
</html>
