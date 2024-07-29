<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../includes/header.jsp"%>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

${todo}

<a href="/todo/edit?tno=${todo.tno}">Modify/Delete</a>

<%@include file="../includes/footer.jsp"%>
