package com.minhduc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.minhduc.entities.Sach;
import com.minhduc.entities.Theloai;
import com.minhduc.service.SachService;
import com.minhduc.service.TheloaiService;

@Controller
@RequestMapping("chitiet")
public class TrangChiTietController {
		
		@Autowired
		SachService sachService;
		@Autowired
		TheloaiService theloaiService;
		
		@GetMapping
		public String Default(int masach, ModelMap modelMap) {
			
			Sach sach= sachService.listBookFromId(masach);
			List<Theloai> theloais=theloaiService.listCategory();
			modelMap.addAttribute("sach", sach);
			modelMap.addAttribute("theloai", theloais);
			return "Chitiet";
		}
}
