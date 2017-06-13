<%-- 
    Document   : account
    Created on : Dec 30, 2015, 6:59:17 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../template/head.jsp" %>
        <title>Account</title>
        <style>
            #c{
                width: 400px;
                margin: 0 auto;
            }
            .h2 {
                position: relative;
                left: 95px;
            }
        </style>
        <script src="../js/js.js" type="text/javascript"></script>

    </head>
    <body>
        <%@include file="../template/header2.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="card">
                        <ul class="nav nav-tabs" role="tablist" id="example-one">
                            <li role="presentation" class="active" > <a href="#first" aria-controls="first" role="tab" data-toggle="tab">Thông tin người dùng</a> </li>
                            <li role="presentation" > <a href="#second" aria-controls="second" role="tab" data-toggle="tab">Thay đổi thông tin cá nhân</a> </li>
                        </ul>
                        <div class="tab-content ">
                            <div role="tabpanel" class="tab-pane active " id="first">
                                <form action="avatar" method="POST" enctype="multipart/form-data">
                                    <div class="row" style="width: 50%;">
                                        <c:if test="${user.img != null}">
                                            <img style=" width: 200px;height: 200px; position: relative; left: 100px;" src="../img/${user.img}" alt=""/>
                                        </c:if>
                                        <c:if test="${user.img == null}">
                                            <img style=" width: 200px;height: 200px; position: relative; left: 100px;" src="" alt=""/>
                                        </c:if>
                                        <input style="margin-left: 100px" name="img" type="file" multiple>

                                        <input style="background: #4b4b4b; margin-left: 100px;" name="" value="Add Your Avatar" class="btn btn-primary" type="submit">
                                    </div>
                                </form>
                                <div class="row" style="width: 50%; position: absolute; right: 20px; top: 41px;">
                                    <hr>
                                    <strong><fmt:message key="name" bundle="${msg}"/>    : ${user.userName}</strong><br><hr>
                                    <strong>Email   : ${user.email}</strong><br><hr>
                                    <strong><fmt:message key="phone" bundle="${msg}"/>   : ${user.phone}</strong><br><hr>
                                    <strong><fmt:message key="address" bundle="${msg}"/> : ${user.address}</strong><br><hr>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane" id="second">                      
                                <div class="row" style="width: 50%;">
                                    <form method="post" action="changeinfor">
                                        <h2 class="h2" ><fmt:message key="changeInformation" bundle="${msg}"/></h2>
                                        <div class="form-group" id="c">
                                            <label>Email</label>
                                            <input type="email" readonly="readonly" class="form-control" name="email" value="${user.email}" placeholder="Email">
                                        </div>
                                        <div class="form-group"id="c">
                                            <label><fmt:message key="password" bundle="${msg}"/></label>
                                            <input type="password" readonly="readonly" class="form-control" name="password" value="${user.password}" placeholder="Password">
                                        </div>
                                        <div class="form-group"id="c">
                                            <label for="alpla"><fmt:message key="name" bundle="${msg}"/></label>
                                            <input id="alpha" type="text" class="form-control" placeholder="Name" name="username" value="${user.userName}" pattern="[a-zA-Z0-9]+" required>
                                        </div>
                                        <div class="form-group"id="c">
                                            <label for="alpha"><fmt:message key="address" bundle="${msg}"/></label>
                                            <input type="text" id="alpha" class="form-control" placeholder="Address" name="address" value="${user.address}" pattern="[a-zA-Z0-9 ]+" required>
                                        </div> 
                                        <div class="form-group"id="c">
                                            <label for="alpha"><fmt:message key="phone" bundle="${msg}"/></label>
                                            <input type="text" id="alpha" class="form-control" placeholder="Phone" name="phone" value="${user.phone}" pattern="[a-zA-Z0-9]+" required>
                                        </div> 
                                        <input style="position: relative; left: 14px; top: 10px" type="submit" name="action" value="change" class="btn btn-primary">
                                    </form>
                                </div>
                                <div class="row" style="width: 50%; position: absolute; top:61px;left: 469px">
                                    <form method="post" action="changepass">
                                        <h2 class="h2"><fmt:message key="changepass" bundle="${msg}"/></h2>
                                        <div class="form-group"id="c">
                                            <label for="alpha"><fmt:message key="password" bundle="${msg}"/></label>
                                            <input id="alpha" type="password"  class="form-control" name="password" placeholder="Password" pattern="[a-zA-Z0-9]+" required>
                                        </div>
                                        <div class="form-group"id="c">
                                            <label for="alpha"><fmt:message key="newpassword" bundle="${msg}"/></label>
                                            <input id="alpha" type="password" class="form-control" name="new_password" placeholder="New_Password" pattern="[a-zA-Z0-9]+" required>
                                        </div>
                                        <div class="form-group"id="c">
                                            <label for="alpha"><fmt:message key="comfirmpassword" bundle="${msg}"/></label>
                                            <input id="alpha" type="password" class="form-control" name="confirm_password" placeholder="confirm_password" pattern="[a-zA-Z0-9]+" required>
                                        </div>
                                        <input style="position: relative; left: 25px; top: 10px" type="submit" name="action" value="change" class="btn btn-primary">
                                    </form>
                                </div>
                                                             
                            </div>                           
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../template/footer.jsp" %>
    </body>
</html>
