<%-- 
    Document   : footer
    Created on : Dec 20, 2015, 9:00:14 PM
    Author     : ADMIN
--%>

<%@page import="models.Shop"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <hr>
        <div class="container">         
            <!-- Footer -->
            <footer>
                <div class="row" style="position: relative;
                     right: 50px; top: -30px">
                    <form class="form-horizontal" action="send" method="post" role="form">
                        <div class="alert alert-info" style="width: 680px; position: relative;  left:  100px;"> 
                            <fmt:message key="sendtightenyoureyestous.wewillrespondassoonaspossible" bundle="${msg}"/>
                        </div> 
                        <div class="form-group" style="width: 680px; position: relative;  left:  100px;">
                            <div class="col-sm-10">
                                <input style="width: 680px;" id="alpha" required type="email" class="form-control" id="inputEmail3" placeholder="Email">
                            </div>
                        </div>
                        <div class="form-group" style="width: 680px; position: relative;  left:  100px;">
                            <div class="col-sm-10">
                                <input style="width: 680px;" id="alpha" required type="password" class="form-control" id="inputPassword3" placeholder="Password">
                            </div>
                        </div>
                        <div class="form-group" style="width: 680px; position: relative;  left:  100px;">
                            <textarea id="alpha" required style="width: 680px; position: relative;
                                      left:  15px;" class="form-control" placeholder="<fmt:message key="content" bundle="${msg}"/>" rows="3"></textarea>
                        </div>

                        <div class="form-group" style=" position: relative;  left:  -100px;">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default"><fmt:message key="send" bundle="${msg}"/></button>
                            </div>
                        </div>
                    </form>
                    <%
                        Shop shop = (Shop) controller.Controller.controller.findShop(1);
                    %>
                </div>
                <div class="alert alert-info" style="width: 350px;height: 245px; margin-top: -338px;margin-left: 760px;">
                    <label4><%= shop.getName()%></label4>
                    <br><label4><%= shop.getAddress()%></label4>
                    <br><label4>Phone : <%= shop.getPhone()%></label4>
                    <br><label4>Email : <%= shop.getEmail()%></label4>                 
                </div>
            </footer>
        </div>
    </body>
</html>
