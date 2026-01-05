<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.royal.bean.StudentBean"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Student List</title>

    <style>
        body {
            font-family: "Segoe UI", Arial, sans-serif;
            background: #f4f6f9;
            margin: 0;
            padding: 20px;
        }

        .container {
            width: 95%;
            margin: auto;
            background: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 20px;
        }

        .error {
            color: #c0392b;
            font-weight: bold;
            text-align: center;
            margin-bottom: 15px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            font-size: 14px;
        }

        thead {
            background: #2c3e50;
            color: #ffffff;
        }

        th, td {
            padding: 10px 12px;
            text-align: center;
            border: 1px solid #ddd;
        }

        tbody tr:nth-child(even) {
            background: #f9f9f9;
        }

        tbody tr:hover {
            background: #eef4ff;
        }

        th {
            text-transform: uppercase;
            font-size: 13px;
            letter-spacing: 0.5px;
        }

        .action-btn {
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 4px;
            font-size: 13px;
            font-weight: bold;
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
</head>

<body>

<div class="container">
    <h2>Student List</h2>

    <div class="error">
        ${deleteError}
    </div>

    <%
        ArrayList<StudentBean> list = (ArrayList<StudentBean>) request.getAttribute("list");
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
            for (int i = 0; i < list.size(); i++) {
                StudentBean s = list.get(i);

                String[] hobbies = s.getHobbies();
                String hobby = "";
                for (int j = 0; j < hobbies.length; j++) {
                    if (j < hobbies.length - 1) {
                        hobby += hobbies[j] + ", ";
                    } else {
                        hobby += hobbies[j];
                    }
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
                       href="EditStudentServlet?id=<%= s.getId() %>">Edit</a>
                    |
                    <a class="action-btn delete" 
                       href="DeleteStudentServlet?id=<%= s.getId() %>"
                       onclick="return confirm('Are you sure you want to delete this record?');">
                       Delete</a>
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
