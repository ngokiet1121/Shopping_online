<%-- 
    Document   : add-image-item
    Created on : Jan 4, 2016, 10:19:14 AM
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
                <form method="post" action="addimg?id=${id.id}" enctype="multipart/form-data" name="form1" id="form1">
                    <h2><fmt:message key="addimageitem" bundle="${msg}"/></h2>                  
                    <div class="form-group">
                        <label><fmt:message key="image" bundle="${msg}"/></label>
                        <input type="file" name="file" id="file" class="form-control" multiple>
                    </div>
                    <input type="submit" name="action" value="Addimg" class="btn btn-primary">
                </form>
            </div>
        </div>
    </body>
</html>
