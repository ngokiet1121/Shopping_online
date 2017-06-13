<%-- 
    Document   : admin
    Created on : Dec 15, 2015, 3:54:03 PM
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
                    <h2><fmt:message key="pageadmin" bundle="${msg}"/></h2>
                    <a target="_blank" href="https://drive.google.com/file/d/0B4mh5TdvNdW2ZWwwZXdqTXh0cVk/view?usp=sharing">Hướng dẫn sử dụng admin</a>
                </div>
            </div>
        </div>
    </body>
</html>
