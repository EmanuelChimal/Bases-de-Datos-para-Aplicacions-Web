<%-- 
    Document   : index
    Created on : 8/06/2024, 07:19:23 AM
    Author     : Emanu
--%>
<%@page import="java.util.List"%>
<%@page import="JavaBean.Escuela"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Escuelas</title>
</head>
<body>
    <h1>Lista de Escuelas</h1>
    
    <table border="1">
        <tr>
            <th>CLAVE</th>
            <th>ESCUELA</th>
            <th>DOMICILIO</th>
            <th>TURNO</th>
            <th>ACCIONES</th>
        </tr>
        
        <c:forEach var="e" items="${requestScope.ListaEscuelas}">
            <tr>
                <td><c:out value="${e.claveEscuela}" /></td>
                <td><c:out value="${e.nombreEscuela}" /></td>
                <td><c:out value="${e.domicilio}" /></td>
                <td><c:out value="${e.turno}" /></td>
                <td><a href="#">Editar</a> | <a href="#">Eliminar</a></td>
            </tr>              
        </c:forEach>
        
    </table>
</body>
</html>