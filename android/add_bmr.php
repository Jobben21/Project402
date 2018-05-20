<?php
	header("user-type:text/javascript;charset=utf-8");
	define('HOST', 'localhost');
	define('USER', 'root');
	define('PASS', 'cs402');
	define('DB', 'cs402');
	


		$con = mysqli_connect(HOST, USER, PASS, DB) or die('Unable to Connect');

		
		mysqli_set_charset($con, "utf8");
		mysqli_query($con,"SET NAMES UTF8");
		
		
		
		
		
		//$strSql="SELECT * FROM user WHERE name ='".$strUsername."'";
		//$Query = mysqli_query($con,$strSql);
		//$Result = mysqli_fetch_array($Query);
		//if($Result){
			
			//$arr['StatusID'] = "0";
			//$arr['Error']="Username Exists ! ";
			//echo json_encode($arr);
			//exit();
			
		//}
		
				$strSql = "UPDATE user SET bmi='0' WHERE user_id=1";
		//$strSql= "INSERT INTO user ";
		
		
		//$strSql.="(bmi,bmr)";
		//$strSql.="VALUES";
		//$strSql .="('".$_POST["bmi"]."','".$_POST["bmr"]."')";	
		
		
		//$add="-1";
			
				
			
			
		$Query = mysqli_query($con,$strSql);
		if(!$Query){
			$arr['StatusID']="0";
			$arr['Error']="Cannot Save data!";
		}
		else{
			$arr['StatusID']="1";
			$arr['Error']="";
		}
		
		mysqli_close($con);
		echo json_encode($arr);
	
?>