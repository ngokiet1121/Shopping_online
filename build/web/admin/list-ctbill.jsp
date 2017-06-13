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
                    <h2><fmt:message key="tabledetailbill" bundle="${msg}"/></h2>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>id</th>
                                <th><fmt:message key="bill" bundle="${msg}"/></th>
                                <th><fmt:message key="item" bundle="${msg}"/></th>
                                <th><fmt:message key="number" bundle="${msg}"/></th>
                                <th><fmt:message key="total" bundle="${msg}"/></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <c:forEach var="ct" items="${ctbills}">
                            <tr>
                                <td>
                                    ${ct.id}
                                </td>
                                <td>
                                    ${ct.bill.id}
                                </td>
                                <td>
                                    ${ct.item.id}
                                </td>
                                <td>
                                    ${ct.number}  
                                </td>
                                <td>
                                    ${ct.number*ct.item.price}
                                </td>                          
                            </tr>
                            </c:forEach>
                            </tr>                       
                            <tr>                           
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
