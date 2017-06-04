<%-- 
    Document   : listaUtentiJson
    Created on : Jun 4, 2017, 5:08:27 PM
    Author     : davide
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="utenteTemp" items="${listaUtenti}">
        <json:object>
            <json:property name="nome" value="${utenteTemp.nome}"/>
            <json:property name="cognome" value="${utenteTemp.cognome}"/>
            <json:property name="id" value="${utenteTemp.id}"/>
            <json:property name="urlFotoProfilo" value="${utenteTemp.urlFotoProfilo}"/>
        </json:object>
    </c:forEach>
</json:array>