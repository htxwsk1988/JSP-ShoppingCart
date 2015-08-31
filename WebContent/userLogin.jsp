<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="80%" border="1">
  <tr>
    <td>
    	<div align="center">
    	<jsp:include flush="true" page="header.jsp"></jsp:include>
		</div>
	</td>
  </tr>
  <tr>
    <td><div align="center">
    	<form action="UserLoginServlet" method="post">
	      <table width="100%" border="1">
	        <tr>
	          <td><div align="center"><img src="images/Shopping_flow.jpg" width="1217" height="99" alt="shoppingflow" /></div></td>
	        </tr>
	        <tr>
	          <td><table width="40%" border="1" align="center">
	            <tr>
	              <td colspan="2"><div align="center"><img src="images/UserLogin.jpg" width="311" height="114" alt="UserLogin" /></div></td>
	              </tr>
	            <tr>
	              <td width="42%" align="center"><div align="right"><strong>UserName:</strong></div></td>
	              <td width="58%" align="center">
	                  <div align="left">
	                    <input name="txtUserName" type="text" id="txtUserName" />
	                  </div>
	              </td>
	            </tr>
	            <tr>
	              <td align="center"><div align="right"><strong>Password:</strong></div></td>
	              <td align="center"><div align="left">
	                <input name="txtPassword" type="text" id="txtPassword" />
	              </div></td>
	            </tr>
	            <tr>
	              <td align="center">
	                  <div align="right">
	                    <input type="submit" name="Submit" value="SignIn" />
	                  </div>
	              </td>
	              <td align="center">
	                  <div align="left">
	                     <input type="submit" name="Submit2" value="Register" />
	                  </div>
	               </td>
	            </tr>
	          </table>
          </td>
        </tr>
        <tr>
          <td height="38"><div align="right"><img src="images/NextStep.jpg" alt="NextStep" width="42" height="39" /></div></td>
        </tr>
      </table>
      </form>
    </div></td>
  </tr>
  <tr>
    <td>
	    <div align="center">
			<jsp:include flush="true" page="footer.jsp"></jsp:include>
	    </div>
    </td>
  </tr>
</table>
</body>
</html>