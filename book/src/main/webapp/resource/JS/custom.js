$(document).ready(function(){
	var masach = 0;
	
	$("#btnDangNhap").click(function() {	
		var ten = $("#tendangnhap").val();
		var password = $("#matkhau").val();
		
		$.ajax({
			url:"http://localhost:8080/book/api/KiemTraDangNhap",
			type:"get",
			data:{
				tendangnhap : ten,
				matkhau : password,
			},
			success: function(value) {
				if(value == "true"){
					duongDan = window.location.href;
					duongDanMoi = duongDan.replace("dangnhap","quanly");
					window.location = duongDanMoi;
				} else{
					alert("Đăng nhập thất bại . Vui lòng thử lại !!!")
				}
				
			}
		})		
	});
	
	$("#xoa-sach").click(function(){
		$("#table-sach input:checked").each(function() {
			var masachs = ($(this).val());
			var This = $(this);
		
			$.ajax({
				url:"http://localhost:8080/book/api/XoaSach",
				type:"get",
				data:{
					masach: masachs
				},
				success: function(value) {			
					This.closest("tr").remove();
					alert("Xóa thành công !!!")
				}
			})		
		})
	});
	
	var files = [];
	var tenhinh ="";
	$("#hinhanh").change(function(){
		files = event.target.files;
		tenhinh = files[0].name;
		forms = new FormData();
		forms.append("file",files[0]);
		$.ajax({
			url:"http://localhost:8080/book/api/UpLoad",
			type:"post",			
			data:forms,
			contentType: false,
			processData: false,
			enctype:"multipart/form-data",
			success: function(value){}
		})		
	});
	
	
	$("#btnThemsach").click(function(event){
		// ngăn chặn việc load lại thẻ form
		event.preventDefault();
		var form = $("#form-sach").serializeArray();
		
		//Khai báo đối tượng
		json={};
		// duyệt mảng form từ vị trí i -> gán tên = key value
		$.each(form, function(i, field){
	        json[field.name] = field.value;
	    });
		arrayChitiet=[];
		objectChitiet={};
		$(".chitietsach").each(function(){
			tacgia = $(this).find('select[name="tacgia"]').val();
			soluong = $(this).find('input[name="soluong"]').val();
			ngaynhap = $(this).find('input[name="ngaynhap"]').val();
			objectChitiet["tacgia"] = tacgia;
			objectChitiet["soluong"] = soluong;
			objectChitiet["ngaynhap"] = ngaynhap;
			
			arrayChitiet.push(objectChitiet);
		})
		console.log(json);
		
		json["chitietsach"] = arrayChitiet;
		json["hinhanh"] = tenhinh;
		$.ajax({
			url:"http://localhost:8080/book/api/themsach",
			type:"post",
			data:{				
				// Chuyển json sang dạng chuỗi
				Json : JSON.stringify(json)
			},
			success: function(value){
					alert("Thêm sách thành công !!")

				
			}
		})		
	});
	$("#btnCapnhatSach").click(function(event){
		// ngăn chặn việc load lại thẻ form
		event.preventDefault();
		var form = $("#form-sach").serializeArray();
		
		//Khai báo đối tượng
		json={};
		// duyệt mảng form từ vị trí i -> gán tên = key value
		$.each(form, function(i, field){
	        json[field.name] = field.value;
	    });
		arrayChitiet=[];
		objectChitiet={};
		$(".chitietsach").each(function(){
			tacgia = $(this).find('select[name="tacgia"]').val();
			soluong = $(this).find('input[name="soluong"]').val();
			ngaynhap = $(this).find('input[name="ngaynhap"]').val();
			objectChitiet["tacgia"] = tacgia;
			objectChitiet["soluong"] = soluong;
			objectChitiet["ngaynhap"] = ngaynhap;
			
			arrayChitiet.push(objectChitiet);
		})
		
		json["masach"] = masach;
		json["chitietsach"] = arrayChitiet;
		json["hinhanh"] = tenhinh;
		console.log(json);
		$.ajax({
			url:"http://localhost:8080/book/api/capnhatsach",
			type:"post",
			data:{				
				// Chuyển json sang dạng chuỗi
				Json : JSON.stringify(json)
			},
			success: function(value){
					alert("Cập nhật sách thành công !!");
					$(".them-sach ").addClass("invisible");

				
			}
		})		
	});
	$(".btnCapnhat").click(function(){
		
		$(".them-sach ").removeClass("invisible");
		masach = $(this).attr("id");
		console.log(masach);
		$.ajax({
			url:"http://localhost:8080/book/api/DanhSachSach",
			type:"post",
			data:{				
				masach : masach,
			},
			success: function(value){
				$("#tensach").val(value.tensach);
				$("#giatien").val(value.giatien);
				$("#mota").val(value.mota);
				$("#theloai").val(value.theloai.matheloai);
				
				$("#containersach").html("");
				var chitietclone = $("#chitietsach").clone().removeAttr("id");
				chitietclone.find('select[name="tacgia"]').val(value.chitietsach[0].tacgia.matacgia);
				chitietclone.find("#soluong").val(value.chitietsach[0].soluong);
				chitietclone.find('input[name="ngaynhap"]').val(value.chitietsach[0].ngaynhap);
				
				$("#containersach").append(chitietclone);
			}
			
		})		
	});
	$(".btnMuon").click(function() {
		masach= $(this).closest("tbody").find(".ten_sach").attr("id");
		tensach= $(this).closest("tr").find(".ten_sach").text();
		
		alert(tensach)
		
//		$.ajax({
//			url:"http://localhost:8080/book/api/MuonSach",
//			type:"get",
//			data:{
//				
//			},
//			success: function(value) {
//				
//			}
//		})		
		
	})
	$("#btnThemtacgia").click(function(event){

	
		// ngăn chặn việc load lại thẻ form
		event.preventDefault();
		var form = $("#form-tacgia").serializeArray();
		
		//Khai báo đối tượng
		json={};
		// duyệt mảng form từ vị trí i -> gán tên = key value
		$.each(form, function(i, field){
	        json[field.name] = field.value;
	    });
			
		json["hinhanh"] = tenhinh;
		$.ajax({
			url:"http://localhost:8080/book/api/themtacgia",
			type:"post",
			data:{				
				// Chuyển json sang dạng chuỗi
				Json : JSON.stringify(json)
			},
			success: function(value){
					alert("Thêm sách thành công !!")
			
			}
		})		
	});
	$("#xoa-tacgia").click(function(){
		$("#table-tacgia input:checked").each(function() {
			var matacgia = ($(this).val());
			var This = $(this);
		
			$.ajax({
				url:"http://localhost:8080/book/api/XoaTacgia",
				type:"get",
				data:{
					matacgia: matacgia
				},
				success: function(value) {			
					This.closest("tr").remove();
					alert("Xóa thành công !!!")
				}
			})		
		})
	});
	$(".btnCapnhatTacgia").click(function(){

			$(".them-tacgia ").removeClass("invisible");
			matacgia = $(this).attr("id");
			
			$.ajax({
				url:"http://localhost:8080/book/api/DanhSachTacGia",
				type:"post",
				data:{				
					matacgia : matacgia,
				},
				success: function(value){
					$("#tentacgia").val(value.tentacgia);
					$("#mota").val(value.mota);
					console.log(value);
				}
				
			})		
		});
	$("#btnCapnhatTacGia").click(function(event){
		// ngăn chặn việc load lại thẻ form
		event.preventDefault();
		var form = $("#form-tacgia").serializeArray();
		
		//Khai báo đối tượng
		json={};
		// duyệt mảng form từ vị trí i -> gán tên = key value
		$.each(form, function(i, field){
	        json[field.name] = field.value;
	    });
		
				
		json["hinhanh"] = tenhinh;
		$.ajax({
			url:"http://localhost:8080/book/api/capnhattacgia",
			type:"post",
			data:{				
				// Chuyển json sang dạng chuỗi
				Json : JSON.stringify(json)
			},
			success: function(value){
					alert("Thêm sách thành công !!")
					console.log(json);
			}
		})		
	});
})

