<%-- 
    Document   : type
    Created on : Dec 28, 2015, 6:57:31 PM
    Author     : ADMIN
--%>
<%@page import="controller.Controller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="template/head2.jsp" %>    
        <script>
            $(document).ready(function () {
                $("[rel='tooltip']").tooltip();

                $('.thumbnail').hover(
                        function () {
                            $(this).find('.caption').slideDown(250); //.fadeIn(250)
                        },
                        function () {
                            $(this).find('.caption').slideUp(250); //.fadeOut(205)
                        }
                );
            });

        </script>
    </head>
    <body>
        <%@include file="template/header2.jsp" %>
        <%@include file="template/login-register.jsp" %>
        <div class="container">

                <%                    
                    int Idtype = Integer.parseInt(request.getSession().getAttribute("Idtype").toString());
                    Type type = (Type) Controller.controller.findT(Idtype);
                %>
                <div class="col-md-9" style="width:100%; position: relative; left: -120px">
                    <div class="banner2">
                        <img src="img/<%= type.getBanner()%>" alt=""/>
                    </div>
                </div>                 
                    <hr>
            <div class="col-md-9" style="width: 1150px;">
                <div class="row"> 
                    <c:if test="${items != null}">
                        <c:forEach var="item" items="${items}">
                            <c:set var="pos" value="${fn:indexOf (item.img,  ',')}"/>
                            <c:set var="str" value="${fn: substring (item.img, 0, pos)}"/>
                            <div class="col-md-3">
                                <div class="thumbnail">
                                    <div class="caption">
                                        <h4><fmt:message key="product" bundle="${msg}"/> ${item.id}</h4>
                                        <p><fmt:message key="category" bundle="${msg}"/> ${item.type}</p>
                                        <p><fmt:message key="trademark" bundle="${msg}"/> ${item.trademark}</p>
                                        <p><fmt:message key="price" bundle="${msg}"/> ${item.price}</p>
                                        <p><a href="/banhangonlinev4.0/information?id=${item.id}" class="btn btn-danger" rel="tooltip" title="Xem chi tiết">Xem</a></p>
                                    </div>
                                    <img src="img/${str}" alt="Sản phẩm 1">
                                </div>
                            </div> 
                        </c:forEach>
                    </c:if>
                </div>
                <c:if test="${items.size() == 0}">
                    <div class="alert alert-success">
                        Chua co san pham nao
                    </div>
                </c:if>
                <c:if test="${items != null}">
                    <ul class="pagination" style="position: relative; left:45%;">
                        <c:forEach begin="1" end="${noOfPages}" var="i">
                            <c:choose>
                                <c:when test="${currentPage eq i}">
                                    <li class="active"><a href="#">${i}</a></li> 
                                    </c:when>
                                    <c:otherwise>
                                    <li><a href="categories?page=${i}&Idtype=${Idtype}">${i}</a></li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                    </ul>
                </c:if>
            </div>
        </div>
        <%@include file="template/footer.jsp" %>
    </body>
</html>
