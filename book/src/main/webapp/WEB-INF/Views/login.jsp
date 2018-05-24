<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<head>
		<jsp:include page="header.jsp"/>
		
</head>
	<body style="background:blanchedalmond"  class="bg-dark">
			
  	<div class="container py-5">
    <div class="row">
        <div class="col-md-12">        
            <div class="row" style="margin-top: 124px;">
                <div class="col-md-6 mx-auto">
                    <div class="card rounded-0">
                        <div class="card-header">
                            <h3 class="mb-0">Login</h3>
                        </div>
                        <div class="card-body">                             
                                    <label for="uname1">Username</label>
                                    <input class="form-control input-sm " id="tendangnhap" path="username" name="tendangnhap" placeholder="Username"/> <br/>
                                    <div class="invalid-feedback">Oops, you missed this one.</div>

                                    <label>Password</label>
                                    <input class="form-control input-sm " id="matkhau" path="password" name="matkhau" type="password" required="" placeholder="Password"/><br/>
                                    <div class="invalid-feedback">Enter your password too!</div>
  
                                
                                <button class="btn btn-success btn-lg float-right" name="login" id="btnDangNhap">Login</button>
                            
                        </div>                    
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


        <jsp:include page="footer.jsp"/>	      
	</body>
		
</html>