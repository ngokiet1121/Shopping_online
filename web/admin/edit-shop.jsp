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
                <form action="doShop" method="post">
                    <h2><fmt:message key="editshop" bundle="${msg}"/></h2>
                    <div class="form-group">
                        <label><fmt:message key="name" bundle="${msg}"/></label>
                        <input type="text" class="form-control" name="name" value="${shop.name}">
                    </div>
                    <div class="form-group">
                        <label><fmt:message key="address" bundle="${msg}"/></label>
                        <input type="text" class="form-control"  name="address" value="${shop.address}">
                    </div>
                    <div class="form-group">
                        <label><fmt:message key="phone" bundle="${msg}"/></label>
                        <input type="text" class="form-control" name="phone" value="${shop.phone}">
                    </div>  
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" name="email" value="${shop.email}">
                    </div> 
                    <input type="submit" name="action" value="Edit" class="btn btn-primary">
                </form>
            </div>
        </div>
    </body>
</html>
