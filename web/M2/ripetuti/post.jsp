<%-- 
    Document   : post
    Created on : May 2, 2017, 4:12:50 PM
    Author     : davide
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="divFrasePersonale">
    <p id="frasePersonale">${listaUtenti.getUserById(utenteBacheca).getNome()}: ${listaUtenti.getUserById(utenteBacheca).getFrasePersonale()} </p>
</div>
    
<div id="formNewPost">
    <form action="Bacheca?user=${userBacheca}" method="post"> <!-- RiepilogoPost?... -->
        <div id="postType">
            <div>
                <input type="radio" name="postType" value="textType" id="textType">
                <label for="textType">Testo</label>
            </div>
            <div>
                <input type="radio" name="postType" value="imgType" id="imgType">
                <label for="imgType">Foto</label>
            </div>
        </div>
        <div id="postContent">
            <div>
                <label for="textPost">Testo</label>
                <textarea name="textPost" id="textPost"></textarea>
            </div>
            <div>
                <label for="imgPost">File d'immagine</label>
                <input type="file" name="imgPost" id="imgPost">
            </div>
        </div>
        <button type="submit">Invia</button>
    </form>
        
    <c:if test="${ok == 1}">
        <div class="validDataWarning"> ${resultTextPost} </div>
        </c:if>  
    <c:if test="${ok == 0}">
        <div class="invalidDataWarning">${resultTextPost} </div>
    </c:if>  
</div>
<c:forEach var="temp" items="">
    <div class="post">
        <div class="userPost">
            <img src="${listaUtenti.getUserById(utenteBacheca).getUrlFotoProfilo()}" alt="Foto Profilo"> ${listaUtenti.getUserById(utenteBacheca).getNome()} ${listaUtenti.getUserById(utenteBacheca).getCognome()}
        </div>
        <c:if test="">
            <p> ${temp.getContent()} </p>
        </c:if>    
        <c:if test="true">
            <p> ${temp.getContent()} </p>
            <div class="contentImage">
                
                <img src="${temp.getContent()}" alt="Foto">
            </div>
        </c:if>    
    </div>
</c:forEach>
    

