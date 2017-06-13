<%-- 
    Document   : create-item
    Created on : Dec 20, 2015, 10:39:05 AM
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
                <form action="doItem" method="post">
                    <h2><fmt:message key="createitem" bundle="${msg}"/></h2>
                    <div class="form-group">
                        <label><fmt:message key="selectcategory" bundle="${msg}"/></label>
                        <select class="form-control" name="Idtype" id="sel1">
                            <option><fmt:message key="category" bundle="${msg}"/></option>
                            <c:forEach var="t" items="${dsType}">
                                <option value="${t.id}">${t.type}</option>                                
                            </c:forEach>                        
                        </select>
                    </div>
                    <div class="form-group">
                        <div class="form-group">
                            <label><fmt:message key="selecttrademark" bundle="${msg}"/></label>
                            <select class="form-control" name="idtrademark" id="sel1">
                                <option><fmt:message key="trademark" bundle="${msg}"/></option>
                                <c:forEach var="t" items="${dsTra}">
                                    <option value="${t.id}">${t.trademark}</option>                                
                                </c:forEach> 
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label><fmt:message key="price" bundle="${msg}"/></label>
                        <input type="text" class="form-control" name="price" placeholder="Price">
                    </div>
                    <div class="form-group">
                        <label><fmt:message key="number" bundle="${msg}"/></label>
                        <input type="number" min="0" class="form-control" name="number" placeholder="Number">
                    </div>  
                    <input type="submit" name="action" value="Create" class="btn btn-primary">
                </form>
            </div>
        </div>
    </body>
</html>
