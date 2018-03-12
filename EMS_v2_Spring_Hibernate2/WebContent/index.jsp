<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

#header-header{
    width:25%;
   
    
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

#head-nav{
    
    text-align: right;
    padding-right: 2%;
}

.nav-list a{
    
    list-style: none;
    text-decoration: none;
    font-family: Papyrus;
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
    font-size: 225%;
}

#body-section{
    
   
    
}
#body-image{
    
   
    
}

#window{
   margin-top: 10%;
  border: none;
  width: 100%;
  height: 510px;
}

#foot-er{
    
   text-align: center;
	background-color: #66a3ff;
	
	
	padding: 12px 5px;
	
	
	font-family:'Lucida Sans';
	font-size: 85%;
	box-shadow: 0px -7px 11px -9px  black;
    position: initial;
    margin-bottom: -1px;
}
</style>

<script>
    $(document).ready(function() {
        function disableBack() { window.history.forward() }

      
    });
</script>
    <style>
    
    </style>
    <title>Index</title>
    <link href="index.css" type="text/css" rel="stylesheet">
    <script type="text/javascript">

    if (top.location!= self.location) {
        top.location = self.location.href
                   //or you can use your logout page as
                   //top.location='logout.jsp' here...
    }

</script>
    </head>
    
    <body onload="disableBack()">
        <div id="head-div">
    <section id="header-section">
  
            <span id="life">LIFE</span><span id="pharma">PHARMA</span>
      
       
        </section>
            <nav id="head-nav">
            <ul>
            <!-- <li class="nav-list"><a href="about.html" target="display-area" >ABOUT US</a></li> -->
                 <li class="nav-list"><a href="./login.spring" >LOGIN</a></li>
            </ul>
            </nav>
            </div>
    
    <section id="body-section">
        <div id="div-body">
   <iframe id="window" src="dummy.jsp" name="display-area"></iframe>
        </div>
        </section>
    <footer id="foot-er">
    &copy;Copyright &nbsp;| &nbsp;Sagnik
		Upadhyay & Priyanka Dasari &nbsp;|&nbsp; 2016
    </footer>
    </body>
</html>