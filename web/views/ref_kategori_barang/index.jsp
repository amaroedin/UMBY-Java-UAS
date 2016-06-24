<%-- 
    Document   : index
    Created on : Jan 28, 2016, 2:29:58 PM
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
    <li class="active">Kategori Barang</li>
</ol>

<div class="pull-left">
    <a href="/gudang/ref_kategori_barang?action=add" class="btn btn-success"><i class="fa fa-plus"></i> Tambah Data</a>
</div><br><br>

<div class="table-responsive">
    <table class="table table-striped table-hover">
        <thead>
            <tr>
                <th width="30">No</th>
                <th width="100">Aksi</th>
                <th>Nama</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${models}" var="row" varStatus="rows">
            <tr>
                <td><c:out value="${rows.count}"/></td>
                <td>
                    <a href="/gudang/ref_kategori_barang?action=edit&id=<c:out value="${row.getId()}"/>" title="Edit"><i class="fa fa-edit"></i></a>
                    <a href="/gudang/ref_kategori_barang?action=delete&id=<c:out value="${row.getId()}"/>" title="Hapus"><i class="fa fa-trash-o"></i></a>
                </td>
                <td><c:out value="${row.getName()}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>