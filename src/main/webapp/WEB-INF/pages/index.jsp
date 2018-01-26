<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<table>
    <form:form action="getSum" method="POST">
        <tr>
            <td><input type="text" value = ${sum}></td>
            <td><input type="submit" name="button" value="getSum"/></td>
        </tr>
    </form:form>
    <form:form action="getRichest" method="POST">
        <tr>
            <td><input type="text" value = ${user}></td>
            <td><input type="submit" name="button" value="getRichest"/></td>
        </tr>
    </form:form>
</table>
</body>
</html>
