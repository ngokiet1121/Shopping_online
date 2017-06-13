<%-- 
    Document   : list-item
    Created on : Dec 20, 2015, 11:01:14 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <h2><fmt:message key="tableuser" bundle="${msg}"/></h2>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th><fmt:message key="name" bundle="${msg}"/></th>
                                <th>Email</th>
                                <th><fmt:message key="address" bundle="${msg}"/></th>
                                <th><fmt:message key="phone" bundle="${msg}"/></th>
                                <th><fmt:message key="status" bundle="${msg}"/></th>
                                <th><fmt:message key="edit" bundle="${msg}"/></th>
                                <th><fmt:message key="delete" bundle="${msg}"/></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="u" items="${users}">
                                <tr>
                                    <td>
                                        ${u.id}
                                    </td>
                                    <td>
                                        ${u.userName}
                                    </td>
                                    <td>
                                        ${u.email}
                                    </td>
                                    <td>
                                        ${u.address}
                                    </td>
                                    <td>
                                        ${u.phone}
                                    </td>
                                    <c:if test="${u.status == 0}">
                                        <td>Chưa xát nhận</td>
                                    </c:if>
                                    <c:if test="${u.status == 1}">
                                        <td>Đã xát nhận</td>
                                    </c:if>    
                                    <td>    
                                        <a href="/banhangonlinev4.0/admin/doEdit?action=user&id=${u.id}"><fmt:message key="edit" bundle="${msg}"/></a>
                                    </td>
                                    <td>
                                        <a href ="/banhangonlinev4.0/admin/doUser?action=delete&id=${u.id}"><fmt:message key="delete" bundle="${msg}"/></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
