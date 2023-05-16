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
		<caption><b style="font-size: 30px">��ǰ���</b></caption>
		<tr>
		<td style="background-color: #d6d8c5; width: 90px">��ǰ��</td>
		<td><input type="text" class="goods_name" style="width: 130px; height: 24px"></td>
		</tr>		
		<tr>
		<td style="background-color: #d6d8c5; width: 90px;">����</td>
		<td><input type="text" class="price" style="width: 130px; height: 24px" placeholder="���ڸ� �Է�"></td>
		</tr>		
		<tr>
		<td style="background-color: #d6d8c5; width: 90px">ī�װ�</td>
		<td><select style="width: 130px; height: 24px" class="Kategorie">
			<option>�ƿ���</option>
			<option>���ǽ�</option>
			<option>�ĵ�Ƽ</option>
			<option>������</option>
			<option>Ʈ���̴׺�</option>
			<option>������</option>
			<option>û����</option>
			<option>��ĿƮ</option>
			<option>�Ǽ��縮</option>
			<option>������</option>
		</select></td>
		</tr>
		<tr>
		<td style="background-color: #d6d8c5; width: 90px">��ǰ �̹���</td>
		<td><input type="file" class="file_img" style="width: 130px"></td>
		</tr>
		<tr>
		<td style="background-color: #d6d8c5; width: 90px">��ǰ ����</td>
		<td><textarea style="width: 130px; height: 60px; resize: none;" class="goods_explanation"></textarea></td>
		</tr>
		<tr>
		<td style="background-color: #d6d8c5; width: 90px">��ǰ �±�</td>
		<td><textarea style="width: 130px; height: 60px; resize: none;" placeholder="ex) ��,���ǽ�..."></textarea></td>
		</tr>
		<tr>
		<td colspan="2"><button style="width: 60px; padding:5px; background-color: #d6d8c5; border: none; border-radius: 5px">���</button></td>
		</tr>
		</table>
	</form>
	</div>
</body>
</html>