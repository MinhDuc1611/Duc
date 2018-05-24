package com.minhduc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minhduc.entities.Tacgia;
import com.minhduc.entities.Theloai;
import com.minhduc.service.TacgiaService;
import com.minhduc.service.TheloaiService;

@Controller
@RequestMapping("chitiettacgia")
public class TrangChiTietTacGiaController {
	
	@Autowired
	TacgiaService tacgiaService;
	@Autowired
	TheloaiService theloaiService;
	
	@GetMapping
	public String Default(int matacgia, ModelMap modelMap) {
		Tacgia tacgia = tacgiaService.TacGiaFromId(matacgia);
		List<Theloai> theloais=theloaiService.listCategory();
		modelMap.addAttribute("tacgia",tacgia);	
		modelMap.addAttribute("theloai", theloais);
		return "Chitiettacgia";
	}
}
