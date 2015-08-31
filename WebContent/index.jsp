<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table width="90%" border="1" align="center">
	  <tbody>
	    <tr>
	      <td height="122" colspan="2">
	      	<jsp:include flush="true" page="header.jsp"></jsp:include>
	      </td>
	    </tr>
	    <tr>
	      <td width="20%" height="400">
	      	<jsp:include flush="true" page="left.jsp"></jsp:include>
	      </td>
	      <td width="80%">
	      	<jsp:include flush="true" page="right.jsp"></jsp:include>      
	      </td>
	    </tr>
	    <tr>
	      <td height="100" colspan="2">
	      	<jsp:include flush="true" page="footer.jsp"></jsp:include>
	      </td>
	    </tr>
	  </tbody>
	</table>
</body>
</html>