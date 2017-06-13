<%-- 
    Document   : search
    Created on : Dec 28, 2015, 3:35:18 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="template/head2.jsp" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <div class="col-md-9" style="width: 1150px;">
                <div class="row">
                    <h2 style="margin-left: 20px;"><fmt:message key="search" bundle="${msg}"/></h2>
                    <form class="form-inline" method="get" action="search"  role="form">
                        <div class="form-group" style="margin-left: 20px;">
                            <label><fmt:message key="selectcategory" bundle="${msg}"/>:</label>
                            <select name="Idtype" class="form-control"  style="width: 300px; " id="sel1">
                                <option value="0"><fmt:message key="category" bundle="${msg}"/></option>
                                <c:if test="${types!= null}">
                                    <c:forEach var="t" items="${types}">
                                        <option value="${t.id}">${t.type}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                        <div class="form-group" style="margin-left: 20px;">
                            <label><fmt:message key="selecttrademark" bundle="${msg}"/>:</label>
                            <select name="idtrademark" class="form-control"  style="width: 300px;" id="sel1">
                                <c:if test="${tras!= null}">
                                    <option value="0"><fmt:message key="trademark" bundle="${msg}"/></option>
                                    <c:forEach var="t" items="${tras}">
                                        <option value="${t.id}">${t.trademark}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                        <input type="submit"  style="width: 100px; margin-left: 20px;" name="action" value="<fmt:message key="search" bundle="${msg}"/>" class="btn btn-default">
                    </form>
                </div>
            </div>
        </div>
        <hr/>
        <div class="container">
            <div class="col-md-9" style="width: 1150px;">
                <div class="row"> 
                    <c:if test="${searchItems != null}">
                        <c:forEach var="item" items="${searchItems}">
                            <c:set var="pos" value="${fn:indexOf (item.img,  ',')}"/>
                            <c:set var="str" value="${fn: substring (item.img, 0, pos)}"/>
                            <div class="col-md-3">
                                <div class="thumbnail">
                                    <div class="caption">
                                        <h4><fmt:message key="product" bundle="${msg}"/>: ${item.id}</h4>
                                        <p><fmt:message key="category" bundle="${msg}"/>: ${item.type}</p>
                                        <p><fmt:message key="trademark" bundle="${msg}"/>: ${item.trademark}</p>
                                        <p><fmt:message key="price" bundle="${msg}"/>:${item.price}</p>
                                        <p><a href="/banhangonlinev4.0/information?id=${item.id}" class="btn btn-danger" rel="tooltip" title="<fmt:message key="viewmore" bundle="${msg}"/>"><fmt:message key="view" bundle="${msg}"/></a></p>
                                    </div>
                                    <img src="img/${str}" alt="Sản phẩm 1">
                                </div>
                            </div> 
                        </c:forEach>
                    </c:if>
                </div>            
            </div>
        </div>
        <%@include file="template/footer.jsp" %>
    </body>
</html>
