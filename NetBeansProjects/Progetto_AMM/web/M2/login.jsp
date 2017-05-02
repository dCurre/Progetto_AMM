<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="page" value="login" scope="request"/>
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
                <c:if test="${invalidData == true}">
                    <div id="invalidDataWarning">Errore: dati inseriti non corretti!</div>
                </c:if>
                
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
