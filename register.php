<?php
	$connection = mysqli_connect('localhost', 'root', 'buddy13!2', "sparkfit");
	if (!$connection){
		die("Database Connection Failed" . mysqli_error($connection));
	}
	$select_db = mysqli_select_db($connection, 'logins');
	if (!$select_db){
		die("Database Selection Failed" . mysqli_error($connection));
	}
	
	$fname = $_POST ["fname"];
	$lname = $_POST ["lname"];
	$email = $_POST ["email"];
	$password = $_POST["password"];
	
	$command = mysqli_prepare($connection, "INSERT INTO logins (username, LastName, FirstName, password");
	mysqli_stmt_bind_param($command, "ssss", $email, $lname, $fname, $password);
	mysqli_stmt_execute($command);
	
	$response = array();
	$response["success"] = true;
	
	echo json_encode($response);
?>