<!DOCTYPE html>
<html>
<head>
<link href="Project/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="Project/js/bootstrap.min.js.css" rel="stylesheet" type="text/css">
<style>
*{ padding: 0; margin: 0; border: 0; } 
body{ background: silver; } 
#container{ width: 100%; background: white; margin: 0 auto; padding: 20px; } 
#chat_box{ width: 100%; height: 400px; } 
#chat_data{ width: 100%; padding: 5px; margin-bottom: 5px; border-bottom: 1px solid silver; font-weight: bold; } 
input[type="text"]{ width: 100%; height: 40px; border: 1px solid grey; border-radius: 5px; } 
input[type="submit"]{ width: 100%; height: 40px; border: 1px solid grey; border-radius: 5px; } 
textarea{ width: 100%; height: 40px; border: 1px solid grey; border-radius: 5px; }
</style>

</head>
<body>
<nav class="navbar navbar-inverse">
<div style="text-align:center" class="container-fluid">

<div class="jumbotron">
   
 <h1>CHAT APPLICATION</h1>
</div>
</div>
<ul class="nav navbar-nav">
  <li class="active"><a href="#">BASIC MESSAGING</a></li>
  <li><a href="pm.php">PRIVATE MESSAGING</a></li>
  <li><a href="profile.php">MY PROFILE</a></li>
  
</ul>
</div>
</nav>  

<?php 

$con=mysql_connect("localhost","root","");
if(!$con){
die("can not connect:".mysql_error());
}
mysql_select_db("chat",$con);
if(isset($_POST['submit'])){
	$date = date('Y-m-d H:i:s');
$sql="INSERT INTO chattable(name,msg,date) VALUES('$_POST[name]','$_POST[message]','$date')";
mysql_query($sql,$con);
}

$query = "SELECT * FROM chattable ORDER BY id";
$myData=mysql_query($query,$con);
while($record = mysql_fetch_array($myData))
{
echo'<div id="container">';
echo'<div id="chat_data">';
echo'<span style="color:green;">';
echo $record['name'];
echo '</span>'; 
echo':';
echo'<span style="color:brown;">';
echo $record['msg'];
echo'</span>';
echo' <span style="float:right;">';
echo $record['date'];
echo'</span>';
echo' </div>';
echo'</div>';


}

?>
<script>
document.getElementByName('submit').onclick=function chat_ajax(){
	var req=new XMLHttpRequest();
	req.onreadystatechange=function(){
		if(req.readystate==4&&req.status==200){
			document.getElementById('chat_data').innerHTML=req.responseText;
		}
	}
	req.open("GET",index2.php,true);
	req.send();
}
setInterval(function(){chat_ajax()},1000);
</script>

<div id="container">
<div id="chat_box">
<div id="chat_data">
<span style="color:green;">Samarth:</span>
<span style="color:brown;">Hey:</span>
<span style=float:right;">12:30</span>
</div>
</div>
<form method="post" action="index2.php">
<input type="text" name="name" placeholder="enter name"/>
<textarea name="message" placeholder="enter message"/></textarea>
<input type="submit" name="submit" value="Send"/>
</form>
</div>
</body>
</html>