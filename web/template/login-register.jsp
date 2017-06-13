<%-- 
    Document   : login-register
    Created on : Dec 28, 2015, 2:54:03 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>   
    <body>
        <div id="open" class="modalDialog" style="top: 10px;">
            <div style="position: relative; top: 10px;">
                <a href="#close" title="Close" class="close">X</a>
                <div class="row">
                    <div class="alert alert-info" style="border-top-left-radius: 10px;; border-top-right-radius: 10px;">
                        <h2><fmt:message key="register" bundle="${msg}"/></h2>
                    </div>             
                    <form method="post" action="signup">
                        <div class="form-group" >
                            <label for="alpha" style="margin-left: 13px;"><fmt:message key="name" bundle="${msg}"/>:</label><br/>
                            <input class="form-control" id="alpha" type="text" name="username" placeholder="Name" pattern="[a-zA-Z0-9 ]+" required>
                        </div>
                        <div class="form-group" >
                            <label for="alpha" style="margin-left: 13px;"><fmt:message key="address" bundle="${msg}"/>:</label><br/>
                            <input class="form-control" id="alpha" type="text" name="address"  placeholder="Address" pattern="[a-zA-Z0-9 ]+" required>
                        </div>
                        <div class="form-group" >
                            <label for="phonenum" style="margin-left: 13px;"><fmt:message key="phonenumber" bundle="${msg}"/>:</label>
                            <input class="form-control" type="tel" pattern="^\d{10}$" name="phone" required placeholder="Phone" >
                        </div>
                        <div class="form-group" >
                            <label for="alpha" style="margin-left: 13px;">Email:</label>
                            <input id="alpha" type="email" class="form-control" name="email" placeholder="Email" required>
                        </div>
                        <div class="form-group">
                            <label for="alpha" style="margin-left: 13px;">Password:</label>
                            <input type="password" id="alpha" class="form-control" name="password" placeholder="Password" required>
                        </div>
                        <div class="form-group">
                            <label for="alpha" style="margin-left: 13px;"><fmt:message key="confirmpassword" bundle="${msg}"/>:</label>
                            <input type="password" id="alpha" class="form-control" name="comfirmpassword" placeholder="Comfirm password" required>
                        </div>
                        <div class="checkbox">

                        </div>
                        <input type="submit" class="btn btn-primary" name="action" value="<fmt:message key="register" bundle="${msg}"/>">
                    </form>
                </div>
            </div>
        </div>
        <div id="login" class="modalDialog">
            <div>
                <a href="#close" title="Close" class="close">X</a>
                <div class="row">
                    <div class="alert alert-info" style="border-top-left-radius: 10px;; border-top-right-radius: 10px;">
                        <h2><fmt:message key="login" bundle="${msg}"/></h2>
                    </div>
                    <form method="post" action="login">
                        <div class="form-group" >
                            <label for="alpha" style="margin-left: 13px;">Email</label>
                            <input id="alpha" type="email" class="form-control" name="email" placeholder="Email" required>
                        </div>
                        <div class="form-group">
                            <label for="alpha" style="margin-left: 13px;">Password</label>
                            <input type="password" id="alpha" class="form-control" name="password" placeholder="Password" required>
                        </div>
                        <div class="checkbox">
                            <label><a href="#forgot"><fmt:message key="forgotpassword" bundle="${msg}"/></a>/<a href="#open"><fmt:message key="register" bundle="${msg}"/></a></label>
                        </div>
                        <input type="submit" class="btn btn-primary" value="<fmt:message key='login' bundle='${msg}'/>" >
                    </form>
                </div>
            </div>
        </div>
        <div id="forgot" class="modalDialog">
            <div>
                <a href="#close" title="Close" class="close">X</a>
                <div class="row">
                    <div class="alert alert-info" style="border-top-left-radius: 10px;; border-top-right-radius: 10px;">
                        <h2><fmt:message key="forgotpassword" bundle="${msg}"/></h2>
                    </div>
                    <form method="post" action="forgotpassU">
                        <div class="form-group" >
                            <label for="alpha" style="margin-left: 13px;">Email</label>
                            <input id="alpha" type="email" class="form-control" name='email' placeholder="Email" required>
                        </div>
                        <div class="checkbox">
                        </div>
                        <button type="submit" class="btn btn-primary">Send</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
