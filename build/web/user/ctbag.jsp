<%-- 
    Document   : ctbag
    Created on : Dec 31, 2015, 11:31:39 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../template/head.jsp" %>
        <title>Bag</title>
        
    </head>
    <body>
        <%@include file="../template/header2.jsp" %>

        <h2 class="text-center">Chi tiết hóa đơn</h2>
        <div class="container">
            <table id="cart" class="table table-hover table-condensed">
                <thead>
                    <tr>
                        <th style="width:40%">Mã sản phẩm</th>
                        <th style="width:10%">Kích cỡ</th>
                        <th style="width:10%">Giá</th>
                        <th style="width:8%">Số lượng</th>
                        <th style="width:12%" class="text-center">Thành tiền</th>
                        <th style="width:10%"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${ctbills}" var="ctbill">  
                    <tr>
                        <td data-th="Product">
                            <div class="row">
                                <div class="col-sm-2 hidden-xs" ><img src="/banhangonlinev4.0/img/${ctbill.img}" alt="Sản phẩm 1" width="120" class="img-responsive"/></div>
                                <div class="col-sm-10">
                                    <h4 class="nomargin">Sản phẩm ${ctbill.item.id}</h4>
                                    <p>Mô tả của sản phẩm 1</p>
                                </div>
                            </div>
                        </td>
                        <td data-th="Size" style="vertical-align: middle;">${ctbill.size}</td>
                        <td data-th="Price" style="vertical-align: middle;">${ctbill.price}$</td>
                        <td data-th="Quantity" style="vertical-align: middle;">${ctbill.number}</td>
                        <td data-th="Subtotal" class="text-center" style="vertical-align: middle;">${ctbill.number*ctbill.price}$</td>
                        <td class="actions" style="vertical-align: middle;">
                            <button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button></td>
                    </tr> 
                    </c:forEach>  
                </tbody>
            </table>
        </div>
        <%@include file="../template/footer.jsp" %>
    </body>
</html>
