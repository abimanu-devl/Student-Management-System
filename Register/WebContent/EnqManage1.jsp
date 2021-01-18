<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dao.EnquiryDao"%>
<%@page import="model.Enquiry"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/exSlideBar.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
  
   
    <!-- Required meta tags -->
    <meta charset="utf-8">
   

    <!-- Bootstrap CSS -->
    
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>Enquiry Management</title>
  
    
</head>
<body>



<div class="container">
<caption><h2>Enquiry Manage</h2></caption>
<table class="table table-striped table-hover mydatatable table-bordered table-responsive">
		
	<thead>	
		  <tr>
               <th>Enquiry ID</th>
    <th>User ID</th>
    <th>Email</th>
    <th>Subject</th>
    <th>Message</th>
	<th>Delete</th>
                
          </tr>
       </thead>
           <%
            EnquiryDao e1 = new EnquiryDao();
			ArrayList<Enquiry> arrayList = e1.getEnq();
			
			for(Enquiry enquiry : arrayList){
			%>
			<tr>
				<td><%=enquiry.getEid() %></td>
				<td><%=enquiry.getUserID() %></td>
				<td> <%=enquiry.getEmail() %> </td>
				<td> <%=enquiry.getSubject() %> </td>
				<td> <%=enquiry.getMessage() %> </td>
				<td> 
				<form method="POST" action="deleteEnqServlet">
				<input type="hidden" name="userID" value="<%=enquiry.getEid()%>"/>
				 <input type="submit" value= "Delete"  class="btn btn-danger" /> 
				 </form>
				 </td>		
			</tr>			
			<%	
			   }
            
            %>     
		</table>
		<form  method="get" action="CSVReportEnqServlet" >
   
          <button class= "btn btn-primary btn-lg" >
            <span>
              Generate Report
            </span>
          </button>
 
    </form>
		
</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	
	<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
	<!-- <script>
	    $('.mydatatable').DataTable(
	    		
	    		{     

	    		      "aLengthMenu": [[5, 10, 25, -1], [5, 10, 25, "All"]],
	    		        "iDisplayLength": 5
	    		 } 
	    		        
	    
	    );
	    
	</script> -->
	<script>
	    $('.mydatatable').DataTable();
	</script>
</body>
</html>