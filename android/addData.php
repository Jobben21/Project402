<?php
	header("user-type:text/javascript;charset=utf-8");
	define('HOST', 'localhost');
	define('USER', 'root');
	define('PASS', 'cs402');
	define('DB', 'cs402');
	


		$con = mysqli_connect(HOST, USER, PASS, DB) or die('Unable to Connect');

		
		mysqli_set_charset($con, "utf8");
		mysqli_query($con,"SET NAMES UTF8");
		
		$isExistUserSql = "SELECT 1 FROM user WHERE name = '" . $_POST["name"] . "'";
		$isExistUserResult = mysqli_query($con,$isExistUserSql);
		
		if(mysqli_fetch_array($isExistUserResult)) {
			$arr['StatusID'] = "2";
			$arr['Error'] = "Name already exist";
			
		}else{
			
			$strSql= "INSERT INTO user";
			$strSql.="(name,age,height,weight,gender)";
			$strSql.="VALUES";
			$strSql .="('".$_POST["name"]."','".$_POST["age"]."','".$_POST["height"]."' ";
			$strSql .=",'".$_POST["weight"]."','".$_POST["gender"]."')";	
				
				
			$Query = mysqli_query($con,$strSql);
			if(!$Query){
				$arr['StatusID']="0";
				$arr['Error']="Cannot Save data!";
			}
			else{
				$arr['StatusID']="1";
				$arr['Error']="";
			}
		}
		mysqli_close($con);
		echo json_encode($arr);
	
?>