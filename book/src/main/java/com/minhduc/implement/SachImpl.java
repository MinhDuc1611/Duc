package com.minhduc.implement;

import java.util.List;

import com.minhduc.entities.Sach;

public interface SachImpl {
	List<Sach> listBook(int firstBook);
	Sach listBookFromId(int masach);
	List<Sach> listBookFromCategoryId(int matheloai);
	boolean XoaSach(int masach);
	boolean ThemSach(Sach sach);
	boolean CapNhatSach(Sach sach);
}	
