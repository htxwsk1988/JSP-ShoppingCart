<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.cc.cad.model.*"
    pageEncoding="ISO-8859-1"%>
    
<% 	
	// Retrieve complete order Info. 
	OrderCompleteInfoBean bean = (OrderCompleteInfoBean)request.getAttribute("CompleteOrderInfo"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="80%" border="1" align="center">
  <tr>
    <td><div align="center">
    	<jsp:include flush="true" page="header.jsp"></jsp:include> 
    </div></td>
  </tr>
  <tr>
    <td><table width="100%" border="1">
      <tr>
        <td colspan="9"><div align="center"><img src="images/Shopping_flow.jpg" width="1115" height="101" alt="shoppingflow" /></div></td>
        </tr>
      <tr>
        <td colspan="9"><div align="center"><Strong>Your Order Details </Strong></div></td>
        </tr>
      <tr>
        <td width="8%"><div align="center">OrderId</div></td>
        <td width="12%"><div align="center">Full Name</div></td>
        <td width="15%"><div align="center">Address</div></td>
        <td width="10%"><div align="center">PostCode</div></td>
        <td width="15%"><div align="center">Phone</div></td>
        <td width="12%"><div align="center">Total Price</div></td>
        <td width="10%"><div align="center">UserName</div></td>
        <td width="10%"><div align="center">Email</div></td>
        <td width="%8"><div align="center"></div></td>
      </tr>
      <tr>
        <td><div align="center"><%=bean.getOrderId() %></div></td>
        <td><div align="center"><%=bean.getFULLNAME() %></div></td>
        <td><div align="center"><%=bean.getADDRESS() %></div></td>
        <td><div align="center"><%=bean.getPOSTCODE() %></div></td>
        <td><div align="center"><%=bean.getPHONE() %></div></td>
        <td><div align="center">$<%=bean.getTotalPrice()%></div></td>
        <td><div align="center"><%=bean.getUSERNAME() %></div></td>
        <td><div align="center"><%=bean.getEMAIL() %></div></td>
        <td><div align="center">View</div></td>
      </tr>
      <tr>
        <td colspan="9"><div align="center">Your order has been confirmed. </div></td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td><div align="center">
    	<jsp:include flush="true" page="footer.jsp"></jsp:include> 
    </div></td>
  </tr>
</table>
</body>
</html>