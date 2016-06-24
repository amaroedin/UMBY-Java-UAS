<%-- 
    Document   : form
    Created on : Jan 28, 2016, 2:30:11 PM
    Author     : amar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>

<ol class="breadcrumb">
    <li><a href="/gudang/dashboard"><i class="fa fa-dashboard"></i> Dashboard</a></li>
    <li><a href="#">Referensi</a></li>
    <li><a href="/gudang/ref_jenis_barang">Kategori Barang</a></li>
    <li class="active"><%=(String) request.getAttribute("actionName")%> Kategori Barang</li>
</ol>

<div class="pull-right">
    <a href="/gudang/ref_kategori_barang" class="btn btn-default"><i class="fa fa-arrow-left"></i> Kembali</a>
</div><br><br>

<div class="panel panel-success">
    <div class="panel-heading">
        <h3 class="panel-title"><strong>Form Kategori Barang</strong></h3>
    </div>
    <div class="panel-body">
        <form method="post" action='ref_kategori_barang' name="form-kategori-barang" id="myForm" class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">Nama</label>
                <div class="col-sm-8">
                    <input type="text" name="nama" id="nama" class="form-control" value="<c:out value="${model.getName()}" />" required>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="hidden" name="id" value="<c:out value="${model.getId()}" />">
                    <button type="reset" class="btn btn-danger">Batal</button>
                    <button type="submit" class="btn btn-primary">Simpan</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script>
    $("#myForm").validate();
</script>
