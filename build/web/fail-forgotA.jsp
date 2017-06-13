<%-- 
    Document   : activate-email
    Created on : Jan 2, 2016, 11:25:44 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../template/head.jsp" %>
        <meta http-equiv="refresh" content="3;forgot-password-admin.jsp">
    </head>
    <body>      
        <div class="container">
             <%@include file="../template/header.jsp" %>
            <div class="alert alert-danger">
                <h2 style="text-align: center;">Email của bạn không đúng</h2>
            </div>
            <center><div id="countdown">3</div></center>
        </div>   
    <script type="text/javascript">
        var seconds;
        var temp;

        function countdown() {
            seconds = document.getElementById('countdown').innerHTML;
            seconds = parseInt(seconds, 10);

            if (seconds == 1) {
                temp = document.getElementById('countdown');
                temp.innerHTML = "all done, bye bye";
                return;
            }

            seconds--;
            temp = document.getElementById('countdown');
            temp.innerHTML = seconds;
            timeoutMyOswego = setTimeout(countdown, 1000);
        }

        countdown();
    </script>
</body>
</html>
