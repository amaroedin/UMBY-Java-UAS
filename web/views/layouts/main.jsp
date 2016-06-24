<%-- 
    Document   : main
    Created on : Jan 10, 2016, 1:51:24 AM
    Author     : amar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UAS Java - Gudang | <%=(String)request.getAttribute("title")%></title>
        
        <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css" />" />
        <link rel="stylesheet" href="<c:url value="/assets/css/styles.css" />" />
        
        <script src="<c:url value="/assets/js/jquery-1.11.1.min.js" />"></script>
        <script src="<c:url value="/assets/js/bootstrap.min.js" />"></script>
        <script src="<c:url value="/assets/js/application.js" />"></script>
        <script src="<c:url value="/assets/js/jquery.validate.min.js" />"></script>
        
        <!-- Plugins -->
        <link rel="stylesheet" href="<c:url value="/assets/plugins/font-awesome/css/font-awesome.min.css" />" />
    </head>
    <body>
        <div id="wrapper">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Sistem Informasi Gudang (SIDang)</a>
                </div>
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <!-- Side-navbar -->
                    <ul class="nav navbar-nav side-nav">
                        <li class="active">
                            <a href="/gudang/dashboard"><i class="fa fa-dashboard"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="/gudang/master_barang"><i class="fa fa-archive"></i> Master Barang</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-book"></i> Referensi <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/gudang/ref_satuan_barang">Satuan</a></li>
                                <li><a href="/gudang/ref_jenis_barang">Jenis Barang</a></li>
                                <li><a href="/gudang/ref_kategori_barang">Kategori Barang</a></li>
                            </ul>
                        </li>
                    </ul>
                    <!-- Top-navbar -->
                    <ul class="nav navbar-nav navbar-right">
                      <li class="dropdown">
                          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                              Administrator <i class="fa fa-user fa-fw"></i>
                              <i class="fa fa-caret-down"></i>
                          </a>
                          <ul class="dropdown-menu dropdown-user">
                            <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a></li>
                          </ul>
                      </li>
                    </ul>
                </div>
            </nav>
            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <%String content = (String)request.getAttribute("content"); %>
                        <jsp:include page="<%= content%>" />
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
