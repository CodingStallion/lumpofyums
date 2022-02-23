<%@page import="lumpofyums.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.PrintStream"%>

<%
String email = request.getParameter("email");
String username = request.getParameter("username");
String question = request.getParameter("question");
String answer = request.getParameter("answer");
String newPassword = request.getParameter("newPassword");

int check = 0;
try {
	Connection con = ConnectionPro.getConnection();
	Statement statement = con.createStatement();
	ResultSet rs = statement.executeQuery("select *from user where email = '" + email + "' and question ='" + question
	+ "'and answer =  '" + answer + "'");
	while (rs.next()) {
		check = 1;
		statement.executeUpdate("update user set password='" + newPassword + "' where email = '" + email + "' ");
		response.sendRedirect("forgotpassword.jsp?msg=done");
	}
	if (check == 0) {
		response.sendRedirect("forgotpassword.jsp?msg=invalid");
	}

} catch (Exception e) {
	e.printStackTrace();

}
%>
