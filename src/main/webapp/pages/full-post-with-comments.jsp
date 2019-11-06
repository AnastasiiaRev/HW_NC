<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="justify-content-center">
                <div>
                    <a href="/HW_NC_war/"> &lt; Go back</a>
                </div>
                <div>
                    <h1>Post</h1>
                    <p>
                        ${post.text}
                    </p>
                </div>
            </div>
            <div>
                <footer class="blockquote-footer">Created by: ${post.creatorName}</footer>
                <footer class="blockquote-footer">Date of creation: ${post.dateOfCreation}</footer>
            </div>
            <div>
                <a href="/HW_NC_war/formComment/${post.id}">+ Add comment</a>
            </div>
            <div class="panel panel-info">
                <div class="panel-body">
                    <table class="table table-striped table-bordered">
                        <tr>
                            <th>Creator Name</th>
                            <th>Comment</th>
                            <th>Time</th>
                            <th>Action</th>
                        </tr>

                        <c:forEach var="tempComment" items="${comments}">
                            <tr>
                                <td>${tempComment.creatorName}</td>
                                <td style="max-width: 35%" >${tempComment.text}</td>
                                <td>${tempComment.dateOfCreation}</td>
                                <td>
                                    <a href="/HW_NC_war/formUpdateComment/${post.id}/${tempComment.id}">Update</a>
                                    <a href="/HW_NC_war/comment/delete/${tempComment.id}" onclick="if (!(confirm('Are you sure you want to delete this comment?'))) return false">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
