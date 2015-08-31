<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath(); 
%>
<table width="100%" align="center">
  <tbody>
  
    <tr>
      <td height="5" colspan="10" bgcolor="#000000"><img src="images/FilmSide.jpg" alt="FilmSide" width="100%" height="34"></td>
    </tr>
    
    <tr>
      <td height="74" colspan="2" rowspan="2"><img src="images/Filmer.jpg" alt="FileRole" width="147" height="96"></td>
      <td colspan="4" rowspan="2"><img src="images/Title.jpg" alt="Title" width="691" height="87"></td>
      <td height="52" colspan="4"><img src="images/login.jpg" alt="Login" width="35" height="35"> [SignIn]</td>
    </tr>
    
    <tr>
      <td height="39" colspan="4"><img src="images/cart.jpg" alt="cart" width="35" height="31"><a href="ShoppingCartServlet?command=showMyCart"> [My Cart]</a></td>
    </tr>
    
    <tr>
      <td height="5%" colspan="10" bgcolor="#000000"><img src="images/FilmSide.jpg" alt="FilmSide" width="100%" height="34"></td>
    </tr>
  </tbody>
</table>
<table width="100%">
    <tr >
      <td width="10%" bgcolor="#66FFFF" align="center">Main</td>
      <td width="10%" bgcolor="silver">&nbsp;</td>
      <td width="10%" bgcolor="#66FFFF" align="center">Comedy</td>
      <td width="10%" bgcolor="silver">&nbsp;</td>
      <td width="10%" bgcolor="#66FFFF" align="center">Thriller</td>
      <td width="10%" bgcolor="silver" align="center">&nbsp;</td>
      <td width="10%" bgcolor="#66FFFF" align="center">Action</td>
      <td width="10%" bgcolor="silver" align="center">&nbsp;</td>
      <td width="10%" bgcolor="#66FFFF" align="center">About Us </td>
      <td width="10%" bgcolor="silver" align="center">&nbsp;</td>
    </tr>
</table>