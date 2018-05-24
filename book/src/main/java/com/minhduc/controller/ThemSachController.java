package com.minhduc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minhduc.entities.Tacgia;
import com.minhduc.entities.Theloai;
import com.minhduc.service.TacgiaService;
import com.minhduc.service.TheloaiService;

@Controller
@RequestMapping("/themsach")
public class ThemSachController {
	
	@Autowired
	TheloaiService theloaiService;
	@Autowired
	TacgiaService tacgiaService;
	
	@GetMapping
	public String Default(ModelMap modelMap) {
		List<Theloai> theloais=theloaiService.listCategory();
		List<Tacgia> tacgias = tacgiaService.listTacgia();
		modelMap.addAttribute("theloai", theloais);
		modelMap.addAttribute("tacgia", tacgias);
		return "Themsach";
	}
}
