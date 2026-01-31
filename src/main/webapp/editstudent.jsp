<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>

<style>
    body {
        margin: 0;
        background: #f3f7ff;
        font-family: Arial, sans-serif;
    }

    /* Header */
    .header {
        background: #007bff;
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
        background: #dc3545;
        color: white;
        border: none;
        padding: 6px 14px;
        border-radius: 4px;
        cursor: pointer;
        font-size: 13px;
    }

    .logout-btn:hover {
        background: #b52a37;
    }

    /* Container */
    .container {
        width: 480px;
        background: white;
        margin: 30px auto;
        padding: 25px;
        border-radius: 8px;
        box-shadow: 0 0 12px rgba(0,0,0,0.15);
    }

    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 15px;
    }

    label {
        font-weight: bold;
        font-size: 14px;
        display: block;
        margin-top: 10px;
    }

    input, select, textarea {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
        border: 1px solid #888;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[readonly] {
        background: #e9ecef;
        cursor: not-allowed;
    }

    input[type="radio"], input[type="checkbox"] {
        width: auto;
        margin-right: 6px;
    }

    .inline-options {
        margin-top: 6px;
    }

    .error {
        color: red;
        font-size: 12px;
        margin-left: 5px;
    }

    .db-error {
        text-align: center;
        color: red;
        font-weight: bold;
        margin-bottom: 10px;
    }

    .btn-container {
        text-align: center;
        margin-top: 20px;
    }

    input[type="submit"], input[type="reset"] {
        width: 120px;
        padding: 10px;
        border: none;
        color: white;
        font-weight: bold;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type="submit"] {
        background: #007bff;
    }

    input[type="submit"]:hover {
        background: #0056b3;
    }

    input[type="reset"] {
        background: #6c757d;
    }

    input[type="reset"]:hover {
        background: #545b62;
    }
</style>

<script>
function confirmLogout() {
    return confirm("Are you sure you want to logout?");
}
</script>

</head>

<body>

	<%
		String userName = (String)session.getAttribute("userName");
		
		if ( (session == null) || (userName == null))
		{
			request.setAttribute("invalidAccess", "<font color ='red'> Invalid Access...!</font>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	%>


<!-- Header -->
<div class="header">
    <span>Welcome, <b>${sessionScope.userName}</b></span>

    <form action="LogoutServlet" method="post" onsubmit="return confirmLogout();">
        <input type="submit" value="Logout" class="logout-btn">
    </form>
</div>

<!-- Main Container -->
<div class="container">

    <div class="db-error">${dberror}</div>

    <h2>Edit Student</h2>

    <form action="UpdateStudentServlet" method="post">

        <label>Student ID</label>
        <input type="text" name="id" value="${sbean.id}" readonly>

        <label>Full Name <span class="error">${fullnameError}</span></label>
        <input type="text" name="fullname" value="${sbean.fullname}">

        <label>Age <span class="error">${ageError}</span></label>
        <input type="number" name="age" value="${sbean.age}">

        <label>Select Course <span class="error">${courseError}</span></label>
        <select name="course">
            <option value="">-- Select Course --</option>
            <option value="C Programming" ${sbean.course=='C Programming' ? 'selected' : ''}>C Programming</option>
            <option value="C++" ${sbean.course=='C++' ? 'selected' : ''}>C++</option>
            <option value="Core Java" ${sbean.course=='Core Java' ? 'selected' : ''}>Core Java</option>
            <option value="Advanced Java" ${sbean.course=='Advanced Java' ? 'selected' : ''}>Advanced Java</option>
            <option value="Python" ${sbean.course=='Python' ? 'selected' : ''}>Python</option>
        </select>

        <label>Gender <span class="error">${genderError}</span></label>
        <div class="inline-options">
            <input type="radio" name="gender" value="Male"   ${sbean.gender=='Male' ? 'checked' : ''}> Male
            <input type="radio" name="gender" value="Female" ${sbean.gender=='Female' ? 'checked' : ''}> Female
            <input type="radio" name="gender" value="Other"  ${sbean.gender=='Other' ? 'checked' : ''}> Other
        </div>

        <label>Hobbies <span class="error">${hobbiesError}</span></label>
        <div class="inline-options">
            <input type="checkbox" name="hobby" value="Reading" ${sbean.isHobbySelected('Reading') ? 'checked' : ''}> Reading
            <input type="checkbox" name="hobby" value="Music"   ${sbean.isHobbySelected('Music') ? 'checked' : ''}> Music
            <input type="checkbox" name="hobby" value="Sports"  ${sbean.isHobbySelected('Sports') ? 'checked' : ''}> Sports
            <input type="checkbox" name="hobby" value="Coding"  ${sbean.isHobbySelected('Coding') ? 'checked' : ''}> Coding
        </div>

        <label>Date of Birth <span class="error">${dobError}</span></label>
        <input type="date" name="dob" value="${sbean.dob}">

        <label>Email <span class="error">${emailError}</span></label>
        <input type="email" name="email" value="${sbean.email}">

        <label>Mobile <span class="error">${mobileError}</span></label>
        <input type="tel" name="mobile" value="${sbean.mobile}">

        <label>Address <span class="error">${addressError}</span></label>
        <textarea name="address" rows="3">${sbean.address}</textarea>

        <div class="btn-container">
            <input type="submit" value="Update">
            <input type="reset" value="Reset">
        </div>

    </form>
</div>

</body>
</html>