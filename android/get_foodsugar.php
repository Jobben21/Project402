<?php

header("user-type:text/javascript;charset=utf-8");
	define('HOST', 'localhost');
	define('USER', 'root');
	define('PASS', 'cs402');
	define('DB', 'cs402');
	
	
		$con = mysqli_connect(HOST, USER, PASS, DB) or die('Unable to Connect');

		mysqli_set_charset($con, "utf8");

		$sql = "SELECT * FROM foodmenu WHERE (food_disease='เบาหวาน')";
		
		$r = mysqli_query($con,$sql);

		$result = array();
		
		while ($row = mysqli_fetch_array($r))
		{
			
			array_push($result,array(
			
			'name'=>$row['food_name'],
			'foodpic'=>$row['foodpic'],
			'ingred'=>$row['food_ ingred'],
			'method'=>$row['food_method'],
			'typeingred'=>$row['Type_ingred'],
			'energy'=>$row['energy'],
			'carbohydrate'=>$row['carbohydrate'],
			'fat'=>$row['fat'],
			'protein'=>$row['protein'],
			'sugar'=>$row['sugar'],
			'sodium'=>$row['sodium']
			
			
    ));
			
		}
		
		mysqli_close($con);
		echo json_encode(array('result'=>$result));
		
		?>