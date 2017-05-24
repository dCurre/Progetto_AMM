<%-- 
    Document   : header
    Created on : Apr 30, 2017, 6:27:10 PM
    Author     : davide
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<header>   
    <div id="divHeader">
        <nav>
            <ol>
                <li id="nerdbook"> NerdBook </li>
                
                <c:choose>
                    <c:when test="${page=='Profilo'}"><li class="indice active"><a href="Profilo">Profilo</a></li></c:when>
                    <c:when test="${page=='Descrizione'}"><li class="indice"><a href="Profilo">Profilo</a></li></c:when>
                    <c:otherwise><li class="indice"><a href="Profilo">Profilo</a></li></c:otherwise>
                </c:choose> 
                <c:choose>
                    <c:when test="${page=='Bacheca'}"><li class="indice active"><a href="Bacheca?utenteBacheca=${userID}">Bacheca</a></li></c:when>
                    <c:when test="${page=='Descrizione'}"><li class="indice"><a href="Bacheca">Bacheca</a></li></c:when>
                    <c:otherwise><li class="indice"><a href="Bacheca?utenteBacheca=${userID}">Bacheca</a></c:otherwise>
                </c:choose> 
                
                <li class="indice">
                    <c:choose>
                        <c:when test="${page=='Descrizione'}">
                            <div class="loginDescrizione"><a href="Login">Login</a></div>
                        </c:when>
                            <c:otherwise> <img src="${listaUtenti.getUserById(userID).getUrlFotoProfilo()}" alt="Foto Profilo">Ciao, ${listaUtenti.getUserById(userID).getNome()}<div> <a href="Login?logout=1">Logout</a></div> </c:otherwise>
                    </c:choose>
                </li>
            </ol>
        </nav>
    </div>
</header>
