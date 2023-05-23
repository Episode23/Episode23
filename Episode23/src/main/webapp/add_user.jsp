<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="kr">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원 가입</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f1f1f1;
    }

    .container {
      max-width: 400px;
      margin: 0 auto;
      margin-top: 80px;
      padding: 20px;
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    h1 {
      text-align: center;
      margin-bottom: 20px;
    }

    .form-group {
      margin-bottom: 15px;
    }

    label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
    }

    input[type="text"],
    input[type="password"] {
      width: 95%;
      padding: 10px;
      border: none;
      border-radius: 3px;
      background-color: #f5f5f5;
    }

    button[type="submit"] {
      display: block;
      width: 100%;
      padding: 10px;
      background-color: gray;
      color: #fff;
      border: none;
      border-radius: 3px;
      cursor: pointer;
    }

    button[type="submit"]:hover {
      background-color: #D6D8C5;
    }
  </style>
</head>

<body>
  <div class="container">
  <%@ include file="header.jsp" %>
    <h1>회원 가입</h1>
    <%
      request.setCharacterEncoding("UTF-8");
    %>
    <form action="add_user_ok.jsp" method="POST" accept-charset="UTF-8">
      <div class="form-group">
        <label for="userid">아이디:</label>
        <input type="text" id="userid" name="userid" required>
      </div>
      <div class="form-group">
        <label for="userpw">비밀번호:</label>
        <input type="password" id="userpw" name="userpw" required>
      </div>
      <div class="form-group">
        <label for="userpw">비밀번호 확인:</label>
        <input type="password" id="userpwc" name="userpwc" required>
      </div>
      <div class="form-group">
        <label for="usernm">이름:</label>
        <input type="text" id="usernm" name="usernm" required>
      </div>
      <div class="form-group">
        <label for="address">주소:</label>
        <input type="text" id="address" name="address">
      </div>
      <div id="message" style="font-size: 12px; margin-bottom: 10px;"></div>
      <div class="form-group">
        <button type="submit" onclick="clicked()">가입하기</button>
      </div>
    </form>
  </div>
</body>
<script>
function clicked() {
    var userid = document.getElementById("userid").value;
    var userpw = document.getElementById("userpw").value;
    var userpwc = document.getElementById("userpwc").value;
    var usernm = document.getElementById("usernm").value;
    var messageDiv = document.getElementById("message");

    if (userid == "") {
      messageDiv.innerHTML = "아이디를 입력해주세요.";
      return false;
    } else if (userpw == ""){
      messageDiv.innerHTML = "비밀번호를 입력해주세요.";
      return false;
    } else if (userpwc == "") {
      messageDiv.innerHTML = "비밀번호 확인을 입력해주세요.";
      return false;
    } else if (userpw != userpwc) {
       messageDiv.innerHTML = "비밀번호가 일치하지 않습니다.";
       return false;
    } else if (usernm == "") {
    	messageDiv.innerHTML = "회원명을 입력해주세요.";
        return false;
    } else {
    	messageDiv.innerHTML = "";
    }
}
</script>
</html>
