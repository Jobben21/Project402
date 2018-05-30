<?php
	header("user-type:text/javascript;charset=utf-8");
	define('HOST', 'localhost');
	define('USER', 'root');
	define('PASS', 'cs402');
	define('DB', 'cs402');
	


		$con = mysqli_connect(HOST, USER, PASS, DB) or die('Unable to Connect');

		
		mysqli_set_charset($con, "utf8");
		mysqli_query($con,"SET NAMES UTF8");
		
		
			
			$strSql= "INSERT INTO foodmenu";
			$strSql.="(food_name,food_ingred,food_solution,food_disease,food_type,energy,carbohydrate,fat,protein,sugar,sodium)";
			$strSql.="VALUES";
			$strSql .="('".$_POST["food_name"]."','".$_POST["food_ingred"]."','".$_POST["food_solution"]."','".$_POST["food_disease"]."'";
			$strSql .=",'".$_POST["food_type"]."','".$_POST["energy"]."'";	
			$strSql .=",'".$_POST["carbohydrate"]."','".$_POST["fat"]."'";
			$strSql .=",'".$_POST["protein"]."','".$_POST["sugar"]."'";
			$strSql .=",'".$_POST["sodium"]."')";
			
				
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