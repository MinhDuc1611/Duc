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
		
		<div class="container them-sach">
			<div class="row">
					<form action="" id="form-sach">
						<div class="col-md-12 form-group">
		    				<label for="tensach"><b>Tên sách</b></label>
		   					<input class="form-control input-sm " name="tensach" id="tensach" type="text" placeholder="Nhập vào tên sách"><br/>
		   					
		   					<label for="theloai"><b>Thể loại của sách</b></label>
							  <select class="form-control" id="theloai" name="theloai">
							  <c:forEach var="theloai" items="${theloai}">
							    <option value="${theloai.getMatheloai() }">${theloai.getTentheloai() }</option>

							  </c:forEach>
							  </select><br/>
							  
		   					<label for="giatien"><b>Giá tiền</b></label>
		   					<input class="form-control input-sm" name="giatien" id="giatien" type="text" placeholder="Nhập vào giá tiền"><br/>
		   					
		   					<label for="mota"><b>Mô tả</b></label>
		   					<textarea class="form-control" name="mota" rows="5" id="mota" placeholder="Nhập vào mô tả"></textarea><br/>
		   					
		   					<div class="chitietsach">
			   					<label><b>Các chi tiết khác</b></label><br/>
			   					<label>Tên tác giả</label> 
			   					<select class="form-control" id="tacgia" name="tacgia" placeholder="Tên tác giả"> 					
			   						<c:forEach var="tacgia" items="${tacgia}">
							    		<option value="${tacgia.getMatacgia() }">${tacgia.getTentacgia() }</option>
							  		</c:forEach>
							  	</select><br/>
			   					
			   					<label>Số lượng sách</label> 
			   					<input class="form-control input-sm" name="soluong" id="soluong" type="text" placeholder="Nhập vào số lượng"><br/>
			   					
			   					<label>Ngày nhập sách</label>   			 					
			 					<div class="form-group">
									 <input placeholder="Chọn ngày nhập sách" type="date" name="ngaynhap" id="ngaynhap" max="3000-12-31" 
									        min="1000-01-01" class="form-control">
								</div>
		   					</div>
		   					
		   					<label for="hinhanh"><b>Hình ảnh</b></label>
			   				<input class="form-control input-sm" name="hinhanh" id="hinhanh" type="file" placeholder="Chọn hình ảnh"><br/>
		   					<a href="#" class="btn btn-success btn-sm" id="btnThemsach">Thêm sách</a>			
		   				</div>
	   				</form>
			</div>
		</div>					
		<jsp:include page="footer.jsp"/>
	</body>
</html>