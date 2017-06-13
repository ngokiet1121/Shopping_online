<%-- 
    Document   : edit-Item
    Created on : Dec 20, 2015, 10:59:39 AM
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
                <form action="doUser" method="post">
                    <h2><fmt:message key="edituser" bundle="${msg}"/></h2>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" readonly="readonly" name="email" value="${id.email}">
                    </div>
                    <div class="form-group">
                        <label><fmt:message key="password" bundle="${msg}"/></label>
                        <input type="password" class="form-control" readonly="readonly" name="password" value="${id.password}">
                    </div>
                    <div class="form-group">
                        <label><fmt:message key="name" bundle="${msg}"/></label>
                        <input type="text" class="form-control" name="name" value="${id.userName}">
                    </div>
                    <div class="form-group">
                        <label><fmt:message key="address" bundle="${msg}"/></label>
                        <input type="text" class="form-control" name="address" value="${id.address}">
                    </div>  
                    <div class="form-group">
                        <label><fmt:message key="phone" bundle="${msg}"/></label>
                        <input type="text" class="form-control" name="phone" value="${id.phone}">
                    </div> 
                    <input type="submit" name="action" value="Edit" class="btn btn-primary">
                </form>
            </div>
        </div>
    </body>
</html>
