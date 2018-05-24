<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
			      		<a class="nav-link" href="">Sách</a>
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
			<div class="body container">
				<div class="row">
					<div class="col-md-4 ct_image">
						<img alt="hinh" src="resource/Images/Comic/${sach.getHinhanh()}"/><br/>
					</div>
					<div class="col-md-8">
						<a class="ct_name">${sach.getTensach()}</a>
						<div class="ct_info">
							<span><b>Thể loại : </b>${sach.getTheloai().getTentheloai() }</span><br/>
							<c:forEach var="chitietsach" items="${sach.getChitietsach() }" >
								<span><b>Tác giả   : </b>${chitietsach.getTacgia().getTentacgia() }</span><br/>
								<span><b>Số lượng  : </b>${chitietsach.getSoluong() } cuốn </span><br/>
								<span><b>Ngày nhập : </b>${chitietsach.getNgaynhap() } </span><br/>
							</c:forEach>
							<span><b>Giá : </b>${sach.getGiatien() } VNĐ</span><br/>
							
							
						</div>
						<div class="ct_decribe">
							<span><b>Mô tả :</b> ${sach.getMota() }</span>
						</div>
					</div>
					
				</div>
			</div>
			
		<jsp:include page="footer.jsp"/>
	</body>
</html>