<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*, com.cc.cad.model.*"
    pageEncoding="ISO-8859-1"%>
    
<% 
	// Retrieve items from the shopping cart.
	ArrayList<MovieBean> al = (ArrayList<MovieBean>)request.getAttribute("myCartInfo"); 

	//
	ShoppingCartDAO sdao = (ShoppingCartDAO)session.getAttribute("myCart");
	
%>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<script type="text/javascript">
		<!--	
			// Remove all items.
			function removeAllItems(){
				window.open("ShoppingCartServlet?command=removeAll", "_self"); 
			}
		-->
	</script>
</head>
<body>
<table width="100%" border="1">
  <tr>
    <td>
    	<jsp:include flush="true" page="header.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td><div align="center">
    <form action="ShoppingCartServlet?command=updateNum" method="post">
      <table width="100%" border="1">
      
	        <tr>
	          <td height="46" colspan="6" align="center"><img src="images/Shopping_flow.jpg" /></td>
	          </tr>
	        <tr>
	          <td width="19%" align="center"><strong>ID</strong></td>
	          <td width="31%" align="center"><strong>Name</strong></td>
	          <td width="28%" align="center"><strong>Price</strong></td>
	          <td colspan="3" align="center"><strong>Number</strong></td>
	        </tr>
	        
	        <% 
	        	for(int i=0; i<al.size(); i++){
	        		
	        		MovieBean bean = al.get(i); 
	        
	        %>
			        <tr align="center">
			          <td><%=bean.getId() %></td>
			          <td><%=bean.getName() %> </td>
			          <td>$<%=bean.getPrice() %></td>
			          <td width="7%">
			          	<input type="hidden" name="movieId" value="<%=bean.getId() %>"/>
			            <input name="txtNum" type="text" size="10" value="<%=sdao.getMovieNumById(bean.getId()+"") %>"/>
			          </td>
			          <td width="8%"><a href="ShoppingCartServlet?command=delete&id=<%=bean.getId() %>">Delete</a></td>
			          <td width="7%"><a href="ShowMovieDetailServlet?command=display&id=<%=bean.getId() %>">View</a></td>
			        </tr>
	        <% 
	        	} 
	        %> 
        
	        <tr>
	          <td>&nbsp;</td>
	          <td align="center"><input type="button" name="Submit" value="Remove All" onclick="removeAllItems();"/></td>
	          <td align="center"><input type="submit" name="Submit2" value="Edit Number" /></td>
	          <td colspan="3">&nbsp;</td>
	        </tr>
	        <tr>
	          <td colspan="6">&nbsp;</td>
	          </tr>
	        <tr>
	          <td height="45" align="left" colspan="2">Total price of your purchase: $<%=sdao.getTotalPrice() %> <a href="index.jsp">Continue Shopping</a> </td>
	          <td colspan="4" align="right" valign="bottom"><a href="UserLoginServlet"><img border="0" src="images/NextStep.jpg" width="36" height="41" /></a></td>
	        </tr>
      </table>
      </form>
    </div></td>
  </tr>
  <tr>
    <td>
    	<jsp:include flush="true" page="footer.jsp"></jsp:include>
    </td>
  </tr>
</table>
</body>
</html>