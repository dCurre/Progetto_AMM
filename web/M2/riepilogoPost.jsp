<%-- 
    Document   : riepilogoPost
    Created on : May 12, 2017, 3:13:49 PM
    Author     : davide
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType = "text/html" pageEncoding = "UTF-8" %>
<c:set var="page" value="riepilogoPost" scope="request"/>
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
                        <c:if test="${userID == utenteBacheca}">
                            <img src="${listaUtenti.getUserById(userID).getUrlFotoProfilo()}" alt="Foto Profilo"> ${listaUtenti.getUserById(userID).getNome()} 
                        </c:if>
                        <c:if test="${userID != utenteBacheca}">
                            <img src="${listaUtenti.getUserById(userID).getUrlFotoProfilo()}" alt="Foto Profilo"> ${listaUtenti.getUserById(userID).getNome()} 
                            >
                            <img src="${listaUtenti.getUserById(utenteBacheca).getUrlFotoProfilo()}" alt="Foto Profilo"> ${listaUtenti.getUserById(utenteBacheca).getNome()}                            
                        </c:if>
                    </div>
                </div>
                <c:if test="${ok == 1}">
                    Messaggio inviato!
                    ${prova}
                    <a href="Bacheca?utenteBacheca=${userID}">Torna alla bacheca</a>
                </c:if>
                <c:if test="${ok == null}">
                    <form action="RiepilogoPost?utenteBacheca=${utenteBacheca}&addPost=1&text=${testo}&img=${immagine}" method="post">
                        <div id="confermaPost">
                            <div>
                                ${testo}
                            </div>
                            <div>
                                <img src="${immagine}" alt="Immagine Post"> ${immagine}
                            </div>
                            <button type="submit">Conferma invio</button>
                        </div>
                    </form>
                </c:if>
                    
                    
                    
            </div>
            
        </div>
    </body>
</html>
