<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>상품 등록</title>
  <style>
body {
  font-family: Arial, sans-serif;
}

h1 {
  text-align: center;
}

form {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
}

label {
  display: block;
  margin-bottom: 10px;
}

input[type="text"],
input[type="number"],
textarea {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-sizing: border-box;
  margin-bottom: 10px;
}

button[type="submit"] {
  background: #4caf50;
  color: #fff;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-top: 10px;
  display: block;
  margin-left: auto;
  margin-right: auto;
}
	
  </style>
</head>
<body>
  <h1>상품 등록</h1>
  
  <form action="add_item_ok.jsp" method="POST">
    <label for="itemnm">상품명:</label>
    <input type="text" id="itemnm" name="itemnm" required>
    
    <label for="price">가격:</label>
    <input type="number" id="price" name="price" required>
    
    <label for="stock">재고:</label>
    <input type="text" id="stock" name="stock">
    
    <label for="description">설명:</label>
    <textarea id="description" name="description"></textarea>
    
    <button type="submit" onclick="clicked()">등록</button>
  </form>
  
  <script>
  function clicked() {
      var itemnm = document.getElementById("itemnm").value;
      if (itemnm.trim() === "") {
        alert("상품명을 입력하세요.");
        return false;
      }
      
      var price = document.getElementById("price").value;
      if (price.trim() === "") {
        alert("가격을 입력하세요.");
        return false;
      }
      
      
      return true;
  }
  </script>
</body>
</html>