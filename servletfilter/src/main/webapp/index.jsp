

<%-- <h1>Welcome to SSO</h1> --%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>Keycloak Example App</title>
    <link rel="stylesheet" type="text/css" href="styles.css"/>
</head>
<body>

<jsp:useBean id="controller" class="servletfilter.Controller" scope="request"/>


<% controller.handleLogout(request, response); %> 

<c:set var="isLoggedIn" value="<%=controller.isLoggedIn(request)%>"/>
<c:if test="${isLoggedIn}">
    <div id="authenticated" style="display: block" class="menu" align="right" >
        <button  name="logoutBtn" onclick="location.href = '<%= request.getContextPath() %>/index.jsp?action=logout'">Logout</button>
    </div>
</c:if>

<div class="wrapper" id="profile">
       
   

    <div class="content">
        <div id="profile-content" class="message">
            <table cellpadding="0" cellspacing="0">
                <tr>
                    <td class="label" colspan="2">You are logged in!</td>
                </tr>
                <tr>
                    <td class="label">Principal :</td>
                    <td><span id="username"><%=request.getUserPrincipal().getName()%></span></td>
                </tr>
             </table>
        </div>
    </div>
</div>
</body>
</html>