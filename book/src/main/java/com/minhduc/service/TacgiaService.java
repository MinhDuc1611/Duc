package com.minhduc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minhduc.dao.TacgiaDAO;
import com.minhduc.entities.Tacgia;
import com.minhduc.implement.TacgiaImpl;

@Service
public class TacgiaService implements TacgiaImpl{
	
	@Autowired
	TacgiaDAO tacgiaDAO;
	
	public List<Tacgia> listTacgia() {
		return tacgiaDAO.listTacgia();
	}

	@Override
	public Tacgia TacGiaFromId(int matacgia) {
		return tacgiaDAO.TacGiaFromId(matacgia);
	}

	@Override
	public boolean ThemTacGia(Tacgia tacgia) {
		return tacgiaDAO.ThemTacGia(tacgia);
		
	}

	@Override
	public boolean XoaTacGia(int matacgia) {
		return tacgiaDAO.XoaTacGia(matacgia);
	}

	@Override
	public boolean CapNhatTacGia(Tacgia tacgia) {
		return tacgiaDAO.CapNhatTacGia(tacgia);
	}

}
