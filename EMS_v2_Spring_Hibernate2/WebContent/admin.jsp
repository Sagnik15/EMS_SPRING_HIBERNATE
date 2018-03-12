<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{
    
    margin:0 auto;
    height: 100%;
width: 100%;
    
}
#header-section{
    
   
    background-color: #66a3ff;
   
    padding-left: 13px;
    padding-top: 1%;
    padding-bottom: 1%;
    box-shadow: 1px 1px 6px 2px rgba(0, 0, 0, .5);
    

}
#head-div {
   box-shadow: 0px 4px 15px -4px black;
    padding-bottom: 5px;
    position: initial;
    width: 100%;
    margin-bottom: 5px;
    position: fixed;
    background-color: #fff;

}

#head-span{
	
	text-align:right;
	width:50px;
position:relative;
	padding-top:1%;
	padding-left:10px;
	margin-left: 6%;
	font-family: verdana;
	color:grey;
font-size: 110%;
}
#head-nav{
	position:relative;;
    float:right;
    text-align: right;
    padding-right: 2%;
}

.nav-list a{
    
    list-style: none;
    text-decoration: none;
    font-family: 'verdana';
    padding-right: 15px;
    padding-left: 15px;
    color: #f00;
    text-shadow: 1px 1px 1px black;
}

.nav-list {
     list-style: none;
    text-decoration: none;
    font-family: Papyrus;
   
    color: #f00;
    text-shadow: 1px 1px 1px black;
display: inline-block;
}

#life{
    
    font-family: sans-serif;
    font-size: 250%;
    
}

#pharma{
    
    font-family:'Century Gothic';
    font-size: 200%;
    margin-right:50%;
}

#section-body{
	
	
}

#window{
   margin-top: 9%;
  border: none;
  width: 100%;
  height: 510px;
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
 <link href="admin.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%-- <%
String sId = (String)session.getAttribute("sessionId");
//String role = (String)session.getAttribute("role");
//System.out.println(role);

if(sId != request.getSession(false).getId()){
	session.invalidate();
	response.sendRedirect("login.html");
	
}
%> --%>
<script type="text/javascript">

    if (top.location!= self.location) {
        top.location = self.location.href;
                   //or you can use your logout page as
                   //top.location='logout.jsp' here...
    }

</script>
</head>
<body onload="noBack();">

<div id="head-div">
    <section id="header-section">
  
            <span id="life">LIFE</span><span id="pharma">PHARMA</span><span id="head-span">Welcome &nbsp;&nbsp;${sessionScope.uid}</span>
      
       
        </section>
         

            <nav id="head-nav">
           
            <ul>
            <li class="nav-list"><a href="./reports.jsp" target="display-area" >Reports</a></li>
             <li class="nav-list"><a href="./PlaceOrder.jsp" target="display-area" >Place Order</a></li>
               <li class="nav-list"><a href="./ReturnItems.jsp" target="display-area" >Return items</a></li>
              <li class="nav-list"><a href="./AddToInventory.jsp" target="display-area" >Add to Inventory</a></li>
               <li class="nav-list"><a href="./ViewUser.jsp" target="display-area" >View Users</a></li>
            <li class="nav-list"><a href="./addUser.jsp" target="display-area" >Add User</a></li>
             <li class="nav-list"><a href="./DeleteUser.jsp" target="display-area" >Delete User</a></li>
                 <li class="nav-list"><a href="./logout.jsp" >LOGOUT</a></li>
            </ul>
            </nav>
            </div>
            
            <section id="section-body">
<div id="welcome-div"><span>Welcome</span>

</div>
<section id="body-section">
        <div id="div-body">
   <iframe id="window" src="dummy.jsp" name="display-area"></iframe>
        </div>
        </section>
</section>


</body>
</html>