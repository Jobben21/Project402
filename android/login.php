<?php
header("user-type:text/javascript;charset=utf-8");
	define('HOST', 'localhost');
	define('USER', 'root');
	define('PASS', 'cs402');
	define('DB', 'cs402');
	


		$con = mysqli_connect(HOST, USER, PASS, DB) or die('Unable to Connect');

		
		mysqli_set_charset($con, "utf8");
		mysqli_query($con,"SET NAMES UTF8");
		
		
		$strUsername = $_POST["struser"];
		$strPass=$_POST["strpass"];
		
		$strSQL = "SELECT * FROM user where name like '$strUsername' AND pass like '$strPass'";
		

$objQuery = mysqli_query($con,$strSQL);
$objResult = mysqli_fetch_array($objQuery);

$intNumRows = mysqli_num_rows($objQuery);
$result = array();
if($intNumRows==0)

{

$arr['name'] = "0";

$arr['MemberID'] = "0";

$arr['Error'] = "Incorrect Username and Password"; 

}

else

{


			$arr['name']= $objResult["name"];
			$arr['pass']= $objResult["pass"];
			$arr['age']= $objResult["age"];
			$arr['height']= $objResult["height"];
			$arr['weight']= $objResult["weight"];
			$arr['gender']= $objResult["gender"];
			$arr['id']=$objResult["user_id"];

}



mysqli_close($con);

echo json_encode($arr);
		
		?>