<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

body{
	/* background-image: url("brushed_@2X.png"); */
	background-color: white;
	padding-top: 0px;
	margin:0;
    position: static;
}

#head-section{

	
	
	background-color:#66a3ff;
	box-shadow: 0px 4px 15px -4px black;
	padding-top:2%;
	
	padding-bottom: 2%;
	 padding-left:1%;
     
	
}

#head-logo{
	
	background-color: #66a3ff;
   
    padding-left: 13px;
    padding-top: 15px;
    padding-bottom: 15px;
    box-shadow: 1px 5px 10px -6px rgba(0, 0, 0, .5);
}

#head{
	color: white;
	font-size: 160%;
	font-family: 'verdana';
	margin-top:2%;
	margin-left:21%;
	text-shadow: 3px 3px 15px grey;
	
}

#main-section{
	
	margin-top: 8%;
	
	
	
}

#login-table{
    
    width: 100%;
    margin-bottom: 1%;
    text-align: center;
    padding-left: 10px;
    padding-right: 20px;
    
}

#login-table input{
    
    width: 100%;
    text-align: center;
    
   
   
   
}

#login-table select {

    width: 103%;
    text-align: center;
    
    padding-top: 2px;
    padding-bottom: 2px;
    
}

#login-btn{
    margin-top: 1%;
   text-align: center;
   
}

#login-btn a{
	
	text-align: center;
	margin-top: 2%;
	padding-left:25%;
	
}

#login-btn input{
   
 
    
}
#login-btn a{
   
    margin-left: 10%;
    
}

#main-div{
	
	
	
	box-shadow: 0px 4px 15px -4px black;
	margin-left: 30%;
	width: 41%;
	border-radius: 3px;
	padding-bottom: 40px;
     border-radius: 6px 6px 0px 0px;
     /* background-color: rgba(228, 224, 224, 0.42); */
	
	
}



#main-form{
	
	margin-top: 5%;
	font-size: 110%;
}
#login-header{
	
	text-align: center;
	color: white;
	padding-top:15px;
	padding-bottom:15px;
	font-size:150%;
	font-family: sans-serif;
	background-color: #66a3ff;
	box-shadow: 0px 8px 22px -13px  black;
     border-radius: 6px 6px 0px 0px;
    
}

#footer {
	text-align: center;
	background-color: #66a3ff;
	margin-top: 11%;
	
	padding: 12px 5px;
	
	
	font-family:'Lucida Sans';
	font-size: 85%;
	box-shadow: 0px -6px 11px -9px  black;
}

#frgt-pswd{
	
	text-decoration: none;
	color:#3385ff;
	margin-left:4%;
	padding-left:2%;
}

#frgt-pswd:hover{
	
	color:black;
}

.text-box {
	border-radius: 3px;
	border: 1px solid #99c2ff;
	padding-top: 1%;
	padding-bottom: 1%;
	padding-left: 2%;
    border-radius: 3px;
   /*  background-color: rgba(243, 240, 240, 0.95); */
    font-family: 'Lucida Sans';
    font-size: 90%;
}

.text-box2 {
	border-radius: 3px;
	border: 1px solid #99c2ff;
	padding-top: 3%;
	padding-bottom: 3%;
	padding-left: 46%;
    border-radius: 3px;
   /*   background-color: rgba(243, 240, 240, 0.95); */
        font-family: 'Lucida Sans';
    font-size: 80%;
}

.text-box:focus{

border: 1px solid #ff6600;
background-color: white;
font-size: 80%;
}

.text-box:hover{
border: 1px solid black;

}

.text-box2:focus{

border: 1px solid #ff6600;
background-color: white;
    font-family: 'Lucida Sans';
    font-size: 80%;
}

.text-box2:hover{
border: 1px solid black;

}

.btn {
	background-color:#99c2ff;
	border: none;
	color: white;
	padding: 5px 15px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
    border-radius: 3px;
    width: 90%;
    margin-bottom: 2%;
    margin-left: 5%;
    margin-right: 5%;
}

.btn:hover {
	transform: scale(1.005);
	color:black;
}

.identity{
	
	font-family: 'verdana';
	color:#005ce6;
	font-size: 90%;
}

#life{
    
    font-family: sans-serif;
    font-size: 225%;
    width: 100%;
    text-decoration: none;
    color:black;
}

#pharma{
    
    font-family: fantasy;
    font-family: 'Century Gothic';
    font-size: 175%;
     text-decoration: none;
      color:black;
}

</style>
<script type="text/javascript" language="javascript">   
function disableBackButton()
{
window.history.forward()
}  
disableBackButton();  
window.onload=disableBackButton();  
window.onpageshow=function(evt) { if(evt.persisted) disableBackButton() }  
window.onunload=function() { void(0) }  
</script>
<script type="text/javascript">

    if (top.location!= self.location) {
        top.location = self.location.href
                   //or you can use your logout page as
                   //top.location='logout.jsp' here...
    }

</script>


<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="login.css">
</head>
<body onload="noBack();">
<section id="head-section">
<span ><a href="index.html" id="life">LIFE</a></span><span ><a href="index.html" id="pharma">PHARMA</a></span><span id="head">EXPIRY MANAGEMENT SYSTEM</span>
</section>
<section id="main-section">


<div id="main-div">
<article id="login-header">LOGIN</article>
<form:form commandName="logb" method="post" id="main-form">

<div id="data"></div>
<br>
    <table id="login-table">
<tr><td><input type="text" class="text-box" placeholder="Enter User Name" name="userid"></td></tr>
        <tr></tr>
       <tr><td> <input type="password" class="text-box" placeholder="Enter Password" name="pwd"></td></tr>
  <tr></tr>
        <tr><td><select name="role" class="text-box2"><option selected="selected">ROLE</option><option value="admin">ADMIN</option><option value="user">USER</option></select></td></tr>
    </table>
<br> 
    
    <span id="login-btn"><input type="submit" value="Login" class="btn"><br>
<input type="reset" value="Clear" class="btn"><br>
&nbsp;&nbsp;
&nbsp;&nbsp;
<a href="ForgotPassword.jsp" id="frgt-pswd">Forgot Password</a></span>
</form:form>
</div>
</section>
<footer id="footer"> &copy;Copyright &nbsp;| &nbsp;Sagnik
		Upadhyay  & Priyanka Dasari&nbsp;|&nbsp; 2016 </footer>

<form:form commandName="logb" method="post">
<br>
<!-- UserNAme <form:input path="userid" /><br>
Password <form:input path="pwd" /><br>
Role  <form:input path="role" /><br>
<input type="submit" value="login">
<input type="reset" value="clear">
</form:form> -->




</body>
</html>