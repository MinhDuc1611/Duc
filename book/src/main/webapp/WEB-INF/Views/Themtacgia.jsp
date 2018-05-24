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
			      			<a class="nav-link" href="tacgia">Tác giả</a>
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
		
		<div class="container them-tacgia" style="margin-top:70px">
			<div class="row">
					<form action="" id="form-tacgia">
						<div class="col-md-12 form-group">
		    				<label for="tentacgia"><b>Tên tác giả</b></label>
		   					<input class="form-control input-sm " name="tentacgia" id="tentacgia" type="text" placeholder="Nhập vào tên tác giả"><br/>
		   						   					
		   					<label for="mota"><b>Giới thiệu</b></label>
		   					<textarea class="form-control" name="mota" rows="5" id="mota" placeholder="Giới thiệu về tác giả"></textarea><br/>		   				   					
		   					
		   					<label for="hinhanh"><b>Hình ảnh</b></label>
			   				<input class="form-control input-sm" name="hinhanh" id="hinhanh" type="file" placeholder="Chọn hình ảnh"><br/>
		   					<a href="#" class="btn btn-success btn-sm" id="btnThemtacgia">Thêm tác giả</a>			
		   				</div>
	   				</form>
			</div>
		</div>					
		<jsp:include page="footer.jsp"/>
	</body>
</html>