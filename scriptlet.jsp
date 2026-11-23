
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Scriptlet</title>
</head>
<body>

    <h1>JSP Scriptlet</h1>

    <%
        java.util.Date now = new java.util.Date();
        String host = request.getRemoteHost();
    %>

    <p>Current date and time: <%= now %></p>

    <p>Remote host: <%= host %></p>

</body>
</html>
