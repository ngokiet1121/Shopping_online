<%-- 
    Document   : changepass
    Created on : Jan 4, 2016, 12:01:20 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../template/head.jsp" %>
    </head>
    <body>
        <div class="container" style="min-height: 1000px">
            <%@include file="../template/header.jsp" %>
            <div class="row" style="position: relative; left: 25%; width: 500px;">
                <form action="changepassA" method="post">
                    <h2><fmt:message key="changepass" bundle="${msg}"/></h2>                  
                    <div class="form-group">
                        <label><fmt:message key="password" bundle="${msg}"/></label>
                        <input type="password" class="form-control" name="password" placeholder="Old Password">
                    </div>   
                    <div class="form-group">
                        <label><fmt:message key="newpassword" bundle="${msg}"/></label>
                        <input type="password" class="form-control" name="newpassword" placeholder="New Password">
                    </div> 
                    <div class="form-group">
                        <label><fmt:message key="comfirmpassword" bundle="${msg}"/></label>
                        <input type="password" class="form-control" name="confirmpassword" placeholder="Confirm Password">
                    </div> 
                    <input type="submit" name="action" value="Change" class="btn btn-primary">
                </form>
            </div>
        </div>
    </body>
</html>
