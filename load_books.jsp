<%@page import="com.tech.library.model.Message"%>
<%@page import="com.tech.library.model.User"%>
<%@page import="com.tech.library.model.Books"%>
<%@page import="java.util.List"%>
<%@page import="com.tech.library.helper.ConnectionProvider"%>
<%@page import="com.tech.library.Dao.BooksDao"%>



<%
Message ms=(Message)session.getAttribute("msg");
if(ms!=null){
    %>
    <div class="alert <%=ms.getCssClass() %>" role="alert">
        <%=ms.getContent() %>
    </div>
    
    <% 
    session.removeAttribute("msg");
}
%>
<% 
User user=(User)session.getAttribute("currentUser");


%>

<div class="row">
<%
	Thread.sleep(1000);
	BooksDao d=new BooksDao(ConnectionProvider.getConnection());
	int cid=Integer.parseInt(request.getParameter("cid"));
	List<Books> book=null;
	if(cid ==0){
	 book=d.getAllBooks();
	}else{
		book=d.getBookByCatId(cid);
	}
	if(book.size()==0){
		out.println("<h3 class='display-3 text-center'>No Books in this Category...</h3>");
		return;
	}
	
	for(Books b:book){
%>		


	<div class="col-md-3 mb-3">
	<div class="card text-center">
	<div class="card-body">
	<div class="container">
	<img  class="img-thumblin" src="bookpics/<%= b.getPics() %>" style="width:150px;  height:200px;" >
	</div>
	
	<b class="card-title">Book Name:<%=b.getbName() %></b> 
	
	<p class="card-text">Auther:<%=b.getAutID() %></p>
	<div >
	
	<a href="RequestBook?bid=<%=b.getbID() %>&&uid=<%=user.getId() %>" class="btn- btn-sm btn-primary">Request</a>
		
	
	<a href="#" class="btn- btn-sm btn-warning">Price:<span>&#8377;</span><%=b.getbPrice() %></a>
	</div>
	</div>
	</div>
	</div>
	
		
<%	
	}

%>
</div>


