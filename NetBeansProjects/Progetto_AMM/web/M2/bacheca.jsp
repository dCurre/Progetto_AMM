<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType = "text/html" pageEncoding = "UTF-8" %>
<c:set var="page" value="bacheca" scope="request"/>
<!DOCTYPE html>

<html>
    <head>
        <jsp:include page="ripetuti/head.jsp"/>
    </head>
    <body>
        <!--Barra di navigazione tra le pagine del sito + logo + utente logout -->
        <jsp:include page="ripetuti/header.jsp"/>
        <div id="divBody">
            
            <jsp:include page="ripetuti/leftSideBar.jsp"/>
            
            <div id="divContent">
                <div id="divFrasePersonale">
                </div>
                <div class="post">
                    <div class="userPost">
                        <img src="../img/fotoProfilo1.jpg" alt="Foto Profilo">
                        Persona Prova Molto Brutta
                    </div>
                    <div class="contentPost">
                        <p>Chebbello questo sfondo</p>
                        <div class="contentImage">
                            <img src="../img/fotoLandscapePost.jpg" alt="Foto">
                        </div>
                    </div>
                </div>
                <div class="post">
                    <div class="userPost">
                        <img src="../img/fotoProfilo2.jpg" alt="Foto Profilo">
                        Persona Prova Molto Seschi
                    </div>
                    <div class="contentPost">
                        <p>Chebbello che sono</p>
                        <div class="contentImage">
                            <img src="../img/fotoProfilo2.jpg" alt="Foto">
                        </div>
                    </div>
                </div>
                <div class="post">
                    <div class="userPost">
                        <img src="../img/fotoProfilo3.jpg" alt="Foto Profilo">
                        Persona Prova Molto Bella
                    </div>
                    <div class="contentPost">
                        <p>Chebbello questo stato!</p>
                       
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
