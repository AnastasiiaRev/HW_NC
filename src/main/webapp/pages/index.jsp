<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	</head>
	<body>
		<div class="panel panel-info">
			<div class="panel-body">
				<div>
					<a href="/HW_NC_war/formPost">Add new post</a>
				</div>
				<table class="table table-striped table-bordered">
					<tr>
						<th>Creator Name</th>
						<th>Post</th>
						<th>Action</th>
					</tr>

					<c:forEach var="tempPost" items="${posts}">
						<tr>
							<td>${tempPost.creatorName}</td>
							<td style="max-width: 35%" >
									<div class="text-truncate d-block" style="width: 20rem">
											${tempPost.text}
									</div>
									<div>
										<a href="/HW_NC_war/post/${tempPost.id}">View full post</a>
									</div>

							</td>
							<td>
								<a href="/HW_NC_war/post/delete/${tempPost.id}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
								<a href="/HW_NC_war/formUpdatePost/${tempPost.id}">Update</a>
							</td>
						</tr>

					</c:forEach>

				</table>
			</div>
		</div>
	</body>
</html>