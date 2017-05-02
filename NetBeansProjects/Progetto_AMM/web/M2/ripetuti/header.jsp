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
                <li <c:choose>
                        <c:when test="${page=='profilo'}"> class="indice active" </c:when>
                        <c:otherwise> class="indice"> </c:otherwise>
                    </c:choose> 
                    <a href="Profilo">Profilo</a>
                </li>
                <li <c:choose>
                        <c:when test="${page=='bacheca'}"> class="indice active" </c:when>
                        <c:otherwise> class="indice"> </c:otherwise>
                    </c:choose> 
                    <a href="Bacheca">Bacheca</a>
                </li>
                
                <li class="indice"><img src="../${listaUtenti.getUserById(userID).getUrlFotoProfilo()}" alt="Foto Profilo">Ciao, ${listaUtenti.getUserById(userID).getNome()}<div class="aCapo"> <a href="login.jsp">Logout</a></div></li>
            </ol>
        </nav>
    </div>
</header>
