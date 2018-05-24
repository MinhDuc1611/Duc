package com.minhduc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minhduc.dao.NhanvienDAO;
import com.minhduc.implement.NhanvienImpl;

@Service
public class NhanvienService implements NhanvienImpl {
		
	@Autowired
	NhanvienDAO nhanvienDAO;
	
	public boolean KiemTraDangNhap(String tendangnhap, String matkhau) {
		boolean kiemtra = nhanvienDAO.KiemTraDangNhap(tendangnhap, matkhau);
		return kiemtra;
	}
}
