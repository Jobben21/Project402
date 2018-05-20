<?php
    header("user-type:text/javascript;charset=utf-8");
	define('HOST', 'localhost');
	define('USER', 'root');
	define('PASS', 'cs402');
	define('DB', 'cs402');
	


		$con = mysqli_connect(HOST, USER, PASS, DB) or die('Unable to Connect');
	 
	 
	 
	 
	 $userid1 = $_POST['userid'];

       

     $sql = "select * from blood_test where user_id ='$userid1';";

     $res = mysqli_query($con,$sql);
     $num=mysqli_num_rows($res);
     if($num>0)
     {
        $result= array();
        while($row=mysqli_fetch_array($res))
            array_push($result, array('sugar'=>$row['sugar'],
			'choles'=>$row['choles'],
			'hdl'=>$row['hdl'],
			'ldl'=>$row['ldl'],
			'potassium'=>$row['potassium'],
			'trigly'=>$row['trigly'],
			'sodium'=>$row['sodium']
    ));

            echo json_encode(array("result"=>$result));

     }
     else
     {
        echo "No accounts ";
     }
     mysqli_close($con);
?>