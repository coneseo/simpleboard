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
    <h2>rewrite</h2>

    <form action="/rewrite" method = "post">
        <%--hidden! id를 숨기는 것--%>
        <input type="hidden" class="form-control" id="id" name="id" value="${board.id}">

        <div class="form-group">
            <label for="comment">Title:</label>
            <input type="comment" class="form-control" id="title" name="title" value="${board.title}">
        </div>
        <div class="form-group">
            <label for="comment">Comment:</label>
            <textarea class="form-control" rows="5" id="comment" name="content">${board.content}</textarea>
        </div>
        <div class="form-group">
            <label for="comment">nickname:</label>
            <label>${sessionScope.user.nickname}</label>
        </div>

        <button type="submit" class="btn btn-success">rewrite</button>
    </form>
</div>
</body>
</html>
