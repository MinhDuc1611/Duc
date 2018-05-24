package com.minhduc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.minhduc.entities.Sach;
import com.minhduc.entities.Tacgia;
import com.minhduc.entities.Theloai;
import com.minhduc.service.SachService;
import com.minhduc.service.TacgiaService;
import com.minhduc.service.TheloaiService;

@Controller
@RequestMapping("quanly")
public class TrangQuanLy {
	
	@Autowired
	SachService sachService;
	
	@Autowired
	TheloaiService theloaiService;
	
	@Autowired
	TacgiaService tacgiaService;
	
	@GetMapping
	@Transactional
	public String Default(@SessionAttribute("tendangnhap") String tendangnhap, ModelMap modelMap){
				
		List<Theloai> theloais=theloaiService.listCategory();
		List<Sach> listSachs = sachService.listBook(0);
		List<Tacgia> tacgias = tacgiaService.listTacgia();
		modelMap.addAttribute("listSach",listSachs);
		modelMap.addAttribute("theloai", theloais);
		modelMap.addAttribute("tacgia", tacgias);
		return "Welcome";		
	}
	
}
