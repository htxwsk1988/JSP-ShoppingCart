<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*, com.cc.cad.model.*"
    pageEncoding="ISO-8859-1"%>
    
<%	
	String sPageNow = request.getParameter("pageNow");
	
	int pageNow = 1; 
	
	if(sPageNow!=null){
		pageNow = Integer.parseInt(sPageNow); 
	}
	
	// Display movie items by page. 
	MovieBeanDAO dao = new MovieBeanDAO(); 
	
	ArrayList<MovieBean> al = (ArrayList<MovieBean>)dao.getMovieByPage(6, pageNow); 
	
	int pageCount = dao.getPageCount(6); 
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table width="100%" border="1" align="center">
<% 

	int time=0; 

	for(int i=0; i<2; i++){
		
		%>
		<tr>
		<%
		
		for(int j=0; j<3; j++){
			
			MovieBean bean = null; 
			
			if(time>=al.size()){
				// Default MovieBean. 
				bean = new MovieBean(); 
				
				bean.setId(0); 
				bean.setName("Unavailable");
				bean.setPrice(0.0); 
				bean.setImage("NoImage.png"); 
				bean.setDescription("Movie unavailable.");
				
			}else{
				bean = (MovieBean)al.get(time++);
			}
	
			%>
			    <td width="33%" height="292">
			    	<table width="100%" height="170" border="1">
					      <tr>
					        <td width="49%" rowspan="3"><img src="images/<%=bean.getImage() %>" alt="Avengers" width="251" height="249" /></td>
					        <td width="51%" height="104"> <a href="ShowMovieDetailServlet?command=display&id=<%=bean.getId() %>"> <%= bean.getName() %> </a> </td>
					      </tr>
					      <tr>
					        <td height="127">$<%=bean.getPrice() %></td>
					      </tr>
					      <tr>
					        <td height="18">&nbsp;</td>
					      </tr>
					      <tr>
					        <td height="30" colspan="2">Description: <%=bean.getDescription() %></td>
					      </tr>
			    	</table>
			    </td>

			<%
		}
		
		%>
		</tr>
		<%
		
		if(i==0){
			%>
			  <tr bgcolor="silver">
	    		<td colspan="3">&nbsp;</td>
 			  </tr>
			<%
		}

	}

	%>

	  <tr>
	    <td colspan="3" bgcolor="silver"><div align="center">
		<% 
			for(int i=1; i<=pageCount; i++){
				%>
				<a href="ShowMovieDetailServlet?command=paging&pageNow=<%=i %>">[<%=i %>]</a>
				<% 
			}
		%>
		</div></td>
	  </tr>
</table>