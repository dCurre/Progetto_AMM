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
    <form action="RiepilogoPost?utenteBacheca=${utenteBacheca}" method="post">
        <div id="postType">
            <c:if test="${utenteBacheca == userID}">
                Pubblica un pensiero o un'immagine.
            </c:if>
            <c:if test="${utenteBacheca != userID}">
                Scrivi nella bacheca di ${listaUtenti.getUserById(utenteBacheca).getNome()} ${listaUtenti.getUserById(utenteBacheca).getCognome()}
            </c:if>
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
    
            
<c:forEach var="temp" items="${listaPost}">
    <div class="post">
        <div class="userPost">
            <img src="${listaUtenti.getUserById(temp.user).getUrlFotoProfilo()}" alt="Foto Profilo"> ${listaUtenti.getUserById(temp.user).getNome()} ${listaUtenti.getUserById(temp.user).getCognome()}
        </div>
        <div class="contentImage">
        <p>${temp.content}</p>
         <c:if test="${temp.img != null}">
             <img src="${temp.img}" alt="Immagine post">
         </c:if>
        </div>
        <!-- 
            <div class="eliminaPost">
                Elimina post
            </div>
        -->
    </div>
</c:forEach>
    

