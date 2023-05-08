<%--
  Created by IntelliJ IDEA.
  User: dinmukhambetturysbay
  Date: 09.05.2023
  Time: 03:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="../config.jsp"%>
</head>
<body>
    <div class="container">
        <div class="mx-auto mt-3">
            <h1 class="text-center text-success">Welcome to News Portal</h1>
            <form action="/login" method="post">
                <div class="card mb-3 mx-auto w-50" >
                    <div class="card-header bg-success text-light">Login page</div>
                    <div class="card-body">
                        <div class="form-floating pb-2">
                            <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="email">
                            <label for="floatingInput">Email address</label>
                        </div>
                        <div class="form-floating">
                            <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">
                            <label for="floatingPassword">Password</label>
                        </div>
                        <button type="submit" class="mt-3 btn btn-success">Login</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
