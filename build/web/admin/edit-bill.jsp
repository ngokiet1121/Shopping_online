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
                <form action="doBill?idbill=${id.id}" method="post">
                    <h2><fmt:message key="editbill" bundle="${msg}"/></h2>
                    <div class="form-group">
                        <label><fmt:message key="bill" bundle="${msg}"/></label>
                        <input type="text" class="form-control" readonly value="${id.id}" name="idbill" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <label><fmt:message key="user" bundle="${msg}"/></label>
                        <input type="email" class="form-control" readonly value="${id.user.email}"  placeholder="Email">
                    </div>                  
                    <div class="form-group">
                        <label><fmt:message key="totalprice" bundle="${msg}"/></label>
                        <input type="text" class="form-control" readonly value="${id.totalPrice}"  placeholder="Name">
                    </div>
                    <div class="form-group">
                        <label><fmt:message key="sale" bundle="${msg}"/></label>
                        <input type="text" class="form-control" readonly value="${id.sale} %"  placeholder="Address">
                    </div>
                    <div class="form-group">
                        <label><fmt:message key="status" bundle="${msg}"/></label>
                        <input type="text" class="form-control"  value="${id.status}" name="status" placeholder="Address">
                    </div>
                    <input type="submit" name="action" value="Edit" class="btn btn-primary">
                </form>
            </div>
        </div>
    </body>
</html>
