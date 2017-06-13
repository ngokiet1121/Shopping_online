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
                <form method="get" action="searchBill">
                    <div class="row" style="position: relative;left: 20px;width: 1135px;">
                        <h2><fmt:message key="tablebill" bundle="${msg}"/></h2>
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Email</th>
                                    <th><fmt:message key="date" bundle="${msg}"/></th>
                                    <th><fmt:message key="totalprice" bundle="${msg}"/></th>
                                    <th><fmt:message key="status" bundle="${msg}"/></th>
                                    <th><fmt:message key="sale" bundle="${msg}"/></th>
                                    <th><fmt:message key="detailbill" bundle="${msg}"/></th>
                                    <th><fmt:message key="edit" bundle="${msg}"/></th>
                                    <th>Cancel</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <c:forEach var="bill" items="${bills}">
                                    <tr>
                                        <td>
                                            ${bill.id}
                                        </td>
                                        <td>
                                            ${bill.user.email}
                                        </td>
                                        <td>
                                            ${bill.date}/${bill.month}/${bill.year}
                                            <input type="hidden" name="date" value="${bill.month}">
                                        </td>
                                        <td>
                                            ${bill.totalPrice}$
                                        </td>
                                        <td>
                                            <c:if test="${bill.status == 1}">
                                                Waiting
                                            </c:if>
                                            <c:if test="${bill.status == 2}">
                                                Done
                                            </c:if>
                                            <c:if test="${bill.status == 3}">
                                                Cancel
                                            </c:if>
                                        </td>
                                        <td>
                                            ${bill.sale} %
                                        </td>
                                        <td>    
                                            <a href="/banhangonlinev4.0/admin/doEdit?action=bill&id=${bill.id}"><fmt:message key="detailbill" bundle="${msg}"/></a>
                                        </td>
                                        <td>
                                            <a href ="/banhangonlinev4.0/admin/doEdit?action=billedit&id=${bill.id}"><fmt:message key="edit" bundle="${msg}"/></a>
                                        </td>
                                        <td>
                                            <a href ="/banhangonlinev4.0/admin/doBill?action=cancel&id=${bill.id}">Cancel</a>
                                        </td>
                                    </tr> 
                                </c:forEach>
                                </tr>                                                 
                            </tbody>
                        </table>
                        <div class="row" >
                            <div class="form-inline">
                                <div class="form-group">
                                    <label>Select Month</label>
                                    <select class="form-control" name="month" id="sel1">
                                        <option value="0">----Month----</option>
                                        <c:forEach var="m" begin="1" end="12">                                                                                              
                                            <option value="${m}">----${m}----</option>
                                        </c:forEach>   
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Select Month</label>
                                    <select class="form-control" name="year" id="sel1">
                                        <option value="0">----Year----</option>
                                        <c:forEach var="y" begin="2000" end="2100">                                                                                              
                                            <option value="${y}">----${y}----</option>
                                        </c:forEach>   
                                    </select>
                                </div>
                            </div>
                            <input type="submit" name="action" value="Find" class="btn btn-primary">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
