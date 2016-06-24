<%-- 
    Document   : login
    Created on : Jan 10, 2016, 12:06:59 AM
    Author     : amar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UAS Java - Gudang | Login</title>
        
        <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css" />" />
        
        <script src="<c:url value="/assets/js/jquery-1.11.1.min.js" />"></script>
        <script src="<c:url value="/assets/js/bootstrap.min.js" />"></script>
    </head>
    <body>
        <div class="container-fluid" style="margin-top:10%;">
            <div class="col-lg-4 col-lg-offset-4">
                <form id="login-form" class="form-horizontal" action="admin" method="post">
                    <div class="panel panel-success">
                        <div class="panel-heading text-center">
                            <strong>Administrator Login</strong>
                        </div>
                        <div class="panel-body">
                            <div class="form-group">
                                <label class="col-sm-3 text-left">Username</label>
                                <div class="col-sm-9">
                                    <input type="text" name="username" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 text-left">Password</label>
                                <div class="col-sm-9">
                                    <input type="text" name="password" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-9 col-sm-offset-3">
                                    <button type="reset" class="btn btn-danger">Reset</button>
                                    <button type="submit" class="btn btn-primary">Login</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
