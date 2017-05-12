<%-- 
    Document   : riepilogoPost
    Created on : May 12, 2017, 3:13:49 PM
    Author     : davide
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType = "text/html" pageEncoding = "UTF-8" %>
<c:set var="page" value="bacheca" scope="request"/>
<c:set var="log" value="${userID}" scope="request"/>
<!DOCTYPE html>

<html>
    <head>
        <jsp:include page="ripetuti/head.jsp"/>
    </head>
    <body>
        <jsp:include page="ripetuti/header.jsp"/>
        <div id="divBody">
            <jsp:include page="ripetuti/leftSideBar.jsp"/>
            <div id="divContent">
                <div id="riepilogoPost">
                    <div id="fromTo">
                        <img src="${listaUtenti.getUserById(userID).getUrlFotoProfilo()}" alt="Foto Profilo"> ${listaUtenti.getUserById(userID).getNome()}
                        > <img src="${utente.getUrlFotoProfilo()}" alt="Foto Profilo"> ${utente.nome}
                    </div>
                    <div id="msgRiepilogato">
                        <c:if test="${radio == 'textType'}">
                              ${testo}
                        </c:if>
                        <c:if test="${radio == 'imgType'}">
                              ${immagine}
                        </c:if>
                    </div>
                    
                </div>
            </div>
            
        </div>
    </body>
</html>
