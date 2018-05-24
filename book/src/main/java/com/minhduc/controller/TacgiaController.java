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
@RequestMapping("/tacgia")
public class TacgiaController {
	@Autowired
	TacgiaService tacgiaService;
	@Autowired
	TheloaiService theloaiService;
	
	@GetMapping
	public String Default(ModelMap modelMap) {
		List<Tacgia> tacgia = tacgiaService.listTacgia();
		List<Theloai> theloais=theloaiService.listCategory();
		modelMap.addAttribute("tacgia", tacgia);
		modelMap.addAttribute("theloai", theloais);
		return "Tacgia";
	}
}
