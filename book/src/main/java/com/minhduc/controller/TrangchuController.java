package com.minhduc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrangchuController {
	@RequestMapping("/")
	public String view() {
		return "Trangchu";
	}
}
