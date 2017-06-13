<%-- 
    Document   : edit-banner
    Created on : Jan 4, 2016, 10:52:42 AM
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
                <form action="doBanner" method="post">
                    <h2><fmt:message key="editbanner" bundle="${msg}"/></h2>                  
                    <div class="form-group">
                        <label>Banner</label>
                        <input type="file" class="form-control" value="${id.banner}">
                    </div>                    
                    <input type="submit" name="action" value="Edit" class="btn btn-primary">
                </form>
            </div>
        </div>
    </body>
</html>
