<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <title>Post from</title>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
                <div class="justify-content-md-center">
                    <h1>${title} your post</h1>
                </div>
                <form:form action="/HW_NC_war/post" class="form" method="POST" modelAttribute="post">
                    <form:hidden path="id" />
                    <div class="form-group">
                        <label for="creatorName">Creator name</label>
                        <form:input path="creatorName" class="form-control" placeholder="Enter creator name"/>
                    </div>
                    <div class="form-group">
                        <label for="text">Post</label>
                        <form:textarea path="text" class="form-control" placeholder="Post's text" rows="8"/>
                    </div>
                    <div>
                        <form:button class="btn btn-primary">${title}</form:button>
                    </div>
                </form:form>
        </div>
    </body>
</html>
