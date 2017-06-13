<%-- 
    Document   : login
    Created on : Jan 1, 2016, 2:53:03 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="template/head2.jsp" %>
    </head>
    <body>
        <%@include file="template/header2.jsp" %>
        <%@include file="template/login-register.jsp" %>
        <div class="container">
            <div class="row" style="position: relative; left: 25%; width: 500px;">
                <form method="post" action="login">
                    <h2><fmt:message key="login" bundle="${msg}"/></h2>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" name="email" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" id="alpha"  pattern="[a-zA-Z0-9]+" required class="form-control" name="password" placeholder="Password">
                    </div>    
                    <div class="checkbox">
                        <label><a href="#forgot"><fmt:message key="forgotpassword" bundle="${msg}"/></a>/<a href="#open"><fmt:message key="register" bundle="${msg}"/></a></label>
                    </div>
                    <input type="submit" name="action" value="Login" class="btn btn-primary">
                </form>            
            </div>
        </div>
        <%@include file="template/footer.jsp" %>
    </body>
</html>
