<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Insert title here</title>
	<jsp:include page="header.jsp"/>
</head>
	<body>
		<div class="container-fluid header">
			<div class="circle-text">
				
			</div>						
			 <nav class="navbar navbar-expand-sm navbar-dark menubar" >
			  	<ul class="navbar-nav">
			    	<li class="nav-item">
			      		<a class="nav-link" href="quanly">Sách</a>
			    	</li>
			    	<li class="nav-item">
			      		<a class="nav-link" href="">Tác giả</a>
			    	</li>
			
			    	<!-- Dropdown -->
			    	<li class="nav-item dropdown">
			      		<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
			        	Thể loại
			      		</a>
			      		<div class="dropdown-menu">
			      			<c:forEach var="theloai" items="${theloai}">
			        			<a class="dropdown-item" href='<c:url value="theloaisach?matheloai=${theloai.getMatheloai()}"/>'/>${theloai.getTentheloai() }</a>
			        		</c:forEach>
			      		</div>
			    	</li>
			    	<li class="nav-item">
			      		<a class="nav-link" href="#">Mượn sách</a>
			    	</li>
			    			    	
			  	</ul>			  	
				</nav>
			</div>
			<div id="category" class="container">
				<div class= row>
					<div class="col-md-12">
						
						<span><b>Thể loại :${tentheloai}</b></span><br/>
					
						<table class="table">
							<tbody>
								<tr>
									<td><b>Tên sách</b></td>
									<td></td>									
																										
								</tr>
								<c:forEach var="sach" items="${list}">
								<tr>																		
										<td class="ten_sach" id="${sach.getMasach() }">${sach.getTensach()}</td>
										<td><button class="btn btn-primary btn-sm btnMuon" >Thêm vào mượn</button></td>																																											
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				
			</div>
					
		<jsp:include page="footer.jsp"/>
	</body>
</html>