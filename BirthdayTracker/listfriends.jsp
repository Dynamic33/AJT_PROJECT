<%@ page import="java.util.*,com.birthdaytracker.model.Friend" %>
<html>
<head>
    <title>Friends List</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h2>All Friends</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Birthday</th>
        <th>Action</th>
    </tr>
    <%
        List<Friend> list = (List<Friend>) request.getAttribute("friendsList");
        for (Friend f : list) {
    %>
    <tr>
        <td><%=f.getId()%></td>
        <td><%=f.getName()%></td>
        <td><%=f.getEmail()%></td>
        <td><%=f.getBirthday()%></td>
        <td><a class="delete-btn" href="delete?id=<%=f.getId()%>">Delete</a></td>
    </tr>
    <% } %>
</table>
<nav>
    <a href="addfriend.jsp">Add Another</a>
    <a href="index.jsp">Back to Home</a>
</nav>
<footer>
    &copy; 2025 Birthday Tracker App
</footer>
</body>
</html>
