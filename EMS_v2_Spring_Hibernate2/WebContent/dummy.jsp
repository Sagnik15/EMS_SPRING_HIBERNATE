<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en">
    <head>
    <script>
    $(document).ready(function() {
        function disableBack() { window.history.forward() }

        window.onload = disableBack();
        window.onpageshow = function(evt) { if (evt.persisted) disableBack() }
    });
</script>
        <meta charset="utf-8" />
        <title></title>
        <style>
            body{
                
                margin: 0;
            }
            #image{
                
                width: 100%;
                
                padding-top: 100px;
                text-align: center;
            }
            #life{
    
    font-family: sans-serif;
    font-size: 400%;
    
}

#quote{
                
       font-family: 'Freestyle Script';
       font-size: 200%;
       color: #f00;         
            }
#pharma{
    
    font-family:'Century Gothic';
    font-size: 300%;
}

            
</style>

    </head>
    <body>
       

        <div id="image"> <span id="life">LIFE</span><span id="pharma">PHARMA</span>
        <br>
            <span id="quote">At Your Service</span>
        </div>

    </body>
</html>
