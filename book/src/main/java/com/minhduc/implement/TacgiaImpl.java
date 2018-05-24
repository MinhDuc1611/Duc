package com.minhduc.implement;

import java.util.List;

import com.minhduc.entities.Tacgia;

public interface TacgiaImpl {
	List<Tacgia> listTacgia();
	Tacgia TacGiaFromId(int matacgia);
	boolean ThemTacGia(Tacgia tacgia);
	boolean XoaTacGia(int matacgia);
	boolean CapNhatTacGia(Tacgia tacgia);
}
