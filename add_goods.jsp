<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Episode23</title>
<style type="text/css">
	.main {
		margin-top: 40%;
		text-align: center;
	}
	
	table {
      font-family: "Noto Sans KR", sans-serif;
      margin-left: 50%;
      transform: translateX(-45%);
      text-align: center;
      border-spacing: 15px;
	}
	
	@media(min-width: 500px) {
		.main {
		margin-top: 25%;
		}
	}
	
	@media(min-width: 1000px) {
		.main {
		margin-top: 10%;
		}
	}
</style>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="main">
		<form action="add_goods_ok.jsp" method="post" enctype="multipart/form-data"> 
		<table class="table" style="width: 300px;">
		<caption><b style="font-size: 30px">상품등록</b></caption>
		<tr>
		<td style="background-color: #d6d8c5; width: 90px">상품명</td>
		<td><input type="text" class="goods_name" style="width: 130px; height: 24px"></td>
		</tr>		
		<tr>
		<td style="background-color: #d6d8c5; width: 90px;">가격</td>
		<td><input type="text" class="price" style="width: 130px; height: 24px" placeholder="숫자만 입력"></td>
		</tr>		
		<tr>
		<td style="background-color: #d6d8c5; width: 90px">카테고리</td>
		<td><select style="width: 130px; height: 24px" class="Kategorie">
			<option>아우터</option>
			<option>원피스</option>
			<option>후드티</option>
			<option>맨투맨</option>
			<option>트레이닝복</option>
			<option>슬렉스</option>
			<option>청바지</option>
			<option>스커트</option>
			<option>악세사리</option>
			<option>아이템</option>
		</select></td>
		</tr>
		<tr>
		<td style="background-color: #d6d8c5; width: 90px">제품 이미지</td>
		<td><input type="file" class="file_img" style="width: 130px"></td>
		</tr>
		<tr>
		<td style="background-color: #d6d8c5; width: 90px">제품 설명</td>
		<td><textarea style="width: 130px; height: 60px; resize: none;" class="goods_explanation"></textarea></td>
		</tr>
		<tr>
		<td style="background-color: #d6d8c5; width: 90px">제품 태그</td>
		<td><textarea style="width: 130px; height: 60px; resize: none;" placeholder="ex) 봄,오피스..."></textarea></td>
		</tr>
		<tr>
		<td colspan="2"><button style="width: 60px; padding:5px; background-color: #d6d8c5; border: none; border-radius: 5px">등록</button></td>
		</tr>
		</table>
	</form>
	</div>
</body>
</html>