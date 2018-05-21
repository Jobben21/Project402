<?php
	header("blood_test-type:text/javascript;charset=utf-8");
	define('HOST', 'localhost');
	define('USER', 'root');
	define('PASS', 'cs402');
	define('DB', 'cs402');
	


		$con = mysqli_connect(HOST, USER, PASS, DB) or die('Unable to Connect');

		
		mysqli_set_charset($con, "utf8");
		mysqli_query($con,"SET NAMES UTF8");
		
		
		
		
		
		
		
		$strSql= "INSERT INTO blood_test";
		$strSql.="(user_id,sugar,choles,hdl,ldl,potassium,trigly,sodium)";
		$strSql.="VALUES";
		$strSql .="('".$_POST["user_id"]."','".$_POST["sugar"]."','".$_POST["choles"]."','".$_POST["hdl"]."' ";
		$strSql .=",'".$_POST["ldl"]."','".$_POST["potassium"]."'";	
		$strSql .=",'".$_POST["trigly"]."','".$_POST["sodium"]."')";
			
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