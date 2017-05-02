<%-- 
    Document   : leftSideBar
    Created on : May 1, 2017, 12:00:45 PM
    Author     : davide
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="amm.nerdbook.Classi.*"%>
<%@page import="java.util.ArrayList" %>
<c:set var="groupNameList" value='<%= GruppoFactory.getInstance().getNomeGruppo() %>' />
<c:set var="groupPhotoList" value='<%= GruppoFactory.getInstance().getFotoGruppo() %>' />

<div id="leftSideBar">
    <div>
        <input type="text" name="search" id="searchText" placeholder="Search sumthin">
    </div>
    <div id="titlePersona" class="sezioneTitle"> Friend List</div>
    
    ${listaUtenti.getUserById(0).getNome()} asdijasodp
    
    <c:forEach items="${lista}" var="listaATM" varStatus="i">
        
    
        <div class="persona"><img src='../${utente.urlFotoProfilo}'> ${listaATM.getUserById(i)} </div>
    </c:forEach>
    
    <div id="titleGruppo" class="sezioneTitle">Group List</div>
    
    <c:forEach items="${groupNameList}" var="group" varStatus="count">
        <div class="gruppo"><img src='../${groupPhotoList[count.index]}'> ${group} </div>
    </c:forEach>
    
    
</div>
