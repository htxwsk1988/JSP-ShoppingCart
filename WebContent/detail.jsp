<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, com.cc.cad.model.*" %>
    
 <%
 	
 	MovieBean bean = (MovieBean)request.getAttribute("movieInfo"); 
 
 %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<script type="text/javascript">
		<!--
			// Return to index page on return event. 
			function returnIndex(){
				window.open("index.jsp","_self"); 
			}	
		
		
			// Purchase item.
			function addItem(id){
				window.open("ShoppingCartServlet?id="+id+"&command=add", "_self"); 
			}
		-->
	</script>
</head>
<body>
	<center>
		<table width="100%" border="1">
		  <tr>
		    <td height="67"><div align="center">
				<jsp:include flush="true" page="header.jsp"></jsp:include> 
		    </div></td>
		  </tr>
		  <tr>
		    <td><div>
		      <table width="100%" border="1">
		        <tr>
		          <td colspan="2">&nbsp;</td>
		          </tr>
		        <tr>
		          <td width="18%" rowspan="8"><img src="images/<%=bean.getImage() %>" alt="Avengers" width="200" height="273" /></td>
		          <td width="82%"><div align="center"> <b><%= bean.getName() %></b> </div></td>
		        </tr>
		        <tr>
		          <td><b>Price:</b> $<%= bean.getPrice() %></td>
		        </tr>
		        <tr>
		          <td>&nbsp;</td>
		        </tr>
		        <tr>
		          <td><b>ISBN:</b> <%= bean.getId() %></td>
		        </tr>
		        <tr>
		          <td><b>Category:</b> <%= bean.getType() %> </td>
		        </tr>
		        <tr>
		          <td><b>Publisher:</b> <%= bean.getPublisher() %> </td>
		        </tr>
		        <tr>
		          <td>&nbsp;</td>
		        </tr>
		        <tr>
		          <td valign="top"><b>Description:</b> <%= bean.getDescription() %> </td>
		        </tr>
		        <tr>
		          <td colspan="2" align="center"><label>
		              <input type="submit" value="Purchase" onClick="addItem(<%=bean.getId() %>);"/>
		              <input type="submit" value="Return" onclick="returnIndex();"/>
		          </label></td>
		          </tr>
		        <tr>
		          <td colspan="2">&nbsp;</td>
		          </tr>
		      </table>
		    </div></td>
		  </tr>
		  <tr>
		    <td height="73"><div align="center">
		    	<jsp:include flush="true" page="footer.jsp"></jsp:include> 
		    </div></td>
		  </tr>
		</table>
	</center>
</body>
</html>