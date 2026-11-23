```jsp
<%@ page import="lab.mvc.model.Person" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Old Person</title>
</head>
<body>

    <h1>Person born before 1990</h1>

    <jsp:useBean id="person" type="lab.mvc.model.Person" scope="request" />

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