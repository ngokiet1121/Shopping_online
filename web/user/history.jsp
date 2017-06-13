<%-- 
    Document   : history
    Created on : Dec 31, 2015, 10:07:14 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../template/head.jsp" %>
        <title>History</title>
    </head>
    <body>
        <%@include file="../template/header2.jsp" %>

        <h2 class="text-center">Hóa Đơn</h2>
        <div class="container">
            <table id="cart" class="table table-hover table-condensed">
                <thead>
                    <tr>
                        <th style="width:20%">Số thứ tự</th>
                        <th style="width:10%">Ngày Đặt</th>
                        <th style="width:10%">Tình trạng</th>
                        <th style="width:8%">Tổng giá</th>
                        <th style="width:20%"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="bill" items="${bills}">
                        <tr>
                            <td data-th="Product">
                                Đơn hàng số ${bill.id}
                            </td>
                            <td  style="vertical-align: middle;">${bill.date} / ${bill.month}/ ${bill.year} </td>
                            <c:if test="${bill.status == 2}">
                                <td  style="vertical-align: middle;">Đã thanh toán</td>       
                            </c:if>
                            <c:if test="${bill.status == 1}">
                                <td  style="vertical-align: middle;">Chua thanh toán</td>       
                            </c:if>
                                <c:if test="${bill.status == 3}">
                                <td  style="vertical-align: middle;">Đã hủy</td>       
                            </c:if>
                            <td  style="vertical-align: middle;">${bill.totalPrice} đ</td>
                            <td class="actions" style="vertical-align: middle;">
                                <c:if test="${bill.status == 2}">
                                    <a href="print?id=${bill.id}"><span class="btn btn-info btn-sm" title="print"><i class="fa fa-print"></i></span></a>       
                                </c:if>
                                    <a href="/banhangonlinev4.0/user/indetail?id=${bill.id}"><span title="infor" class="btn btn-info btn-sm"><i class="fa fa-edit"></i></span></a>
                                    <a href="history?action=delete&id=${bill.id}"><span title="Delete" class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></span></a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <%@include file="../template/footer.jsp" %>
    </body>
</html>
