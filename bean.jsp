```jsp
<%@ page import="isep.lab1.bean.Person" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Person Information</title>
</head>
<body>

    <h1>Person Information</h1>

    <jsp:useBean id="person" class="isep.lab1.bean.Person" scope="request" />

    <jsp:setProperty name="person" property="*" />

    <h2>Submitted Information:</h2>

    <p>First Name:
        <jsp:getProperty name="person" property="firstName" />
    </p>

    <p>Last Name:
        <jsp:getProperty name="person" property="lastName" />
    </p>

    <p>Birth Day:
        <jsp:getProperty name="person" property="birthDay" />
    </p>

    <p>Sex:
        <jsp:getProperty name="person" property="sex" />
    </p>

</body>
</html>
```