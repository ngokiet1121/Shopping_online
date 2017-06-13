<%-- 
    Document   : contact
    Created on : Dec 30, 2015, 5:29:40 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <%@include file="template/head2.jsp" %>
        <style>
            .p{
                position: relative;
                left: 400px;
            }
        </style>
    </head>
    <body>
        <%@include file="template/header2.jsp" %>
        <%@include file="template/login-register.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="card">
                        <ul class="nav nav-tabs" role="tablist" id="example-one">
                            <li role="presentation" class="active" > <a href="#first" aria-controls="first" role="tab" data-toggle="tab">Video</a> </li>
                            <li role="presentation" > <a href="#second" aria-controls="second" role="tab" data-toggle="tab"><fmt:message key="technicalguidance" bundle="${msg}"/></a> </li>
                            <li role="presentation" > <a href="#third" aria-controls="third" role="tab" data-toggle="tab"><fmt:message key="monetary/weather" bundle="${msg}"/></a> </li>
                            <li role="presentation"> <a href="#fourth" aria-controls="fourth" role="tab" data-toggle="tab"><fmt:message key="map" bundle="${msg}"/></a> </li>
                        </ul>
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active" id="first">
                                <fmt:message key="contentproductdescription" bundle="${msg}"/>
                            </div>
                            <div role="tabpanel" class="tab-pane " id="second">
                                <a target="_blank" href="https://drive.google.com/file/d/0B4mh5TdvNdW2YjU4Q1BZeEsyTVE/view?usp=sharing"><label><fmt:message key="userguideweb" bundle="${msg}"/></label></a>
                            </div>
                            <div role="tabpanel" class="tab-pane " id="third">
                                <div id="cont_2c6fbe9fca64bd5e24bbeee24c4241f3" class="p"><span id="h_2c6fbe9fca64bd5e24bbeee24c4241f3" ><a id="a_2c6fbe9fca64bd5e24bbeee24c4241f3" href="http://www.yourweather.co.uk/weather_Da+Nang-Asia-Vietnam-Da+Nang-VVDN-1-13266.html" target="_blank" rel="nofollow" style="color:#656565;font-family:Arial;font-size:14px;"><fmt:message key="weather" bundle="${msg}"/> Da Nang</a></span><script type="text/javascript" async src="http://www.yourweather.co.uk/wid_loader/2c6fbe9fca64bd5e24bbeee24c4241f3"></script></div>
                                <div align="center" style="position: relative; left: -300px;top: -253px " ><div align="center" style="margin: 0px; padding: 0px; border: 2px solid rgb(136, 136, 136); width: 195px; background-color: rgb(255, 255, 255);"><div align="center" style="width: 100%; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: rgb(136, 136, 136); margin: 0px; padding: 0px; text-align: center; color: rgb(0, 0, 0); background-color: rgb(160, 192, 48);"><a href="http://fx-rate.net/VND/" style="text-decoration: none; font-size: 14px; font-weight: bold; text-align: center; color: rgb(0, 0, 0);"><img src="http://fx-rate.net/images/countries/vn.png" style="margin: 0px; padding: 0px; border: none;"> Vietnamese Dong Exchange Rate</a></div><script type="text/javascript" src="http://fx-rate.net/fx-rates2.php?label_name=Vietnamese Dong Exchange Rate&lab=1&width=195&currency=VND&cp1_Hex=000000&cp2_Hex=FFFFFF&cp3_Hex=a0c030&hbg=0&flag_code=vn&length=short&label_type=country_name&cp=000000,FFFFFF,a0c030&lang=en"></script></div></div>
                            </div>
                            <div role="tabpanel" class="tab-pane" id="fourth"> 
                                <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d26081603.294420466!2d-95.677068!3d37.06250000000001!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1svi!2s!4v1451471812888" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="template/footer.jsp" %>
    </body>
</html>
