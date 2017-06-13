<%-- 
    Document   : information
    Created on : Dec 29, 2015, 7:18:24 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <%@include file="template/head2.jsp" %>
        <style type="text/css">
            .gallery {
                display: inline-block;
                margin-top: 20px;
            }
        </style>
        <script>
            tabSlide();
            $('.nav-tabs li').on('shown.bs.tab', function () {
                $('#magic-line').remove();
                tabSlide();
            });
            function tabSlide() {
                $("#example-one").append("<li id='magic-line'></li>");
                var $magicLine = $("#magic-line");
                $magicLine
                        .width($(".active").width())
                        .css("left", $(".active a").position().left)
                        .data("origLeft", $magicLine.position().left)
                        .data("origWidth", $magicLine.width());
                $("#example-one li").find("a").hover(function () {
                    $el = $(this);
                    leftPos = $el.position().left;
                    newWidth = $el.parent().width();
                    $magicLine.stop().animate({
                        left: leftPos,
                        width: newWidth
                    });
                }, function () {
                    $magicLine.stop().animate({
                        left: $magicLine.data("origLeft"),
                        width: $magicLine.data("origWidth")
                    });
                });
            }

            $(document).ready(function () {
                //https://github.com/fancyapps/fancyBox
                $(".fancybox").fancybox({
                    openEffect: "none",
                    closeEffect: "none"
                });
            });
        </script>
        <script>
            jQuery(document).ready(function () {
                $("#input-21f").rating({
                    starCaptions: function (val) {
                        if (val < 3) {
                            return val;
                        } else {
                            return 'high';
                        }
                    }              
                });

                $('#rating-input').rating({
                    min: 0,
                    max: 5,
                    step: 1,
                    size: 'lg',
                    showClear: false
                });

                $('#btn-rating-input').on('click', function () {
                    $('#rating-input').rating('refresh', {
                        showClear: true,
                        disabled: true
                    });
                });

                $('#rating-input').on('rating.change', function () {
                    alert($('#rating-input').val());
                });
                $('.rb-rating').rating({'showCaption': true, 'stars': '3', 'min': '0', 'max': '3', 'step': '1', 'size': 'xs', 'starCaptions': {0: 'status:nix', 1: 'status:wackelt', 2: 'status:geht', 3: 'status:laeuft'}});
            });
        </script>
        <script src="js/star-rating.js" type="text/javascript"></script>
        <link href="css/star-rating.css" rel="stylesheet" type="text/css" media="all"/>

    </head>
    <body>
        <%@include file="template/header2.jsp" %>
        <%@include file="template/login-register.jsp" %> 
        <c:forTokens items="${item.img}" delims="," var="image">
            <div id="img/${image}" class="modalDialog">        
                <div style="background:  transparent">
                    <a href="#close" title="Close" class="close">X</a>               
                    <img style="width: 370px; height: 550px" src="img/${image}" alt=""/>               
                </div>
            </div> 
        </c:forTokens>
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="card">
                        <ul class="nav nav-tabs" role="tablist" id="example-one">                   
                            <li role="presentation" class="active"> <a href="#first" aria-controls="first" role="tab" data-toggle="tab"><fmt:message key="image" bundle="${msg}"/></a> </li>
                            <li role="presentation"> <a href="#second" aria-controls="second" role="tab" data-toggle="tab"><fmt:message key="informationitems" bundle="${msg}"/></a> </li>
                        </ul>
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active" id="first"> 
                                <div class="row">
                                    <div class='list-group gallery'>
                                        <c:forTokens items="${item.img}" delims="," var="image">
                                            <div class='col-sm-4 col-xs-6 col-md-3 col-lg-3'> <a class="thumbnail fancybox" rel="ligthbox" href="#img/${image}"> <img class="img-responsive" alt="Sản phẩm 1" src="img/${image}" />
                                                </a> </div>
                                            </c:forTokens>
                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane" id="second">
                                <form method="get" action="bag">
                                    <div class="describe">  
                                        <c:set var="pos" value="${fn:indexOf (item.img,  ',')}"/>
                                        <c:set var="str" value="${fn:substring(item.img, 0, pos)}"/>
                                        <div class="hamt">
                                            <img src="/banhangonlinev4.0/img/${str}"/>
                                            <input type="hidden" name="img" value="${str}" />
                                        </div> 
                                    </div>
                                    <div class="information">   
                                        <div class="information2">
                                            <div class="ce" >
                                                <h3><fmt:message key="category" bundle="${msg}"/> : ${item.type}</h3>
                                                <input type="hidden" name="type" value="${item.type}">
                                                <h3><fmt:message key="trademark" bundle="${msg}"/>: ${item.trademark}</h3>
                                                <input type="hidden" name="trademark" value="${item.trademark}">
                                            </div>
                                            <div class="code">
                                                <h3>
                                                    <span><fmt:message key="code" bundle="${msg}"/>: ${item.id}</span>
                                                    <input type="hidden" name="id" value="${item.id}">
                                                </h3>
                                            </div>

                                            <div class="prices">
                                                <span class="price" ><fmt:message key="price" bundle="${msg}"/> : ${item.price}</span>
                                                <input type="hidden" name="price" value="${item.price}">
                                                <span class="price">USD</span>
                                            </div>
                                            <div class="sizeha">  
                                                <input type="button"  id="test1" title="1" value="S" onclick="myFunction1()" class="sizebutton"/>
                                                <input type="button"  id="test2" title="2" value="M" onclick="myFunction2()" class="sizebutton"/>
                                                <input type="button"  id="test3" title="3" value="L" onclick="myFunction3()" class="sizebutton"/>
                                                <input type="button"  id="test4" title="4" value="XL" onclick="myFunction4()" class="sizebutton"/>
                                                <input type="button"  id="test5" title="5" value="XXL" onclick="myFunction5()" class="sizebutton"/>
                                                <input type="button"  id="test6" title="6" value="XXXL" onclick="myFunction6()" class="sizebutton"/>
                                            </div>
                                            <div class="size">
                                                <label style="position: relative;
                                                       bottom: 50px;
                                                       left: -43px;
                                                       margin-top: 60px;"><fmt:message key="sizechoose" bundle="${msg}"/></label>
                                                <input type="text" name="size" readonly="readonly" id="sizeInput" style="width: 80px;"  id="qty" maxlength="15" value="" class="input-text qty">
                                            </div>

                                            <div class="size">
                                                <label style="position: relative; top: -5px; right: 43px;" ><fmt:message key="quantity" bundle="${msg}"/></label>
                                                <input type="text" name="number" style="width: 80px;  "  id="qty" maxlength="15" value="1" class="input-text qty">
                                            </div>

                                            <input type="submit" style="position: relative; top: 60px; background: #4b4b4b" class="btn btn-primary btn-lg btn-block" value="<fmt:message key="addshoppingbag" bundle="${msg}"/>">
                                        </div>                           
                                    </div>
                                </form>
                                <form action="rate" method="get">
                                    <div  class="size" style="position: absolute;
                                          bottom: 50px;
                                          left: 551px;">                          
                                        <input type="hidden" value="${item.id}" name="id">
                                        <h3><input id="input-2" class="rating" data-min="0" data-max="5" data-step="0.1" value="${tong}" name="rate">${tong}/5</h3>                                     
                                    </div>
                                    <input type="submit" style="width: 60px;position: absolute;bottom: 115px;right: 290px; " class="btn btn-default" value="Rate" >
                                </form>                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="template/footer.jsp" %>
    </body>
</html>
