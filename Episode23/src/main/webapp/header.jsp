<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>header</title>
  <style>
    @import url("https://fonts.googleapis.com/css2?family=Alkatra&display=swap");
    @import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap");

    * {
      margin: 0;
      padding: 0;
      color: gray;
    }

    .header {
      position: fixed;
      top: 0;
      width: 100%;
      left: 0;
      background-color: #d6d8c5;
      display: inline-flex;
      height: 40px;
      justify-content: center;
    }

    .title {
      text-decoration: none;
      font-family: "Alkatra", cursive;
      font-size: 15px;
      margin-top: 3px;
    }

    .nav {
      margin-top: 3px;
    }

    .nav a {
      font-family: "Noto Sans KR", sans-serif;
      font-size: 13px;
      margin-left: 5px;
      text-decoration: none;
    }

    .nav a:hover {
      color: white;
    }

    .bag {
      width: 15px;
      height: 15px;
      margin-top: 5px;
      margin-left: 5px;
    }

    @media (min-width: 500px) {
      .title {
        font-size: 20px;
      }

      .nav {
        margin-top: 8px;
      }

      .nav a {
        font-size: 15px;
        margin-left: 10px;
        margin-right: 10px;
      }

      .bag {
        width: 20px;
        height: 20px;
        margin-left: 10px;
        margin-top: 8px;
      }
    }

    @media (min-width: 800px) {
      .header {
        height: 50px;
      }

      .title {
        font-size: 30px;
      }

      .nav {
        margin-top: 10px;
      }

      .nav a {
        font-size: 20px;
        margin-left: 20px;
        margin-right: 20px;
      }

      .bag {
        width: 25px;
        height: 25px;
        margin-left: 10px;
        margin-top: 12px;
      }
    }

    @media (min-width: 1200px) {
      .title {
        text-align: center;
      }

      .nav a {
        margin-left: 30px;
        margin-right: 30px;
      }

      .bag {
        width: 35px;
        height: 35px;
        margin-top: 6px;
      }
    }
  </style>
</head>

<body>
  <div class="header">
    <a href="./main.jsp" class="title">Episode23</a>
    <div class="nav">
      <a href="./clothes.jsp">clothes</a>
      <a href="./accessories.jsp">accessories</a>
      <a href="./iteam.jsp">iteam</al>
      <a href="./best.jsp">best</a>
      <a href="./login.jsp">login</a>
    </div>
    <img src="./bag.png" alt="bag" class="bag">
  </div>
</body>

</html>