<%--
  Created by IntelliJ IDEA.
  User: dinmukhambetturysbay
  Date: 30.04.2023
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <%@include file="config.jsp"%>
</head>
<body>
    <div class="container mx-auto mt-5" >
        <h1>Welcome to news portal</h1>
        <h2>In order to continue please Sign In or Sign Up</h2>
    </div>
    <div class="container">
        <div class="row">
            <form action="/login" method="get">
                <button class="btn btn-info text-light" type="submit">Login</button>
            </form>
            <form action="/register" method="get">
                <button class="btn btn-success" type="submit">Register</button>
            </form>
        </div>
    </div>
</body>
</html>
