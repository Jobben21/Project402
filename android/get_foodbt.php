<?php

header("user-type:text/javascript;charset=utf-8");
	define('HOST', 'localhost');
	define('USER', 'root');
	define('PASS', 'cs402');
	define('DB', 'cs402');
	
	
		$con = mysqli_connect(HOST, USER, PASS, DB) or die('Unable to Connect');

		mysqli_set_charset($con, "utf8");
		
		$strsugar= $_POST["resugar"];
		$strsodium = $_POST["resodium"];
		$strpotass = $_POST["repotassium"];
		$strcholes = $_POST["recholes"];
		$strldl = $_POST["reldl"];
		$strhdl = $_POST["rehdl"];
		$strtrigly = $_POST["retrigly"];
		
		if($strsodium==1){
		$sql = "SELECT * FROM foodmenu WHERE (food_disease='โรคไต')";
		};
		else{
			$sql = "SELECT * FROM foodmenu";
			
		}
		$r = mysqli_query($con,$sql);

		$result = array();
		
		while ($row = mysqli_fetch_array($r))
		{
			
			array_push($result,array(
			
			'name'=>$row['food_name'],
			'foodpic'=>$row['foodpic'],
			'ingred'=>$row['food_ ingred'],
			'method'=>$row['food_solution'],
			'typeingred'=>$row['type_ingred'],
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