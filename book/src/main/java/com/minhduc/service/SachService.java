package com.minhduc.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minhduc.dao.SachDAO;
import com.minhduc.entities.Sach;
import com.minhduc.implement.SachImpl;
@Service
public class SachService implements SachImpl {
	
	@Autowired
	SachDAO sachDAO;

	public List<Sach> listBook(int firstBook) {
		return sachDAO.listBook(firstBook);		 
	}

	public Sach listBookFromId(int masach) {
		return sachDAO.listBookFromId(masach);
		
	}

	public List<Sach> listBookFromCategoryId(int matheloai) {		
		return sachDAO.listBookFromCategoryId(matheloai);
	}

	public boolean XoaSach(int masach) {
		return sachDAO.XoaSach(masach);
	}

	public boolean ThemSach(Sach sach) {
		return sachDAO.ThemSach(sach);
	}

	@Override
	public boolean CapNhatSach(Sach sach) {
		return sachDAO.CapNhatSach(sach);

	}

	
}
