<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import = "com.cc.cad.model.*, java.util.*"
    pageEncoding="ISO-8859-1"%>
    
<% 
	// Retrieve User Info from session.
	UserBean ub = (UserBean)session.getAttribute("userInfo"); 
	
	ShoppingCartDAO sdao = (ShoppingCartDAO)session.getAttribute("myCart");
	
	//Retrieve shopping cart infor from request.
	ArrayList<MovieBean> al = (ArrayList)request.getAttribute("myCartInfo"); 

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
    <td><div align="center"></div>
      <table width="100%" border="1" align="center">
        <tr>
          <td><div align="center"><img src="images/Shopping_flow.jpg" alt="shoppingFlow" width="1119" height="107" /></div></td>
        </tr>
        <tr>
          <td><table width="60%" border="1" align="center">
            <tr>
              <td colspan="2"><div align="center"><strong>Customer Info </strong></div></td>
              </tr>
            <tr>
              <td width="47%"><div align="right">User Name: </div></td>
              <td width="53%"><input type="text" name="textfield" value="<%= ub.getUSERNAME() %>"/></td>
            </tr>
            <tr>
              <td><div align="right">*Full Name: </div></td>
              <td><input type="text" name="textfield2" value="<%= ub.getFULLNAME() %>"/></td>
            </tr>
            <tr>
              <td><div align="right">*Address: </div></td>
              <td><input type="text" name="textfield3" value="<%= ub.getADDRESS() %>"/></td>
            </tr>
            <tr>
              <td><div align="right">*Contact Info: </div></td>
              <td><input type="text" name="textfield4" value="<%= ub.getPHONE() %>"/></td>
            </tr>
            <tr>
              <td><div align="right">*Email: </div></td>
              <td><input type="text" name="textfield5" value="<%= ub.getEMAIL() %>"/></td>
            </tr>
            <tr>
              <td><div align="right">*Postcode: </div></td>
              <td><input type="text" name="textfield6" value="<%= ub.getPOSTCODE() %>"/></td>
            </tr>
            <tr>
              <td><div align="right">
                    <input type="button" name="cmdComplete" value="Complete Order" />
                </div></td>
              <td><input type="button" name="cmdEdit" value="Edit Info" /></td>
            </tr>
          </table></td>
        </tr>
        <tr>
          <td><table width="60%" border="1" align="center">
            <tr>
              <td colspan="4"><div align="center"><strong>My Shopping Cart </strong></div></td>
              </tr>
            <tr>
              <td width="17%">Id</td>
              <td width="27%">Name</td>
              <td width="16%">Price</td>
              <td width="40%">Quantity</td>
            </tr>
            <% 
             	for(int i=0; i< al.size();i++)
             	{
             		MovieBean mb = (MovieBean)al.get(i);
             		%>
	         		    <tr>
			              <td><%=mb.getId() %></td>
			              <td><%=mb.getName() %></td>
			              <td>$<%=mb.getPrice() %></td>
			              <td><%=sdao.getMovieNumById(mb.getId()+"") %></td>
			            </tr>
             		<% 
         
             	}
            
            %>
            <tr>
              <td colspan="4">Total price of your order: $<%=sdao.getTotalPrice() %></td>
              </tr>
            <tr>
              <td colspan="4"><div align="center">
                <input name="cmdReturn" type="button" id="cmdReturn" value="Back to Shopping" />
              </div></td>
              </tr>
          </table></td>
        </tr>
        <tr>
          <td height="47"><div align="right"><img src="images/previous.jpg" alt="Previous" width="38" height="37" /><a href="ShoppingOrderServlet"><img src="images/NextStep.jpg" alt="NextStep" width="42" height="37" border="0"/></a></div></td>
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