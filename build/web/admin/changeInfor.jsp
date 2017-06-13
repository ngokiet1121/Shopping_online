<%-- 
    Document   : changeinfor
    Created on : Jan 4, 2016, 12:01:30 PM
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
                <form action="changeinforA" method="post">
                    <h2><fmt:message key="changeInformation" bundle="${msg}"/></h2>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" readonly class="form-control" name="email" value="${admin.email}" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <label><fmt:message key="password" bundle="${msg}"/></label>
                        <input type="password" class="form-control" readonly="readonly" name="password" value="${admin.password}" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <label><fmt:message key="name" bundle="${msg}"/></label>
                        <input type="text" class="form-control" name="name" value="${admin.name}" placeholder="Name">
                    </div>
                    <div class="form-group">
                        <label><fmt:message key="address" bundle="${msg}"/></label>
                        <input type="text" class="form-control" name="address" value="${admin.address}" placeholder="Address">
                    </div> 
                    <div class="form-group">
                        <label><fmt:message key="phone" bundle="${msg}"/></label>
                        <input type="text" class="form-control" name="phone" value="${admin.phone}" placeholder="Phone">
                    </div> 
                    <input type="submit" name="action" value="Change" class="btn btn-primary">
                </form>
            </div>
        </div>
    </body>
</html>
