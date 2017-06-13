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
                <form action="doTra?id=${id.id}">
                    <h2><fmt:message key="edittrademark" bundle="${msg}"/></h2>                  
                    <div class="form-group">
                        <label><fmt:message key="trademark" bundle="${msg}"/></label>
                        <input type="text" class="form-control" name="trademark" value="${id.trademark}" placeholder="Trademark">
                    </div>
                    <div class="form-group">
                        <label><fmt:message key="img" bundle="${msg}"/></label>
                        <input type="file" class="form-control" name="img" value="" placeholder="Img">
                    </div>  
                    <input type="submit" name="action" value="Edit" class="btn btn-primary">
                </form>
            </div>
        </div>
    </body>
</html>
