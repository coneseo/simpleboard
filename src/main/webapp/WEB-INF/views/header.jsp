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
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/index">TestPage</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/index">Home</a></li>
            <li><a href="/board">board</a></li>


            <c:if test="${sessionScope.user.nickname == null}">
                <li ><a class="btn" data-toggle="modal" data-target="#join">join</a></li>
                <li ><a class="btn" data-toggle="modal" data-target="#login">login</a></li>
            </c:if>

            <c:if test="${sessionScope.user.nickname != null}">
                <li ><a href="/logout" class="btn">logout</a></li>
            </c:if>
        </ul>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="login" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Enter password</h4>
                </div>
                <div class="modal-body">
                    <form action="/login" method="post">
                        <div class="form-group">
                            <input type="comment" class="form-control" id="UserEmail" placeholder="Enter email" name="email">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="passwd" placeholder="Enter passwd" name="passwd">
                        </div>
                        <button type="submit">login</button>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <%--join modal--%>
    <div class="modal fade" id="join" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Enter password</h4>
                </div>
                <div class="modal-body">
                    <form action="/join" method="post">
                        <div class="form-group">
                            <input type="comment" class="form-control" id="name" placeholder="Enter name" name="name">
                        </div>
                        <div class="form-group">
                            <input type="comment" class="form-control" id="nickname" placeholder="Enter nickname" name="nickname">
                        </div>
                        <div class="form-group">
                            <input type="comment" class="form-control" id="email" placeholder="Enter email" name="email">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="passwd1" placeholder="Enter passwd1" name="passwd1">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="passwd2" placeholder="Enter passwd2" name="passwd2">
                        </div>
                        <button type="submit">join</button>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</nav>
</div>
</body>
</html>
