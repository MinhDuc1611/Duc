package com.minhduc.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minhduc.entities.Chitietsach;
import com.minhduc.entities.JSON_Sach;
import com.minhduc.entities.JSON_Tacgia;
import com.minhduc.entities.Sach;
import com.minhduc.entities.Tacgia;
import com.minhduc.entities.Theloai;
import com.minhduc.service.NhanvienService;
import com.minhduc.service.SachService;
import com.minhduc.service.TacgiaService;

@Controller
@RequestMapping("api/")
@SessionAttributes({"tendangnhap","muonsach"})
public class APIController {
		
		@Autowired
		NhanvienService nhanvienService;
		@Autowired
		SachService sachService;
		@Autowired
		TacgiaService tacgiaService;
		
		@GetMapping("KiemTraDangNhap")
		@ResponseBody
		public String KiemTraDangNhap(@RequestParam String tendangnhap, @RequestParam String matkhau, ModelMap modelMap) {
			
			boolean kiemtra = nhanvienService.KiemTraDangNhap(tendangnhap, matkhau);
			modelMap.addAttribute("tendangnhap", tendangnhap);

			return "" + kiemtra;
		}
		
		@GetMapping("XoaSach")
		@ResponseBody
		public String XoaSach(@RequestParam int masach) {
			sachService.XoaSach(masach);
			return "hello";
		}
		
		@Autowired
		ServletContext context;
		
		@PostMapping("UpLoad")
		@ResponseBody
		public String UploadFile(MultipartHttpServletRequest request) {
			
			// Duyệt mảng lấy ra tên 1 file cần upload
			Iterator<String> tenhinhanh = request.getFileNames();
			MultipartFile file = request.getFile(tenhinhanh.next());
			
			//Lưu hình ảnh vào webapp
			String duongdancanluu = context.getRealPath("/resource/Images/Comic/");
			File file_save = new File(duongdancanluu + file.getOriginalFilename());
			try {
				file.transferTo(file_save);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(duongdancanluu);
			return "true";
		}
		
		@PostMapping("themsach")
		@ResponseBody
		public void ThemSach(@RequestParam String Json) {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonNode;
			try {
				 Sach sach = new Sach();
				 jsonNode = mapper.readTree(Json);
				 Theloai theloai = new Theloai();
				 theloai.setMatheloai(jsonNode.get("theloai").asInt());
				 
				 
				 JsonNode jsonChitietsach = jsonNode.get("chitietsach");
				 Set<Chitietsach> chitietsachs = new HashSet<>();
				 
				 // Duyệt jsonChitietsach lấy ra từng giá trị
				 for (JsonNode objectChitiet : jsonChitietsach) {
					Chitietsach chitietsach = new Chitietsach();
					
					Tacgia tacgia = new Tacgia();
					tacgia.setMatacgia(objectChitiet.get("tacgia").asInt());
					chitietsach.setTacgia(tacgia);
					chitietsach.setSoluong(objectChitiet.get("soluong").asInt());
					chitietsach.setNgaynhap(objectChitiet.get("ngaynhap").asText());
					
					chitietsachs.add(chitietsach);
				}
				
				 String tensach = jsonNode.get("tensach").asText();
				 String giatien = jsonNode.get("giatien").asText();
				 String mota = jsonNode.get("mota").asText();
				 String hinhanh = jsonNode.get("hinhanh").asText();
				 
				 sach.setTensach(tensach);
				 sach.setGiatien(giatien);
				 sach.setMota(mota);
				 sach.setHinhanh(hinhanh);
				 sach.setChitietsach(chitietsachs);
				 sach.setTheloai(theloai);
				 
				 sachService.ThemSach(sach);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		@PostMapping("capnhatsach")
		@ResponseBody
		public void CapNhatSach(@RequestParam String Json) {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonNode;
			try {
				 Sach sach = new Sach();
				 jsonNode = mapper.readTree(Json);
				 Theloai theloai = new Theloai();
				 theloai.setMatheloai(jsonNode.get("theloai").asInt());
				 
				 
				 JsonNode jsonChitietsach = jsonNode.get("chitietsach");
				 Set<Chitietsach> chitietsachs = new HashSet<>();
				 
				 // Duyệt jsonChitietsach lấy ra từng giá trị
				 for (JsonNode objectChitiet : jsonChitietsach) {
					Chitietsach chitietsach = new Chitietsach();
					
					Tacgia tacgia = new Tacgia();
					tacgia.setMatacgia(objectChitiet.get("tacgia").asInt());
					chitietsach.setTacgia(tacgia);
					chitietsach.setSoluong(objectChitiet.get("soluong").asInt());
					chitietsach.setNgaynhap(objectChitiet.get("ngaynhap").asText());
					
					chitietsachs.add(chitietsach);
				}
				
				 String tensach = jsonNode.get("tensach").asText();
				 String giatien = jsonNode.get("giatien").asText();
				 String mota = jsonNode.get("mota").asText();
				 String hinhanh = jsonNode.get("hinhanh").asText();
				 int masach = jsonNode.get("masach").asInt();
				 
				 sach.setTensach(tensach);
				 sach.setGiatien(giatien);
				 sach.setMota(mota);
				 sach.setHinhanh(hinhanh);
				 sach.setChitietsach(chitietsachs);
				 sach.setTheloai(theloai);
				 sach.setMasach(masach);
				 
				 sachService.CapNhatSach(sach);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		@PostMapping(path="DanhSachSach",produces= "application/json;charset=utf-8")
		@ResponseBody
		public JSON_Sach DanhSachSach( @RequestParam int masach) {
			JSON_Sach json_Sach = new JSON_Sach();
			Chitietsach chitietsach = new Chitietsach();
			Sach sach = sachService.listBookFromId(masach);
			
			Theloai theloai = new Theloai();
			theloai.setMatheloai(sach.getTheloai().getMatheloai());
			theloai.setTentheloai(sach.getTheloai().getTentheloai());
			
			Set<Chitietsach> chitietsachs = new HashSet<>();
			for (Chitietsach value : sach.getChitietsach()) {
				Chitietsach ctsach = new Chitietsach();
				ctsach.setMachitietsach(value.getMachitietsach());
				
				Tacgia tacgia = new Tacgia();
				tacgia.setMatacgia(value.getTacgia().getMatacgia());
				tacgia.setTentacgia(value.getTacgia().getTentacgia());
				ctsach.setTacgia(tacgia);
				
				ctsach.setSoluong(value.getSoluong());
				ctsach.setNgaynhap(value.getNgaynhap());
				
				chitietsachs.add(ctsach);
			}
			
			json_Sach.setMasach(sach.getMasach());
			json_Sach.setTensach(sach.getTensach());
			json_Sach.setGiatien(sach.getGiatien());
			json_Sach.setMota(sach.getMota());;
			json_Sach.setHinhanh(sach.getHinhanh());
			json_Sach.setTheloai(theloai);
			json_Sach.setChitietsach(chitietsachs);
			return json_Sach;
		}
		@GetMapping("MuonSach")
		public void MuonSach(@RequestParam int matheloai, @RequestParam int masach) {
			
		}
		@PostMapping("themtacgia")
		@ResponseBody
		public void ThemTacGia(@RequestParam String Json) {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonNode;
			try {
				 Tacgia tacgia = new Tacgia();
				 jsonNode = mapper.readTree(Json);
				
				 String tentacgia = jsonNode.get("tentacgia").asText();
				 String motatacgia = jsonNode.get("mota").asText();
				 String hinhanh = jsonNode.get("hinhanh").asText();
				 
				 tacgia.setTentacgia(tentacgia);
				 tacgia.setMotatacgia(motatacgia);
				 tacgia.setHinhanh(hinhanh);
				 
				 tacgiaService.ThemTacGia(tacgia);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		@GetMapping("XoaTacgia")
		@ResponseBody
		public String XoaTacgia(@RequestParam int matacgia) {
			tacgiaService.XoaTacGia(matacgia);
			return "hello";
		}
		
		@PostMapping(path="DanhSachTacGia",produces= "application/json;charset=utf-8")
		@ResponseBody
		public JSON_Tacgia DanhSachTacGia( @RequestParam int matacgia) {
			JSON_Tacgia json_Tacgia = new JSON_Tacgia();
			Tacgia tacgia = tacgiaService.TacGiaFromId(matacgia);
						
			
			json_Tacgia.setMatacgia(tacgia.getMatacgia());
			json_Tacgia.setTentacgia(tacgia.getTentacgia());
			json_Tacgia.setMotatacgia(tacgia.getMotatacgia());
			json_Tacgia.setHinhanh(tacgia.getHinhanh());
			
			return json_Tacgia;
		}
		@PostMapping("capnhattacgia")
		@ResponseBody
		public void CapNhatTacGia(@RequestParam String Json) {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonNode;
			try {
				 Tacgia tacgia = new Tacgia();
				 jsonNode = mapper.readTree(Json);
				 	
				 String tentacgia = jsonNode.get("tentacgia").asText();
				 String motatacgia = jsonNode.get("mota").asText();
				 String hinhanh = jsonNode.get("hinhanh").asText();
				 int matacgia = jsonNode.get("masach").asInt();
				 
				 tacgia.setMatacgia(matacgia);
				 tacgia.setTentacgia(tentacgia);
				 tacgia.setMotatacgia(motatacgia);
				 tacgia.setHinhanh(hinhanh);
				 
				 tacgiaService.CapNhatTacGia(tacgia);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
}
