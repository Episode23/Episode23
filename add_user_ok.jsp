<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");
  
  Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "1234");

  String sql = "insert into users values(?,?,?,?,?)";

  String query = "SELECT MAX(idx) FROM USERS";
  int idx = 0;

  PreparedStatement pstmt = conn.prepareStatement(query);
  ResultSet rs = pstmt.executeQuery();

  if (rs.next()) {
    idx = rs.getInt(1);
  }
  idx += 1;

  pstmt = conn.prepareStatement(sql);

  String userid = request.getParameter("userid");
  String userpw = request.getParameter("userpw");
  String usernm = request.getParameter("usernm");
  String address = request.getParameter("address");
  if (address.equals("")) {
    address = "미공개";
  }

  pstmt.setInt(1, idx);
  pstmt.setString(2, userid);
  pstmt.setString(3, userpw);
  pstmt.setString(4, usernm);
  pstmt.setString(5, address);

  pstmt.executeUpdate();

  pstmt.close();
  conn.close();
%>
<html lang="kr">
<title>회원가입</title>
<%@ include file="header.jsp" %>
<style>
  h2 {
    margin-top: 80px;
    font-family: Arial, sans-serif;
    font-size: 24px;
  }

  a {
    font-family: Arial, sans-serif;
    font-size: 16px;
    text-decoration: none;
  }

  a:hover {
    text-decoration: underline;
  }
</style>
<h2><%=usernm %>님 회원가입이 완료되었습니다.</h2>
<a href="main.jsp">홈으로 이동</a>
