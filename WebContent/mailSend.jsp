<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Messagerie</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
	integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
	integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class-"col-md-6">
			<h1>Messagerie de boubou</h1>
			<form action="/mailServlet" method="post">
				Email : <input type="email" class="form-control" name="email"
					id="exampleFormControlInput1" placeholder="name@example.com">
				Subject : <input type="email" class="form-control" name="subject"
					id="exampleFormControlInput1" placeholder="name@example.com">
				Mail content :
				<textarea class="form-control" id="exampleFormControlTextarea1"
					name="mailContent" rows="3"></textarea>
					<br>
				<button type="submit" style-"width: 100%;" value="send it !" class="btn btn-info">Envoyer</button>
			</div>
		</div>
	</div>
	<!-- <input type="submit" value="send it !"> -->



	</form>
</body>
</html>