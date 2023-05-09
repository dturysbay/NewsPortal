<%@ page import="news.portal.bitlab.kz.db.User" %><%--
  Created by IntelliJ IDEA.
  User: dinmukhambetturysbay
  Date: 09.05.2023
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light mb-5">
  <div class="container">
    <div class="navbar-brand">
      <a class="nav-link" href="/news">News</a>
    </div>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <%
          if (request.getAttribute("user") != null) {
            User user  = (User) request.getAttribute("user");
            if(user.getRole_id() == 1){
        %>
        <li class="nav-item">
          <a class="nav-link" href="/add-news">Add news</a>
        </li>
        <%
            }
          }
        %>

        <li class="nav-item">
          <a class="nav-link" href="/personal-info">Personal Info</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
