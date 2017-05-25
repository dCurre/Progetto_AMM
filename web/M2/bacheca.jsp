<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType = "text/html" pageEncoding = "UTF-8" %>
<c:set var="page" value="Bacheca" scope="request"/>
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
                <jsp:include page="ripetuti/post.jsp"/>
            </div>
        </div>
    </body>
</html>
