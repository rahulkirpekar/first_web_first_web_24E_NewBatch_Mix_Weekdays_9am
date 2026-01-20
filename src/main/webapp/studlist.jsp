<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.royal.bean.StudentBean"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>

<style>
    body {
        margin: 0;
        font-family: "Segoe UI", Arial, sans-serif;
        background: #f4f6f9;
    }

    /* Header */
    .header {
        background: #2c3e50;
        color: white;
        padding: 12px 20px;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .header span {
        font-size: 14px;
    }

    .logout-btn {
        background: #e74c3c;
        border: none;
        color: white;
        padding: 6px 14px;
        border-radius: 4px;
        cursor: pointer;
        font-size: 13px;
    }

    .logout-btn:hover {
        background: #c0392b;
    }

    /* Container */
    .container {
        width: 95%;
        margin: 25px auto;
        background: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 10px rgba(0,0,0,0.12);
    }

    h2 {
        text-align: center;
        color: #2c3e50;
        margin-bottom: 15px;
    }

    .error {
        color: #c0392b;
        text-align: center;
        font-weight: bold;
        margin-bottom: 12px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        font-size: 14px;
    }

    thead {
        background: #34495e;
        color: white;
        position: sticky;
        top: 0;
        z-index: 10;
    }

    th, td {
        padding: 10px;
        text-align: center;
        border: 1px solid #ddd;
    }

    tbody tr:nth-child(even) {
        background: #f8f9fa;
    }

    tbody tr:hover {
        background: #eef4ff;
    }

    th {
        text-transform: uppercase;
        font-size: 12px;
        letter-spacing: 0.5px;
    }

    .action-btn {
        padding: 6px 10px;
        text-decoration: none;
        border-radius: 4px;
        font-size: 12px;
        font-weight: bold;
        display: inline-block;
    }

    .edit {
        background: #3498db;
        color: white;
    }

    .edit:hover {
        background: #217dbb;
    }

    .delete {
        background: #e74c3c;
        color: white;
    }

    .delete:hover {
        background: #c0392b;
    }
</style>

<script>
function confirmLogout() {
    return confirm("Are you sure you want to logout?");
}
</script>

</head>

<body>

<!-- Header -->
<div class="header">
    <span>Welcome, <b>${sessionScope.userName}</b></span>

    <form action="LogoutServlet" method="post" onsubmit="return confirmLogout();">
        <input type="submit" value="Logout" class="logout-btn">
    </form>
</div>

<!-- Main Container -->
<div class="container">

    <h2>Student List</h2>

    <div class="error">${deleteError}</div>

    <%
        ArrayList<StudentBean> list =
            (ArrayList<StudentBean>) request.getAttribute("list");
    %>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Full Name</th>
                <th>Age</th>
                <th>Course</th>
                <th>Gender</th>
                <th>Hobbies</th>
                <th>DOB</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Address</th>
                <th>Action</th>
            </tr>
        </thead>

        <tbody>
        <%
            for (StudentBean s : list) {

                String hobby = "";
                String[] hobbies = s.getHobbies();
                for (int j = 0; j < hobbies.length; j++) {
                    hobby += (j == hobbies.length - 1)
                             ? hobbies[j]
                             : hobbies[j] + ", ";
                }
        %>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getFullname() %></td>
                <td><%= s.getAge() %></td>
                <td><%= s.getCourse() %></td>
                <td><%= s.getGender() %></td>
                <td><%= hobby %></td>
                <td><%= s.getDob() %></td>
                <td><%= s.getEmail() %></td>
                <td><%= s.getMobile() %></td>
                <td><%= s.getAddress() %></td>
                <td>
                    <a class="action-btn edit"
                       href="EditStudentServlet?id=<%= s.getId() %>">
                       Edit
                    </a>
                    &nbsp;
                    <a class="action-btn delete"
                       href="DeleteStudentServlet?id=<%= s.getId() %>"
                       onclick="return confirm('Are you sure you want to delete this record?');">
                       Delete
                    </a>
                </td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>

</div>

</body>
</html>
