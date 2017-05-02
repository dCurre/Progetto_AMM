<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="page" value="profilo" scope="request"/>
<!DOCTYPE html>

<html>
    <head>
        <jsp:include page="ripetuti/head.jsp"/>
    </head>
    <body>
        <!--Barra di navigazione tra le pagine del sito + logo + utente logout -->
        <c:set var="page" value="profilo" scope="request"/>
        <jsp:include page="ripetuti/header.jsp"/>
        
        <div id="divBody">
            
            <jsp:include page="ripetuti/leftSideBar.jsp"/>
            
            <div id='datiFormProfilo'>   
                <div id="imgFormProfilo">
                    <img src="../img/fotoLandscapePost.jpg" alt="Foto Profilo">
                </div>
                <form action="bacheca.html" method="post" id="formProfilo">
                    <div class="singoloCampo">    
                        <label for="nome">Nome:</label>
                        <input type="text" name="name" id="nome">
                    </div>
                    <div class="singoloCampo">
                        <label for="cognome">Cognome:</label>
                        <input type="text" name="surname" id="cognome">
                    </div>
                    <div class="singoloCampo">
                        <label for="data">Data di nascita:</label>
                        <input type="date" name="date" id="data">
                    </div>
                    <div class="singoloCampo">
                        <label for="frase">Frase di presentazione:</label>
                        <input type="text" name="frase" id="frase">
                    </div>
                    <div class="singoloCampo">
                        <label for="password">Password:</label>
                        <input type="password" name="pass" id="password" required>
                    </div>
                    <div class="singoloCampo">
                        <label for="confermaPassword">Conferma password:</label>
                        <input type="password" name="confPass" id="confermaPassword" required>
                    </div>
                    <div>
                        <button type="submit" class="buttonConfirm">Aggiorna</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
