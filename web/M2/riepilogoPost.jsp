<%-- 
    Document   : riepilogoPost
    Created on : May 12, 2017, 3:13:49 PM
    Author     : davide
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType = "text/html" pageEncoding = "UTF-8" %>
<c:set var="page" value="Riepilogo Post" scope="request"/>
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
                        <c:choose>   
                            <c:when test="${userID == utenteBacheca && groupOrUser == false}">
                               <img src="${listaUtenti.getUserById(userID).getUrlFotoProfilo()}" alt="Foto Profilo"> ${listaUtenti.getUserById(userID).getNome()} 
                            </c:when>
                            <c:when test="${userID != utenteBacheca && groupOrUser == false}">
                                <img src="${listaUtenti.getUserById(userID).getUrlFotoProfilo()}" alt="Foto Profilo"> ${listaUtenti.getUserById(userID).getNome()} 
                                >
                                <img src="${listaUtenti.getUserById(utenteBacheca).getUrlFotoProfilo()}" alt="Foto Profilo"> ${listaUtenti.getUserById(utenteBacheca).getNome()}                            
                            </c:when>
                            <c:when test="${groupOrUser == true}">
                                <img src="${listaUtenti.getUserById(userID).getUrlFotoProfilo()}" alt="Foto Profilo"> ${listaUtenti.getUserById(userID).getNome()} 
                                >
                                <img src="${listaGruppi.getGruppoById(utenteBacheca).getUrlFotoGruppo()}" alt="Foto Profilo"> ${listaGruppi.getGruppoById(utenteBacheca).getNome()}                            
                            </c:when>
                        </c:choose>
                    </div>
                
                    <c:choose>   
                        <c:when test="${ok == 1}">
                            <div id="confermaPost">
                                <div class="validDataWarning">Messaggio inviato, <a href="Bacheca?utenteBacheca=${userID}">torna alla bacheca</a>.</div>
                            </div>
                        </c:when>
                        <c:when test="${ok == 0}">
                            <div class="invalidDataWarning">E' stato riscontrato un errore nell'invio del messaggio, <a href="Bacheca?utenteBacheca=${userID}">torna alla bacheca</a>.</div>
                        </c:when>
                        <c:when test="${ok == null}">
                            <form action="RiepilogoPost?idBacheca=${utenteBacheca}&groupOrUser=${groupOrUser}&addPost=1&text=${testo}&img=${immagine}" method="post">
                                <div id="confermaPost">
                                    <div>
                                        ${testo}
                                    </div>
                                    <div>
                                        <c:if test="${immagine != ''}">
                                            <img src="${immagine}" alt="Immagine Post"> ${immagine}
                                        </c:if>
                                    </div>
                                    <button type="submit">Conferma invio</button>
                                </div>
                            </form>
                        </c:when>
                    </c:choose>
                </div>    
                    
                    
            </div>
            
        </div>
    </body>
</html>
