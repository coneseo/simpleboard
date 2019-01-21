<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>content</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/content.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="header.jsp"%>

<div class="container">
    <h2>Content</h2>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3>${board.title}</h3>
            <div class="heading-child">
                <p>${board.nickname}</p>
                <p>${board.regdate}</p>
            </div>
        </div>
        <div class="panel-body">${board.content}</div>
    </div>

    <a href="/modify?id=${board.id}"><button type="button" class="btn btn-success">Modify</button></a>
    <a href="/rewrite?id=${board.id}"><button type="button" class="btn btn-success">rewrite</button></a>
    <a href="/delete?id=${board.id}"><button type="button" class="btn btn-success">delete</button></a>
    <a href="/board"><button type="button" class="btn btn-success">lists</button></a>


</div>
</body>
</html>
