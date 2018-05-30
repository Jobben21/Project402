<?php
	header("user-type:text/javascript;charset=utf-8");
	define('HOST', 'localhost');
	define('USER', 'root');
	define('PASS', 'cs402');
    define('DB', 'cs402');
    
    $con = mysqli_connect(HOST, USER, PASS, DB) or die('Unable to Connect');
    mysqli_set_charset($con, "utf8");

	
    if (!$_POST["resugar"] or !$_POST["resodium"] or !$_POST["repotassium"] or !$_POST["recholes"] or !$_POST["reldl"] or !$_POST["rehdl"] or !$_POST["retrigly"]) {
        $sql = "SELECT * FROM foodmenu WHERE food_disease IN (";
        $sql .= (!$_POST["resugar"]) ? "'เบาหวาน'," : "";
        $sql .= (!$_POST["resodium"]) ? "'โรคไต'," : "";
        $sql .= (!$_POST["repotassium"]) ? "'โรคไรไม่รู้ เว้นไว้ก่อน'," : "";
        $sql .= (!$_POST["recholes"]) ? "'คอเลสเตอรอล'," : "";
        $sql .= (!$_POST["reldl"]) ? "'หัวใจ'," : "";
        $sql .= (!$_POST["rehdl"]) ? "'หัวใจ'," : "";
        $sql .= (!$_POST["retrigly"]) ? "'ไตรกลีเซอไรด์'," : "";
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
			'energy'=>$row['energy'],
			'carbohydrate'=>$row['carbohydrate'],
			'fat'=>$row['fat'],
			'protein'=>$row['protein'],
			'sugar'=>$row['sugar'],
			'sodium'=>$row['sodium']
            )
        );
		
    }

    echo json_encode(array('result' => $result));
    mysqli_close($con);
?>