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
                
                <c:if test="${nullData == true}">
                    <div class="invalidDataWarning">ERRORE: alcuni campi dell'utente non sono stati impostati!</div>
                </c:if>
                <c:if test="${wrongPass == true}">
                    <div class="invalidDataWarning">ERRORE: conferma della password non corretta!</div>
                </c:if>
                
                <div id="imgFormProfilo">
                    <img src="${userTemp.getUrlFotoProfilo()}" alt="Foto Profilo">
                </div>
                <form action="Profilo" method="post" id="formProfilo">
                    <div class="singoloCampo">    
                        <label for="nome">Nome:</label>
                        <input type="text" name="name" id="nome" required value="${userTemp.getNome()}">
                    </div>
                    <div class="singoloCampo">
                        <label for="cognome">Cognome:</label>
                        <input type="text" name="surname" id="cognome" value="${userTemp.getCognome()}" >
                    </div>
                    <!-- <div class="singoloCampo">
                        <label for="data">Data di nascita:</label>
                        <input type="date" name="date" id="data" >
                    </div> -->
                    <div class="singoloCampo">
                        <label for="urlfotoprofilo">Url Foto Profilo: </label>
                        <input type="text" name="url" id="urlfotoprofilo" value="${userTemp.getUrlFotoProfilo()}" >
                    </div>
                    <div class="singoloCampo">
                        <label for="mail">e-mail: </label>
                        <input type="text" name="email" id="mail" value="${userTemp.getEmail()}" >
                    </div>
                    <div class="singoloCampo">
                        <label for="frase">Frase di presentazione:</label>
                        <input type="text" name="frase" id="frase" value="${userTemp.getFrasePersonale()}" >
                    </div>
                    <div class="singoloCampo">
                        <label for="password">Password:</label>
                        <input type="password" name="pass" id="password" required value="${userTemp.getPassword()}" >
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
