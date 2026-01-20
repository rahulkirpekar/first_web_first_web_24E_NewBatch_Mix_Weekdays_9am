<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Application</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, Helvetica, sans-serif;
        background: linear-gradient(120deg, #2980b9, #6dd5fa);
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .login-box {
        background: #ffffff;
        width: 350px;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0px 10px 25px rgba(0,0,0,0.2);
    }

    .login-box h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    .message {
        text-align: center;
        font-size: 14px;
        margin-bottom: 10px;
        color: green;
    }

    .error {
        color: red;
    }

    table {
        width: 100%;
    }

    td {
        padding: 8px 0;
    }

    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 8px;
        border-radius: 4px;
        border: 1px solid #ccc;
        outline: none;
    }

    input[type="text"]:focus,
    input[type="password"]:focus {
        border-color: #2980b9;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin-top: 15px;
        background-color: #2980b9;
        border: none;
        color: white;
        font-size: 15px;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #1f6391;
    }
</style>

</head>

<body>

<div class="login-box">
    <h2>Login</h2>

    <!-- Messages -->
    <div class="message">${logoutsuccess}</div>
    <div class="message error">${invalidAccess}</div>

    <form action="loginServlet" method="post">
        <table>
            <tr>
                <td>Username</td>
            </tr>
            <tr>
                <td>
                    <input type="text" name="userName" placeholder="Enter username" required>
                </td>
            </tr>

            <tr>
                <td>Password</td>
            </tr>
            <tr>
                <td>
                    <input type="password" name="password" placeholder="Enter password" required>
                </td>
            </tr>

            <tr>
                <td>
                    <input type="submit" value="Login">
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
