<%-- 
    Document   : list-sale
    Created on : Jan 4, 2016, 11:13:56 AM
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
            <!--End Header-->
            <!--Left-->
            <!--End Left-->
            <div id="content">
                <div class="row" style="position: relative;left: 20px;width: 1135px;">
                    <h2><fmt:message key="tablesale" bundle="${msg}"/></h2>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th><fmt:message key="startdate" bundle="${msg}"/></th>
                                <th><fmt:message key="enddate" bundle="${msg}"/></th>
                                <th><fmt:message key="sale" bundle="${msg}"/></th>
                                <th><fmt:message key="edit" bundle="${msg}"/></th>
                                <th><fmt:message key="delete" bundle="${msg}"/></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="sale" items="${sales}">
                                <tr>
                                    <td>
                                        ${sale.id}
                                    </td>
                                    <td>
                                        ${sale.ngayBatdau}
                                    </td>
                                    <td>
                                        ${sale.ngayKetThuc}
                                    </td>
                                    <td>
                                        ${sale.sale}$
                                    </td>
                                    <td>
                                        <a href ="/banhangonlinev4.0/admin/doEdit?action=sale&id=${sale.id}"><fmt:message key="edit" bundle="${msg}"/></a>
                                    </td>
                                    <td>
                                        <a href ="/banhangonlinev4.0/admin/doSale?action=delete&id=${sale.id}"><fmt:message key="delete" bundle="${msg}"/></a>
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
