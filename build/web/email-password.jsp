<%-- 
    Document   : activate-email
    Created on : Jan 2, 2016, 11:25:44 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="template/head2.jsp" %>
        <meta http-equiv="refresh" content="5;login.jsp">

    </head>
    <body>
        <%@include file="template/header2.jsp" %>
        <%@include file="template/login-register.jsp" %>
        <div class="container">
            <div class="alert alert-success">
                <h2 style="text-align: center;">Password mới đã được gửi đến email của bạn</h2>
                <h2 style="text-align: center;">Vui lòng kiểm tra email và đăng nhập đổi lại mật khẩu</h2>
            </div>
            <center><div id="countdown">5</div></center>
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
