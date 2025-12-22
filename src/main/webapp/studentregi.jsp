<!DOCTYPE html>
<html>
<head>
	${dberror}
    <title>Student Registration Form</title> 
    <style>
        body {
            background: #f3f7ff;
            font-family: Arial, sans-serif;
        }
        .container {
            width: 450px;
            background: white;
            margin: 40px auto;
            padding: 25px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.2);
            border-radius: 8px;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        label {
            font-size: 15px;
            color: #333;
            font-weight: bold;
        }
        input, select, textarea {
            width: 100%;
            padding: 8px;
            margin: 6px 0 15px 0;
            border: 1px solid #888;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="radio"], input[type="checkbox"]{
            width: auto;
            margin-right: 5px;
        }
        .btn-container {
            text-align: center;
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
            background: #d9534f;
        }
        input[type="reset"]:hover {
            background: #a94442;
        }
    </style>
</head>

<body>

<div class="container">
    <h2>Student Registration Form</h2>

    <form action="InsertStudentServlet" method="post">
        <label>Full Name:</label>  ${fullnameError}
        <input type="text" name="fullname" value="${sbean.fullname}" > 

        <label>Age:</label>  ${ageError}
        <input type="number" name="age" value="${sbean.age}" >

        <label>Select Course:</label>  ${courseError}
        <select name="course">   
            <option value="">-- Select Course --</option>

            <option value="C Programming" ${sbean.course=='C Programming' ? 'selected' : ''} >C Programming</option>
            
            <option value="C++" ${sbean.course=='C++' ? 'selected' : ''}>C++</option>
            
            <option value="Core Java" ${sbean.course=='Core Java' ? 'selected' : ''}>Core Java</option>
            
            <option value="Advanced Java" ${sbean.course=='Advanced Java' ? 'selected' : ''} >Advanced Java</option>
            
            <option value="Python" ${sbean.course=='Python' ? 'selected' : ''}>Python</option>
            
        </select>


        <label>Gender:</label>  ${genderError}<br>
        <input type="radio" name="gender" value="Male"   ${sbean.gender=='Male'   ? 'checked' : ''} > Male
        <input type="radio" name="gender" value="Female" ${sbean.gender=='Female' ? 'checked' : ''} > Female
        <input type="radio" name="gender" value="Other"  ${sbean.gender=='Other'  ? 'checked' : ''} > Other
        <br><br>


        <label>Hobbies:</label>   ${hobbiesError}<br>
        <input type="checkbox" name="hobby" value="Reading" ${sbean.isHobbySelected('Reading') ? 'checked' : ''}  > Reading
        <input type="checkbox" name="hobby" value="Music"	${sbean.isHobbySelected('Music')   ? 'checked' : ''}  > Music
        <input type="checkbox" name="hobby" value="Sports"	${sbean.isHobbySelected('Sports')  ? 'checked' : ''}  > Sports
        <input type="checkbox" name="hobby" value="Coding"	${sbean.isHobbySelected('Coding')  ? 'checked' : ''}  > Coding
        <br><br>


        <label>Date of Birth:</label> ${dobError}
        <input type="date" name="dob" value="${sbean.dob}">

        <label>Email ID:</label>  ${emailError}
        <input type="email" name="email" value="${sbean.email}">

        <label>Mobile Number:</label>  ${mobileError}
        <input type="tel" name="mobile" value="${sbean.mobile}">

        <label>Address:</label> ${addressError}
        <textarea name="address" rows="3">${sbean.address}</textarea>

        <div class="btn-container">
            <input type="submit" value="Register">
            <input type="reset" value="Clear">
        </div>
    </form>
</div>
</body>
</html>
