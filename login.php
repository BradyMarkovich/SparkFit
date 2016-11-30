<?php
	$connection = mysqli_connect('localhost', 'root', 'buddy13!2', "sparkfit");
	if (!$connection){
		die("Database Connection Failed" . mysqli_error($connection));
	}
	$select_db = mysqli_select_db($connection, 'logins');
	if (!$select_db){
		die("Database Selection Failed" . mysqli_error($connection));
	}
	
	$email = $_POST["email"];
	$password = $_POST["password"];
	
	$statement = mysqli_prepare($connection, "SELECT * FROM logins WHERE username = ? AND password = ?");
	mysqli_stmt_bind_param($statement, "ss", $email, $password);
	mysqli_stmt_execute($statement);
	
	mysqli_stmt_store_result($statement);

		

?>