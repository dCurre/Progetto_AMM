<%-- 
    Document   : leftSideBar
    Created on : May 1, 2017, 12:00:45 PM
    Author     : davide
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="leftSideBar">
    <div>
        <input type="text" name="search" id="searchText" placeholder="Search sumthin">
    </div>
    <div id="titlePersona" class="sezioneTitle"> Friend List</div>
    <c:forEach var="i" begin="0" end="${listaUtenti.getArrayListSize()-1}">
        <c:if test="${i != userID}">
            <div class="persona">
                <img src='../${listaUtenti.getUserById(i).getUrlFotoProfilo()}'> ${listaUtenti.getUserById(i).getNome()} ${listaUtenti.getUserById(i).getCognome()}
            </div>
        </c:if>
    </c:forEach>   
    
    <div id="titleGruppo" class="sezioneTitle">Group List</div>
    <c:forEach var="i" begin="0" end="${listaGruppi.getArrayListSize()-1}">
        <div class="gruppo"><img src='../${listaGruppi.getGroupById(i).getUrlFotoGruppo()}'> ${listaGruppi.getGroupById(i).getNome()} </div>
    </c:forEach>
        
        
</div>
