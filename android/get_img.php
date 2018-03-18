<?php
	header("foodmenu-type:text/javascript;charset=utf-8");
	define('HOST', 'localhost');
	define('USER', 'root');
	define('PASS', 'cs402');
	define('DB', 'cs402');
	
	if($_SERVER['REQUEST_METHOD'] == 'GET'){
		$status = $_GET['status'];

		$con = mysqli_connect(HOST, USER, PASS, DB) or die('Unable to Connect');

		mysqli_set_charset($con, "utf8");

		$sql = "SELECT * FROM foodmenu WHERE status='" . $status . "'";

		
		$r = mysqli_query($con,$sql);
		
		
		$result = array();
		$result1 = array();
		$pic = array();

		while($row = mysqli_fetch_array($r))
		{
			

		 ?> <img src='<?php echo $row['foodpic'];?>' height='100' width='100'><?php
		 echo $row['ID'];
		 echo "."; 
		 echo " ";
		 echo $row['food_name'];
		 echo "<br>";
		
		}
mysqli_close($con);
	}
		
		
	
	
	
?>
	
