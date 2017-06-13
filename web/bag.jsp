<%-- 
    Document   : bag
    Created on : Dec 29, 2015, 6:10:01 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="template/head2.jsp" %>
    </head>
    <body>
        <%@include file="template/header2.jsp" %>
        <%@include file="template/login-register.jsp" %>

        <h2 class="text-center"><fmt:message key="mybag" bundle="${msg}"/></h2>
        <div class="container">
            <form action="bag" method="post">
                <table id="cart" class="table table-hover table-condensed">
                    <thead>
                        <tr>
                            <th style="width:40%"><fmt:message key="productname" bundle="${msg}"/></th>
                            <th style="width:10%"><fmt:message key="size" bundle="${msg}"/></th>
                            <th style="width:10%"><fmt:message key="price" bundle="${msg}"/></th>
                            <th style="width:8%"><fmt:message key="quantity" bundle="${msg}"/></th>
                            <th style="width:22%" class="text-center"><fmt:message key="monetized" bundle="${msg}"/></th>
                            <th style="width:10%"></th>
                        </tr>
                    </thead>
                    <tbody>

                        <%
                            int totalPrice = 0;
                            if (cookies.length > 1) {
                                for (int i = 1; i < cookies.length; i++) {
                                    Cookie c = cookies[i];
                                    List<String> item = (List<String>) helper.StringTokenizer.stringTokenizer(c.getValue(), "|");
                                    totalPrice += (Integer.parseInt(item.get(3)) * Integer.parseInt(item.get(2)));
                        %>
                        <tr>
                            <td data-th="Product">
                                <div class="row">
                                    <div class="col-sm-2 hidden-xs"><img src="img/<%= item.get(4)%>" alt="Sản phẩm 1" width="100" class="img-responsive"/></div>
                                    <div class="col-sm-10">
                                        <h4 class="nomargin"><fmt:message key="product" bundle="${msg}"/>: <%= item.get(0)%></h4>
                                        <p><fmt:message key="type" bundle="${msg}"/> : <%= item.get(5)%></p>
                                        <p><fmt:message key="trademark" bundle="${msg}"/> : <%= item.get(6)%></p>
                                    </div>
                                </div>
                            </td>
                    <input type="hidden" name="item" value="<%= c.getName()%>" />
                    <input type="hidden" name="id" value="<%= item.get(0)%>" />
                    <input type="hidden" name="size" value="<%= item.get(1)%>" />
                    <input type="hidden" name="number" value="<%= item.get(2)%>" />
                    <input type="hidden" name="price" value="<%= Integer.parseInt(item.get(3)) * Integer.parseInt(item.get(2))%>">
                    <input type="hidden" name="img" value="<%= item.get(4)%>" />
                    <td data-th="Size" style="vertical-align: middle;"><%= item.get(1)%></td>
                    <td data-th="Price" style="vertical-align: middle;"><%= item.get(3)%> đ</td>
                    <td data-th="Quantity" style="vertical-align: middle;"><input type="number" readonly="readonly" class="form-control text-center" value="<%= item.get(2)%>"></td>
                    <td data-th="Subtotal" style="vertical-align: middle; text-align: center"><%= Integer.parseInt(item.get(3)) * Integer.parseInt(item.get(2))%> đ</td>
                    <td class="actions" style="vertical-align: middle;">
                        <a href="remove?action=delete&item=<%= c.getName()%>"><span class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></span></a></td>
                    </tr>
                    <%}
                        }%>
                    </tbody>
                    <tfoot>
                        <tr class="visible-xs">
                            <td class="text-center"><strong>Giảm Giá <%= controller.Controller.grand%>%</strong></td>
                            <td class="text-center"><strong>Tổng <%= totalPrice * (100 - controller.Controller.grand) / 100%> đ</strong></td>
                        </tr>
                        <tr>
                            <td><a href="home.jsp" class="btn btn-warning"><i class="fa fa-angle-left"></i> Tiếp tục mua hàng</a></td>
                    <input type="hidden" name="sale" value="<%= controller.Controller.grand%>" />
                    <td colspan="2" class="hidden-xs"><strong><fmt:message key="sale" bundle="${msg}"/> <%= controller.Controller.grand%>%</strong></td>
                    <td class="hidden-xs text-center"><strong>-----></strong></td>
                    <td class="hidden-xs text-center"><strong><fmt:message key="totalmoney" bundle="${msg}"/> <%= totalPrice * (100 - controller.Controller.grand) / 100%> đ</strong></td>
                    <input type="hidden" name="totalPrice" value="<%= totalPrice * (100 - controller.Controller.grand) / 100%>">
                    <td><input type="submit" class="btn btn-success btn-block" name="action" value="<fmt:message key="checkout" bundle="${msg}"/>"></td>
                    </tr>
                    </tfoot>
                </table>
            </form>
        </div>
        <%@include file="template/footer.jsp" %>
    </body>
</html>
