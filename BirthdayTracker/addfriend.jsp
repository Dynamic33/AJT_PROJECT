<%@ page language="java" %>
<html>
<head>
    <title>Add Friend</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h2>Add New Friend</h2>
<form action="add" method="post">
    Name: <input type="text" name="name" placeholder="Enter name" required><br>
    Email: <input type="email" name="email" placeholder="Enter email"><br>
    Birthday: <input type="date" name="birthday" required><br>
    <input type="submit" value="Save">
</form>
<nav>
    <a href="index.jsp">Back to Home</a>
</nav>
<footer>
    &copy; 2025 Birthday Tracker App
</footer>
</body>
</html>
