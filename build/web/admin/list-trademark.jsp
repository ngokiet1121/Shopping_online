<%-- 
    Document   : list-item
    Created on : Dec 20, 2015, 11:01:14 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@include file="../template/head.jsp" %>
    </head>
    <body>
        <div class="container" style="min-height: 1000px">
            <%@include file="../template/header.jsp" %>
            <!--End Header-->
            <!--Left-->
            <!--End Left-->
            <div id="content">
                <div class="row" style="position: relative;left: 20px;width: 1135px;">
                    <h2><fmt:message key="tabletrademark" bundle="${msg}"/></h2>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th><fmt:message key="trademark" bundle="${msg}"/></th>
                                <th><fmt:message key="img" bundle="${msg}"/></th>
                                <th><fmt:message key="edit" bundle="${msg}"/></th>
                                <th><fmt:message key="delete" bundle="${msg}"/></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="t" items="${dstra}">
                            <tr>
                                <td>${t.id}</td>
                                <td>${t.trademark}</td>
                                <td>${t.img}</td>
                                <td><a href="/banhangonlinev4.0/admin/doEdit?action=tra&id=${t.id}"><fmt:message key="edit" bundle="${msg}"/></a></td>
                                <td><a href="/banhangonlinev4.0/admin/doTra?action=delete&id=${t.id}"><fmt:message key="delete" bundle="${msg}"/></a></td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
