<?php   
 header("content-type:text/javascript;charset=utf-8");    
 $con=mysqli_connect('localhost','root','cs402')or die(mysql_error());    
 mysqli_select_db('cs402')or die(mysql_error());   
 mysqli_query("SET NAMES UTF8");
 $id = $_POST['user_id']; 
 $username = $_POST['name'];  
 $age = $_POST['age'];  
 $height = $_POST['height']; 
 $weight = $_POST['weight']; 
 $gender = $_POST['gender']; 
 
 $sql="INSERT INTO user (user_id,name,age,height,weight,gender) VALUES ('$id','$username','$age','$height','weight','gender')";   
 $res=mysqli_query($sql);   
 $arr = array('id' => mysqli_insert_id()."");  
 print('['.json_encode($arr).']');   
 mysqli_close();   
 ?>   