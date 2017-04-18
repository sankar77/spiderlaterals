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
  <li><a href="index2.php">BASIC MESSAGING</a></li>
  <li><a href="pm.php">PRIVATE MESSAGING</a></li>
  <li class="active"><a href="#">MY PROFILE</a></li>
  
</ul>
</div>
</nav>  
<div id="container">
<form method="post" action="profile.php">
<input type="text" name="name" placeholder="enter name"/>
<input type="text" name="status" placeholder="enter status"/>
<textarea name="message" placeholder="enter message"/></textarea>
<input type="submit" name="submit" value="Send"/>
</form>
</div>
