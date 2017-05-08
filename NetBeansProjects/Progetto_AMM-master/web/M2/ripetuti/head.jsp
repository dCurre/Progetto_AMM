<%-- 
    Document   : head
    Created on : May 1, 2017, 11:27:36 AM
    Author     : davide
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:choose>
    <c:when test="${page == 'bacheca'}"><title> NerdBook - Bacheca </title></c:when>
    <c:when test="${page == 'profilo'}"><title> NerdBook - Profilo </title></c:when>
    <c:when test="${page == 'descrizione'}"><title> NerdBook - Descrizione </title></c:when>
    <c:when test="${page == 'login'}"><title> NerdBook - Login </title></c:when>
</c:choose>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Davide Curreli">
<meta name="keywords" content="social nerd nerdbook amici boh">
<link rel="stylesheet" type="text/css" href="/Progetto_AMM/M2/style.css" media="screen">