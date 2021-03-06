<%-- 
    Document   : create-sale
    Created on : Jan 4, 2016, 11:14:19 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet prefetch' href='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.css'>
        <%@include file="../template/head.jsp" %>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js'></script>
        <script type="text/javascript">
            $(function () {
                $("#datepicker").datepicker({
                    autoclose: true,
                    //todayHighlight: true
                }).datepicker('update', new Date());
            });
            $(function () {
                $("#datepicker2").datepicker({
                    autoclose: true,
                    todayHighlight: true
                }).datepicker('update', new Date());
            });
        </script>
        <style>
            #datepicker > span:hover{cursor: pointer;}
            #datepicker2 > span:hover{cursor: pointer;}
        </style>
    </head>
    <body>
        <div class="container" style="min-height: 1000px">
            <%@include file="../template/header.jsp" %>
            <form action="doSale" method="post">
                <h2 style="margin-left:400px;"><fmt:message key="createsale" bundle="${msg}"/></h2>
                <div class="row" style="position: relative; left: 25%; width: 500px;">
                    <label><fmt:message key="selectstartdate" bundle="${msg}"/></label>
                    <div id="datepicker" class="input-group date" data-date-format="mm/dd/yyyy">
                        <input class="form-control" name="ngaybatdau" type="text" readonly />
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span> 
                    </div>
                    <label><fmt:message key="selectenddate" bundle="${msg}"/></label>
                    <div id="datepicker2" class="input-group date"  data-date-format="mm/dd/yyyy">
                        <input class="form-control" type="text" name="ngayketthuc" readonly />
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span> 
                    </div>
                    <div class="form-group">
                        <label><fmt:message key="sale" bundle="${msg}"/></label>
                        <input type="text" class="form-control" name="sale" placeholder="Sale">
                    </div>
                    <input type="submit" name="action" value="Create" class="btn btn-primary">
                </div>
            </form>
        </div>
    </body>
</html>
