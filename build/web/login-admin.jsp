<%-- 
    Document   : login-admin
    Created on : Dec 20, 2015, 11:41:03 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
        <%@include file="template/head.jsp" %>
    </head>
    <body>
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="message" var="msg"/>
    <div class="container">
        <div class="row" style="position: relative; left: 25%; width: 500px;">
            <h2><fmt:message key="login" bundle="${msg}"/> Admin</h2>
            <form method="post" action="loginA">
                <div class="form-group" >
                    <label>Email</label>
                    <input type="email" class="form-control" name="email" placeholder="Email">
                </div>
                <div class="form-group">
                    <label>Mật Khẩu</label>
                    <input type="password" class="form-control" name="password" placeholder="Password">
                </div>
                <div class="checkbox">
                    <label><a href="forgot-password-admin.jsp" >Forgot Password</a></label>
                </div>
                <input type="submit" class="btn btn-primary" value="Login" >
            </form>
        </div>
    </div>
</body>
</html>
