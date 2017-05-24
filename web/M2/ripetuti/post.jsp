<%-- 
    Document   : post
    Created on : May 2, 2017, 4:12:50 PM
    Author     : davide
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${groupOrUser == false}">
    <div id="divFrasePersonale">
        <p id="frasePersonale">${listaUtenti.getUserById(utenteBacheca).getNome()}: ${listaUtenti.getUserById(utenteBacheca).getFrasePersonale()} </p>
    </div>
</c:if>
<div id="formNewPost">
    <form action="RiepilogoPost?idBacheca=${utenteBacheca}&groupOrUser=${groupOrUser}" method="post">
        <div id="postType">
            <c:choose>   
                <c:when test="${utenteBacheca == userID && groupOrUser == false}">
                   Pubblica un pensiero o un'immagine.
                </c:when>
                <c:when test="${utenteBacheca != userID && groupOrUser == false}">
                   Scrivi nella bacheca di ${listaUtenti.getUserById(utenteBacheca).getNome()} ${listaUtenti.getUserById(utenteBacheca).getCognome()}
                </c:when>
                <c:when test="${groupOrUser == true}">
                   Scrivi nella bacheca del gruppo ${listaGruppi.getGruppoById(utenteBacheca).getNome()}
                </c:when>
            </c:choose>
        </div>
        <div id="postContent">
            <div>
                <label for="textPost">Testo</label>
                <textarea name="textPost" id="textPost" required=""></textarea>
            </div>
            <div>
                <label for="imgPost">Link immagine</label>
                <input type="text" name="imgPost" id="imgPost">
            </div>
        </div>
        <button type="submit">Invia</button>
    </form>
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