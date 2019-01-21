<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>boardlist</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/board.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="header.jsp"%>

<div class="container">
    <h2>write</h2>
    <form action="/write" method="post">
        <div class="form-group">
            <label for="comment">Title:</label>
            <input type="comment" class="form-control" id="title" placeholder="Enter title" name="title">
        </div>
        <div class="form-group">
            <label for="comment">Comment:</label>
            <textarea class="form-control" rows="7" id="comment" name="content"></textarea>
        </div>
        <div class="form-group">
            <label for="comment">nickname:</label>
            <input type="comment" class="form-control" id="userId" placeholder="Enter writer" name="nickname">
        </div>
        <input type="hidden" name="userId" value="${sessionScope.user.id}">
        <%--<div class="form-group">--%>
            <%--<label for="pwd">Password:</label>--%>
            <%--<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">--%>
        <%--</div>--%>

        <button type="submit" class="btn btn-success">Submit</button>
    </form>
</div>



</body>
</html>
