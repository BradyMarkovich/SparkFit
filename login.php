<?php
	$connection = mysqli_connect('localhost', 'root', 'buddy13!2', "sparkfit");
	if (!$connection){
		die("Database Connection Failed" . mysqli_error($connection));
	}
	$select_db = mysqli_select_db($connection, 'sparkfit');
	if (!$select_db){
		die("Database Selection Failed" . mysqli_error($connection));
	}
	
	$email = $_POST["email"];
	$password = $_POST["password"];
	
	$statement = mysqli_prepare($connection, "SELECT * FROM logins WHERE username = ?");
	mysqli_stmt_bind_param($statement, "s", $email);
	mysqli_stmt_execute($statement);
	
	mysqli_stmt_store_result($statement);

  mysqli_stmt_bind_result($statement, $email);
    
    $response = array();
    $response["success"] = true;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["username"] = $username;
        $response["password"] = $password;
    }
    
    echo json_encode($response);
		
?>