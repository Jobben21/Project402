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
		$intnum=mysqli_num_fields($r);
		
		$result = array();
		
		

		while($row = mysqli_fetch_array($r))
		{
			$arrcol = array();
			for($i=0;$i<$intnum;$i++)
			{
				
				$arrcol[mysqli_fetch_field($r,$i)] =$row[$i];
					
			}

			array_push($result,$arrcol);
			
		}
	
		mysqli_close($con);
		echo json_encode($result);
		}
		?>