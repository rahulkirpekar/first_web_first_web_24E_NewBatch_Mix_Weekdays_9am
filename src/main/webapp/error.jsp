<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Oops! Something went wrong</title>

    <style>
        body {
            margin: 0;
            font-family: "Segoe UI", Arial, sans-serif;
            background: linear-gradient(135deg, #1d2671, #c33764);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .error-container {
            background: #ffffff;
            width: 420px;
            padding: 40px;
            border-radius: 12px;
            text-align: center;
            box-shadow: 0 20px 40px rgba(0,0,0,0.25);
        }

        .error-code {
            font-size: 72px;
            font-weight: bold;
            color: #c33764;
            margin: 0;
        }

        .error-title {
            font-size: 22px;
            margin: 10px 0;
            color: #333;
        }

        .error-message {
            color: #666;
            font-size: 14px;
            margin-bottom: 25px;
        }

        .btn {
            display: inline-block;
            padding: 12px 25px;
            background: #1d2671;
            color: #fff;
            text-decoration: none;
            border-radius: 30px;
            font-size: 14px;
            transition: 0.3s;
        }

        .btn:hover {
            background: #c33764;
        }

        .footer {
            margin-top: 20px;
            font-size: 12px;
            color: #999;
        }
    </style>
</head>

<body>

<div class="error-container">

    <p class="error-code">500</p>
    <p class="error-title">Internal Server Error</p>

    <p class="error-message">
        We’re sorry, something went wrong on our end.<br>
        Please try again later.
    </p>

    <!-- Hide technical error from end users -->
    <%-- 
    <p><%= exception %></p> 
    --%>

    <a href="login.jsp" class="btn">Go to Home</a>

    <div class="footer">
        © 2026 Your Company Name
    </div>

</div>

</body>
</html>
