<%-- 
    Document   : home
    Created on : Dec 15, 2015, 3:55:10 PM
    Author     : ADMIN
--%>

<%@page import="controller.Controller"%>
<%@page import="models.Banner"%>
<%@page import="java.util.List"%>
<%@page import="dao.TypeDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="template/head2.jsp" %>
        
       
        <script language="JavaScript" type="text/javascript">
            function login(showhide) {
                if (showhide == "show") {
                    document.getElementById('popupbox').style.visibility = "visible";
                } else if (showhide == "hide") {
                    document.getElementById('popupbox').style.visibility = "hidden";
                }
            }

            function register(showhide) {
                if (showhide == "show") {
                    document.getElementById('popupbox').style.visibility = "visible";
                } else if (showhide == "hide") {
                    document.getElementById('popupbox').style.visibility = "hidden";
                }
            }
        </script>
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
        <style>
            #margin{                   
                width: 260px; margin-left: 18px;
            } 
            .type{
                float: left;
                margin-left: 17px;
                margin-top: 16px;
            }
            .type img {
                width: 360px;
            }
        </style>
    </head>
    <body>
        <%@include file="template/header2.jsp" %>
        <%@include file="template/login-register.jsp" %>
        <!-- Page Content -->
        <div class="container">
            <div class="col-md-9" style="width: 1150px;">               
                <div class="banner">
                    <img name="myimage" src="img/<%= banners.get(1).getBanner()%>" alt=""/>
                    <h1><marquee align="center" direction="left" height="50" scrollamount="4" width="20%" behavior="alternate">
                            <% if (Controller.controller.sale()) {
                                    if (Controller.grand != 0) {
                            %>
                            Sale <%= Controller.grand%> %
                            <%}
                                }%>
                        </marquee></h1>
                </div>
                        <div class="alert alert-success" style="font-size:35px"> 
                    <fmt:message key="category" bundle="${msg}"/>
                </div>
                <div class="row">
                    <%
                        if (types != null) {
                            for (Type t : types) {
                    %>
                    <div class="type">
                        <a href="<%=request.getContextPath()%>/categories?Idtype=<%= t.getId()%>">
                            <img src="img/<%= t.getImg()%>">
                        </a>
                    </div>
                    <%}%>
                    <%}%> 

                </div>
            </div>
        </div>
    </div>
    <!-- /.container -->   
    <%@include file="template/footer.jsp" %>
</body>
</body>
</html>
