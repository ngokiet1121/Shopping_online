<%-- 
    Document   : header
    Created on : Dec 20, 2015, 10:39:41 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="message" var="msg"/>
    <div id="header">
        <h2 class="text-center">Admin Home Shopping Online</h2>
        <!--Header-->
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="admin.jsp">ADMIN</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="/banhangonlinev4.0/home.jsp">Home</a></li>   
                        <li><a href="/banhangonlinev4.0/admin/doShop">Shop</a></li>         
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="user" bundle="${msg}"/> <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/banhangonlinev4.0/admin/doUser"><fmt:message key="viewlist" bundle="${msg}"/></a></li>
                                <li><a href="/banhangonlinev4.0/admin/create-user.jsp"><fmt:message key="create" bundle="${msg}"/></a></li>
                                <li class="divider"></li>
                                <!--
                                <li><a href="#">Separated link</a></li>
                                <li class="divider"></li>
                                <li><a href="#">One more separated link</a></li>
                                -->
                            </ul>
                        </li>                              
                    </ul>
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="item" bundle="${msg}"/> <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/banhangonlinev4.0/admin/doItem"><fmt:message key="viewlist" bundle="${msg}"/></a></li>
                                <li><a href="/banhangonlinev4.0/admin/doItem?action=Create"><fmt:message key="create" bundle="${msg}"/></a></li>
                                <li class="divider"></li>
                            </ul>
                        </li>                               
                    </ul>
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="trademark" bundle="${msg}"/> <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/banhangonlinev4.0/admin/doTra"><fmt:message key="viewlist" bundle="${msg}"/></a></li>
                                <li><a href="/banhangonlinev4.0/admin/create-trademark.jsp"><fmt:message key="create" bundle="${msg}"/></a></li>
                                <li class="divider"></li>
                            </ul>
                        </li>                               
                    </ul>
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="bill" bundle="${msg}"/> <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/banhangonlinev4.0/admin/doBill"><fmt:message key="viewlist" bundle="${msg}"/></a></li>
                                <li class="divider"></li>
                            </ul>
                        </li>                               
                    </ul>
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Banner<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/banhangonlinev4.0/admin/doBanner"><fmt:message key="viewlist" bundle="${msg}"/></a></li>
                                <li><a href="/banhangonlinev4.0/admin/create-banner.jsp"><fmt:message key="create" bundle="${msg}"/></a></li>
                                <li class="divider"></li>
                            </ul>
                        </li>                               
                    </ul>
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="sale" bundle="${msg}"/><b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/banhangonlinev4.0/admin/doSale"><fmt:message key="viewlist" bundle="${msg}"/></a></li>
                                <li><a href="/banhangonlinev4.0/admin/create-sale.jsp"><fmt:message key="create" bundle="${msg}"/></a></li>
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
                    <c:if test="${admin != null}" >
                        <ul class="nav navbar-nav navbar-right">
                            <li class="dropdown">
                                <a href="" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="hello" bundle="${msg}"/> ${admin.name}<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="/banhangonlinev4.0/admin/changepass.jsp"><fmt:message key="changepass" bundle="${msg}"/></a></li>
                                    <li><a href="/banhangonlinev4.0/admin/changeInfor.jsp"><fmt:message key="changeInformation" bundle="${msg}"/></a></li>
                                    <li><a href="/banhangonlinev4.0/logout">Logout</a></li>
                                    <li class="divider"></li>
                                </ul>
                            </li> 
                        </ul>
                    </c:if>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </div>

</html>
