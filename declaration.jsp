
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Declaration</title>
</head>
<body>

    <h1>JSP Declaration</h1>

    <%!
        private int numEntries = 10;

        private int randomInt(int range) {
            return 1 + ((int)(Math.random() * range));
        }
    %>

    <h2>Random numbers</h2>

    <ul>
        <%
            for (int i = 0; i < numEntries; i++) {
                out.println("<li>" + randomInt(100) + "</li>");
            }
        %>
    </ul>

</body>
</html>
