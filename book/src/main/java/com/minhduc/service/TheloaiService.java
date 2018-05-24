package com.minhduc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minhduc.dao.TheloaiDAO;
import com.minhduc.entities.Theloai;
import com.minhduc.implement.TheloaiImpl;

@Service
public class TheloaiService implements TheloaiImpl{
		
	@Autowired
	TheloaiDAO theloaiDAO;

	public List<Theloai> listCategory() {
		return theloaiDAO.listCategory();
	}
	
	
}
