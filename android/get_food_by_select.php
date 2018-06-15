<?php
	header("user-type:text/javascript;charset=utf-8");
	define('HOST', 'localhost');
	define('USER', 'root');
	define('PASS', 'cs402');
    define('DB', 'cs402');
    
    $con = mysqli_connect(HOST, USER, PASS, DB) or die('Unable to Connect');
    mysqli_set_charset($con, "utf8");

	
    if (!$_POST["se_choles"] or !$_POST["se_trigly"] or !$_POST["se_sugar"] or !$_POST["se_sodium"] ) {
        $sql = "SELECT * FROM foodmenu WHERE food_disease IN (";
        $sql .= (!$_POST["se_choles"]) ? "'คอเลสเตอรอล'," : "";
        $sql .= (!$_POST["se_trigly"]) ? "'ไตรกลีเซอไรด์'," : "";
        $sql .= (!$_POST["se_sugar"]) ? "'เบาหวาน'," : "";
        $sql .= (!$_POST["se_sodium"]) ? "'โรคไต'," : "";
        $sql = substr($sql, 0, -1);
        $sql .= ")";
		
    }
    else {
        $sql = "SELECT * FROM foodmenu";
    }

    $r = mysqli_query($con, $sql);
    $result = array();
    while($row = mysqli_fetch_array($r)) {
        array_push(
            $result, array(
              
				
				
			'name'=>$row['food_name'],
			'foodpic'=>$row['foodpic'],
			'ingred'=>$row['food_ ingred'],
			'method'=>$row['food_solution'],
			'typeingred'=>$row['type_ingred'],
			'foodtype'=>$row['food_type'],
			'energy'=>$row['energy'],
			'carbohydrate'=>$row['carbohydrate'],
			'fat'=>$row['fat'],
			'protein'=>$row['protein'],
			'sugar'=>$row['sugar'],
			'sodium'=>$row['sodium'],
			'food_disease'=>$row['food_disease']
            )
        );
		
    }

    echo json_encode(array('result' => $result));
    mysqli_close($con);
?>