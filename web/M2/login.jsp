<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="page" value="Login" scope="request"/>
<!DOCTYPE html>

<html>
    <head>
        <jsp:include page="ripetuti/head.jsp"/>
    </head>
    <body>
        <header>   
            <div id="loginHeader">
                <img src="../img/userImgDefault.png" alt="Foto">NerdBook
            </div>
        </header>
        <div id="divBody">
            <div id="formLogin">
                <c:choose>   
                    <c:when test="${invalidData == true}">
                        <div class="invalidDataWarning" id="loginError">Dati non corretti o inesistenti</div>
                    </c:when>
                    <c:when test="${deleteConfirm == true}">
                        <div class="validDataWarning" id="loginError">Account cancellato con successo</div>
                    </c:when>
                    <c:when test="${deleteConfirm == false && deleteConfirm != null}">
                        <div class="invalidDataWarning" id="loginError">Account non cancellato, e' stato riscontrato un errore</div>
                    </c:when>
                </c:choose>
                
                <form action="Login" method="post">
                    <div class="inputLogin">
                        <label for="user">Username</label>
                        <input type="text" name="username" id="user" required>
                    </div>
                    <div class="inputLogin">
                        <label for="pass">Password</label>
                        <input type="password" name="password" id="pass" required>
                    </div>
                    <div class="inputLogin">
                        <button type="submit" class="buttonConfirm">Login</button>
                    </div>
                </form> 
            </div>
        </div>
    </body>
</html>
