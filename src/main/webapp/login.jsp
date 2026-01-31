<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Secure Login | Web Application</title>

<!-- Google Font -->
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

<style>
    * {
        box-sizing: border-box;
        font-family: 'Poppins', sans-serif;
    }

    body {
        margin: 0;
        padding: 0;
        height: 100vh;
        background: linear-gradient(135deg, #1d2671, #c33764);
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .login-container {
        background: #ffffff;
        width: 380px;
        padding: 35px;
        border-radius: 10px;
        box-shadow: 0 15px 40px rgba(0, 0, 0, 0.25);
        animation: fadeIn 0.8s ease-in-out;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(20px); }
        to { opacity: 1; transform: translateY(0); }
    }

    .login-container h2 {
        text-align: center;
        margin-bottom: 5px;
        font-weight: 600;
        color: #333;
    }

    .login-container p {
        text-align: center;
        font-size: 14px;
        color: #777;
        margin-bottom: 20px;
    }

    .message {
        text-align: center;
        font-size: 13px;
        margin-bottom: 10px;
        color: green;
    }

    .error {
        color: #d63031;
    }

    .form-group {
        margin-bottom: 15px;
    }

    label {
        font-size: 13px;
        color: #555;
        font-weight: 500;
    }

    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        border-radius: 5px;
        border: 1px solid #ccc;
        outline: none;
        font-size: 14px;
    }

    input:focus {
        border-color: #6c5ce7;
        box-shadow: 0 0 5px rgba(108, 92, 231, 0.4);
    }

    .login-btn {
        width: 100%;
        padding: 12px;
        background: linear-gradient(135deg, #6c5ce7, #341f97);
        border: none;
        color: #fff;
        font-size: 15px;
        font-weight: 500;
        border-radius: 5px;
        cursor: pointer;
        transition: background 0.3s ease;
        margin-top: 10px;
    }

    .login-btn:hover {
        background: linear-gradient(135deg, #341f97, #6c5ce7);
    }

    .footer-text {
        text-align: center;
        font-size: 12px;
        color: #999;
        margin-top: 20px;
    }
</style>

</head>

<body>

<div class="login-container">
    <h2>Welcome Back</h2>
    <p>Please login to your account</p>

    <!-- Messages -->
    <div class="message">${logoutsuccess}</div>
    <div class="message error">${invalidAccess}</div>

    <form action="loginServlet" method="post">
        <div class="form-group">
            <label>Username</label>
            <input type="text" name="userName" placeholder="Enter your username" required>
        </div>

        <div class="form-group">
            <label>Password</label>
            <input type="password" name="password" placeholder="Enter your password" required>
        </div>

        <input type="submit" value="Login" class="login-btn">
    </form>

    <div class="footer-text">
        © 2026 Secure Login System
    </div>
</div>

</body>
</html>