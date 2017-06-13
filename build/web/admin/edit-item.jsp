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
                <form method="post" action="doItem?id=${id.id}">
                    <h2><fmt:message key="edititem" bundle="${msg}"/></h2>
                    <div class="form-group">
                        <label><fmt:message key="selectcategory" bundle="${msg}"/></label>
                        <select class="form-control" name="Idtype" id="sel1">
                            <c:forEach var="t" items="${dsType}">                                                                                              
                                <c:if test="${id.type != null && id.type.id == t.id}">
                                    <option value="${t.id}" selected="true">----${t.type}----</option>
                                </c:if>
                                <option value="${t.id}">----${t.type}----</option>
                            </c:forEach> 
                        </select>
                    </div>
                    <div class="form-group">
                        <div class="form-group">
                            <label><fmt:message key="selecttrademark" bundle="${msg}"/></label>
                            <select class="form-control" name="idtrademark" id="sel1">
                                <c:forEach var="t" items="${dsTra}">                                                                                              
                                    <c:if test="${id.trademark != null && id.trademark.id == t.id}">
                                        <option value="${t.id}" selected="true">----${t.trademark}----</option>
                                    </c:if>
                                    <option value="${t.id}">----${t.trademark}----</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label><fmt:message key="price" bundle="${msg}"/></label>
                        <input type="text" class="form-control" name="price" value="${id.price}" placeholder="Price">
                    </div>
                    <div class="form-group">
                        <label><fmt:message key="number" bundle="${msg}"/></label>
                        <input type="number" class="form-control" name="number" value="${id.number}" placeholder="Number">
                    </div>  
                    <input type="submit" name="action" value="Edit" class="btn btn-primary">
                </form>
            </div>
        </div>
    </body>
</html>
