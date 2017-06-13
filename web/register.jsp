<%-- 
    Document   : register
    Created on : Jan 1, 2016, 9:33:36 PM
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
        <div class="row" style="position: relative; left: 25%; width: 500px;">
            <form method="post" action="signup">
                 <h2><fmt:message key="register" bundle="${msg}"/></h2>
                <div class="form-group" >
                    <label for="alpha"><fmt:message key='name' bundle='${msg}'/></label><br/>
                    <input class="form-control" id="alpha" type="text" name="username" placeholder="<fmt:message key='name' bundle='${msg}'/>" pattern="[a-zA-Z0-9 ]+" required>
                </div>
                <div class="form-group" >
                    <label for="alpha"><fmt:message key='address' bundle='${msg}'/></label><br/>
                    <input class="form-control" id="alpha" type="text" name="address" placeholder="<fmt:message key='address' bundle='${msg}'/>" pattern="[a-zA-Z0-9 ]+" required>
                </div>
                <div class="form-group" >
                    <label for="phonenum"><fmt:message key='phone' bundle='${msg}'/>:</label>
                    <input class="form-control" type="tel" pattern="^\d{11}$" name="phone" required placeholder="<fmt:message key='phone' bundle='${msg}'/>" >
                </div>
                <div class="form-group">
                    <label for="alpha">Email</label>
                    <input id="alpha" type="email" class="form-control" name="email" placeholder="Email" required>
                </div>
                <div class="form-group">
                    <label for="alpha"><fmt:message key='password' bundle='${msg}'/></label>
                    <input type="password" id="alpha" class="form-control" name="password" placeholder="<fmt:message key='password' bundle='${msg}'/>" required>
                </div>
                <div class="form-group">
                    <label for="alpha"><fmt:message key='comfirmpassword' bundle='${msg}'/></label>
                    <input type="password" id="alpha" class="form-control" name="comfirmpassword" placeholder="<fmt:message key='comfirmpassword' bundle='${msg}'/>" required>
                </div>
                <div class="checkbox">
                </div>
                 <input type="submit" class="btn btn-primary" value="Register">
            </form>
        </div>
        <%@include file="template/footer.jsp" %>
    </body>
</html>
