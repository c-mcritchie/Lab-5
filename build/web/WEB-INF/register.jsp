<%-- 
    Document   : register.jsp
    Created on : Oct. 21, 2022, 4:31:30 p.m.
    Author     : colem
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        
        <form action="shoppinglist" method="POST">
            <input type="hidden" name="action" value="register">
            Username:
            <input type="text" name="username" id="username">
            
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
