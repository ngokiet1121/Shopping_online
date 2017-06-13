<%-- 
    Document   : header2
    Created on : Dec 20, 2015, 8:59:32 PM
    Author     : ADMIN
--%>

<%@page import="models.Banner"%>
<%@page import="models.Trademark"%>
<%@page import="models.Type"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <fmt:setLocale value="${sessionScope.locale}"/>
        <fmt:setBundle basename="message" var="msg"/>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" target="_blank" href="/banhangonlinev4.0/login-admin.jsp"><img style="width: 25px;" src="/banhangonlinev4.0/img/Lock-icon.png" alt=""/></a>
                    <a class="navbar-brand" href="/banhangonlinev4.0/home.jsp"><fmt:message key="shoppingonline" bundle="${msg}"/></a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="/banhangonlinev4.0/collection?action=search"><fmt:message key="search" bundle="${msg}"/></a>
                        </li>
                        <li>
                            <a href="/banhangonlinev4.0/contact.jsp"><fmt:message key="contactus" bundle="${msg}"/></a>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="category" bundle="${msg}"/><b class="caret"></b></a>
                                <% List<Type> types = (List<Type>) controller.Controller.controller.findType(); %>
                            <ul class="dropdown-menu">
                                <%
                                    if (types != null) {                       
                                        for (Type t : types) {                                           
                                %>
                                <li><a href="/banhangonlinev4.0/categories?Idtype=<%= t.getId()%>"><%= t.getType()%></a></li>
                                    <%}
                                    }%>
                                <li class="divider"></li>
                            </ul>
                        </li>                               
                    </ul>
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="trademark" bundle="${msg}"/><b class="caret"></b></a>
                                <% List<Trademark> tras = (List<Trademark>) controller.Controller.controller.findTrademark(); %>
                            <ul class="dropdown-menu">
                                <%
                                    if (tras != null) {
                                        for (Trademark t : tras) {
                                %>
                                <li><a href="/banhangonlinev4.0/trademark?idTra=<%= t.getId()%>"><%= t.getTrademark()%></a></li>

                                <%}
                                }%>
                                <li class="divider"></li>
                            </ul>
                        </li>                               
                    </ul>
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="language" bundle="${msg}"/><b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/banhangonlinev4.0/ChooseLang?lang=vi&url=${pageContext.request.requestURL}"><fmt:message key="vietnam" bundle="${msg}"/></a></li>
                                <li><a href="/banhangonlinev4.0/ChooseLang?lang=en&url=${pageContext.request.requestURL}"><fmt:message key="english" bundle="${msg}"/></a></li>
                                <li class="divider"></li>
                            </ul>
                        </li>                               
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <%
                                int cookieId = 0;
                                Cookie[] cookies = request.getCookies();
                                if (cookies.length > 1) {
                                    cookieId = cookies.length;
                            %>
                            <a href="/banhangonlinev4.0/bag.jsp" class="glyphicon glyphicon-shopping-cart" title="<%= cookieId - 1%>"></a>
                            <%} else {%>
                            <a href="/banhangonlinev4.0/bag.jsp" class="glyphicon glyphicon-shopping-cart" title="0"></a>
                            <%}%>
                        </li>
                        <c:if test="${user == null}" >
                            <li><a href="#login" ><fmt:message key="login" bundle="${msg}"/></a></li>
                            <li><a href="#open" ><fmt:message key="register" bundle="${msg}"/></a></li>
                            </c:if>
                            <c:if test="${user != null}" >
                            <li><a href="/banhangonlinev4.0/user/account.jsp"><img style="width: 20px; height:20px;" src="/banhangonlinev4.0/img/${user.img}" alt=""/></a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">${user.userName}<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="/banhangonlinev4.0/user/account.jsp">Account</a></li>
                                    <li><a href="/banhangonlinev4.0/user/history"><fmt:message key="history" bundle="${msg}"/></a></li>
                                    <li><a href="/banhangonlinev4.0/logout">Logout</a></li>
                                    <li class="divider"></li>
                                </ul>
                            </li>
                        </c:if>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->

        </nav>
        <%
            List<Banner> banners = (List<Banner>) controller.Controller.controller.findBanner();
        %>
    </body>
</html>
