<%--
  Created by IntelliJ IDEA.
  User: dinmukhambetturysbay
  Date: 09.05.2023
  Time: 03:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <%@include file="../config.jsp"%>
</head>
<body>
<div class="container">
    <div class="mx-auto mt-3">
        <h1 class="text-center text-primary">Welcome to News Portal</h1>
        <form action="/register" method="post">
            <div class="card mb-3 mx-auto w-50" >
                <div class="card-header bg-primary text-light">Register page</div>
                <div class="card-body ">
                    <div class="form-floating pb-2">
                        <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="email">
                        <label for="floatingInput">Email address</label>
                    </div>
                    <div class="form-floating pb-2">
                        <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">
                        <label for="floatingPassword">Password</label>
                    </div>
                    <div class="form-floating pb-2">
                        <input type="text" class="form-control" id="fullName" placeholder="Full Name" name="fullName">
                        <label for="fullName">Full Name</label>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">Select role</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect01" name="role_id">
                            <option value="2" selected>User</option>
                            <option value="1">Author</option>
                        </select>
                    </div>
                    <button type="submit" class="mt-3 btn btn-primary">Login</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
