<?php
	header("user-type:text/javascript;charset=utf-8");
	define('HOST', 'localhost');
	define('USER', 'root');
	define('PASS', 'cs402');
	define('DB', 'cs402');
	
	if($_SERVER['REQUEST_METHOD'] == 'GET'){
		$status = $_GET['status'];

		$con = mysqli_connect(HOST, USER, PASS, DB) or die('Unable to Connect');

		mysqli_set_charset($con, "utf8");

		$sql = "SELECT * FROM blood_test";

		

		$r = mysqli_query($con,$sql);

		$result = array();

		while($row = mysqli_fetch_array($r)){
			array_push($result,array(
			
			'sugar'=>$row['sugar'],
			'choles'=>$row['choles'],
			'hdl'=>$row['hdl'],
			'ldl'=>$row['ldl'],
			'potassium'=>$row['potassium'],
			'trigly'=>$row['trigly'],
			'sodium'=>$row['sodium']
    ));
}

echo json_encode(array('result'=>$result));
			
			
			
			
		
		
		
		
		
		
		
		mysqli_close($con);
		}
?>