<%-- 
    Document   : leftSideBar
    Created on : May 1, 2017, 12:00:45 PM
    Author     : davide
--%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="leftSideBar">
    
    <div id="titlePersona" class="sezioneTitle"> Friend List</div>
    <div id="searchBar">
        <input id="searchInput" type="text" placeholder="search fo sum1" value="">
        <button id="searchButton">Cerca</button>
    </div>
    <div id="userList">
        <c:forEach items="${amicizie}" var="i">
            <div class="persona">
                <a href="Bacheca?utenteBacheca=${i}"><img class="profilePic" src='${listaUtenti.getUserById(i).getUrlFotoProfilo()}'>
                    ${listaUtenti.getUserById(i).getNome()} ${listaUtenti.getUserById(i).getCognome()}
                </a>
            </div>
        </c:forEach> 
    </div>
    
    <div id="groupList">
        <div id="titleGruppo" class="sezioneTitle">Group List</div>
        <c:forEach items="${appartenenza}" var="i">
            <div class="gruppo">
                <a href="Bacheca?gruppoBacheca=${i}"><img src='${listaGruppi.getGruppoById(i).getUrlFotoGruppo()}'> ${listaGruppi.getGruppoById(i).getNome()}</a>
            </div>
        </c:forEach> 
    </div>
        
</div>
