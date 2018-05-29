<?php
	header("user-type:text/javascript;charset=utf-8");
	define('HOST', 'localhost');
	define('USER', 'root');
	define('PASS', 'cs402');
	define('DB', 'cs402');
	


		$con = mysqli_connect(HOST, USER, PASS, DB) or die('Unable to Connect');

		
		mysqli_set_charset($con, "utf8");
		mysqli_query($con,"SET NAMES UTF8");
		
		
		$strUserid=$_POST["userid"];
		$strpass=$_POST["pass"];
		$strage=$_POST["age"];
		$strheight=$_POST["height"];
		$strweight=$_POST["weight"];
	
			
			//$strSql= "INSERT INTO user SELECT 1 WHERE user_id = '$struserid' ";
			//$strSql.="(pass,age,height,weight)";
			//$strSql.="VALUES";
			//$strSql .="('".$_POST["pass"]."','".$_POST["age"]."','".$_POST["height"]."' ";
			//$strSql .=",'".$_POST["weight"]."')";	
				
				$strSql="UPDATE user SET pass='$strpass' ,
				age='$strage',
				height='$strheight',
				weight='$strweight'
				WHERE user_id = '$strUserid'";
				
				
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