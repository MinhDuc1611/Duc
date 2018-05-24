package com.minhduc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
@RequestMapping("/theloaisach")
public class TheloaisachController {
		@Autowired
		TheloaiService theloaiService;
		@Autowired
		SachService sachService;
		
		@GetMapping
		@Transactional
		public String Default(ModelMap modelMap, int matheloai ) {
			
			List<Sach> list = sachService.listBookFromCategoryId(matheloai);
			List<Theloai> theloais=theloaiService.listCategory();
			
			
			modelMap.addAttribute("theloai", theloais);
			modelMap.addAttribute("list", list);
			
			return "Theloaisach";
		}
}
