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
			  	<ul class="navbar-nav" style="font-size: 30px; margin-left: -13%;">
			    	<li class="nav-item">
			      		<a class="nav-link" href="quanly">Sách</a>
			    	</li>
			    	<li class="nav-item">
			      		<a class="nav-link" href="#">Tác giả</a>
			    	</li>
			
			    	<!-- Dropdown -->
			    	<li class="nav-item dropdown">
			      		<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
			        		Thể loại
			      		</a>
			      		<div class="dropdown-menu">
			      			<c:forEach var="theloai" items="${theloai}">
			        			<a class="dropdown-item" href='<c:url value="theloaisach?matheloai=${theloai.getMatheloai()}&${theloai.getTentheloai() }"/>'/>${theloai.getTentheloai() }</a>
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
					<div style="margin-left: 414px; margin-bottom: 22px">
						<a href="themtacgia" class="btn btn-success btn-md">Thêm tác giả</a>
						<a id="xoa-tacgia" style="color:white" class="btn btn-danger btn-md">Xóa</a>
					
					</div>
					<div class="col-md-12">
						<table id="table-tacgia" class="table">
							<tbody>
								<tr>
									<td>
									</td>
									<td><b>Tên tác giả</b></td>									
									<td></td>
									<td></td>
									
									
								</tr>
								<c:forEach var="tacgia" items="${tacgia}">
									<tr>
										<td>
											<div class="checkbox">
												<label><input class="checkboxsach" type="checkbox" value="${tacgia.getMatacgia() }"></label>
											</div>
										</td>									
										<td>${tacgia.getTentacgia()}</td>									
										<td><a class="btn btn-info btn-sm" href="chitiettacgia?matacgia=${tacgia.getMatacgia()}"> Xem chi tiết </a></td>
										<td><a href="#" class="btn btn-primary btn-sm btnCapnhatTacgia" id="${tacgia.getMatacgia()}">Cập nhật tác giả</a></td>																	
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				
			</div>
			<div class="container them-tacgia invisible">
				<div class="row">					
					<form action="" id="form-sach">
						<div class="col-md-12 form-group">
							<div style="margin-top: -70px; font-size: 39px;"><a>Thông tin tác giả cần cập nhật</a></div><br/>
		    				<label for="tentacgia" style="margin-top:33px"><b>Tên tác giả</b></label>
		   					<input class="form-control input-sm " name="tentacgia" id="tentacgia" type="text" placeholder="Nhập vào tên tác giả"><br/>
		   							   					
		   					<label for="mota"><b>Giới thiệu</b></label>
		   					<textarea class="form-control" name="mota" rows="5" id="mota" placeholder="Nhập vào giới thiệu về tác giả"></textarea><br/>
		   							   					
			   				<label for="hinhanh"><b>Hình ảnh</b></label>
				   			<input class="form-control input-sm" name="hinhanh" id="hinhanh" type="file" placeholder="Chọn hình ảnh"><br/>
				   					
				   			<a href="#" class="btn btn-primary btn-sm" id="btnCapnhatTacGia">Cập nhật</a>
			   					
		   				</div>
	   				</form>

			</div>
		</div>
					
		<jsp:include page="footer.jsp"/>
	</body>
</html>