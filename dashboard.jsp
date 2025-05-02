<%@ page import="java.util.List" %>
<%@ page session="true" %>
<%
    String username = (String) session.getAttribute("username");
    List<String> enrolled = (List<String>) session.getAttribute("enrolledCourses");
    List<String> courseList = (List<String>) request.getAttribute("courseList");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <h2>Welcome, <%= username %></h2>
    <a href="LogoutServlet">Logout</a>

    <h3>Available Courses</h3>
    <ul>
        <% for (String course : courseList) { %>
            <li>
                <%= course %> 
                <% if (!enrolled.contains(course)) { %>
                    - <a href="EnrollServlet?courseId=<%= course %>">Enroll</a>
                <% } else { %>
                    (Enrolled)
                <% } %>
            </li>
        <% } %>
    </ul>

    <h3>Your Enrolled Courses</h3>
    <ul>
        <% for (String course : enrolled) { %>
            <li><%= course %></li>
        <% } %>
    </ul>
</body>
</html>
