<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>boardlist</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/board.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="header.jsp"%>


<div class="container">
    <div class="table-responsive">
        <c:if test="${sessionScope.user != null}">
            <a href="/write"><button type="button" class="btn btn-success writebtn" >write</button></a>
        </c:if>
        <c:if test="${sessionScope.user == null}">
            <button type="button" class="btn btn-success writebtn" id ="writebtn" data-toggle="modal" data-target="#login">write</button>
        </c:if>

        <table class="table table-hover">
            <thead>
            <tr class="success">
                <th>number</th>
                <th>title</th>
                <th>nickname</th>
                <th>regdate</th>
                <th>readcount</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.boards}" var="board">
                    <tr>
                        <td>${board.id}</td>
                        <td>
                            <c:forEach begin="1" end="${board.depth}">&nbsp;</c:forEach>
                            <a href="/content?id=${board.id}">${board.title}</a></td>
                        <td>${board.nickname}</td>
                        <td>${board.regdate}</td>
                        <td>${board.readcount}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <ul class="pagination">
        <li><a href="/board?page=1">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
    </ul>
</div>
</body>
</html>
