<%@ page import ="java.util.*" %>
<%@ page import ="java.lang.*" %>

<!DOCTYPE html>
<html>
<body>
<center>
    <h1>
        <c:if test="${not empty message}">
            <h1>${message}</h1>
        </c:if>
    </h1>

</center>
</body>
</html>