package com.minhduc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minhduc.entities.Nhanvien;
import com.minhduc.implement.NhanvienImpl;


@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class NhanvienDAO implements NhanvienImpl{
		
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean KiemTraDangNhap(String tendangnhap,String matkhau) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Nhanvien nhanvien = (Nhanvien) session.createQuery("from nhanvien where tendangnhap='" + tendangnhap +"' and matkhau='" + matkhau +"'").getSingleResult();
			if(nhanvien != null){
				return true;
			}
		}catch (Exception e) {
			return false;
		}
		return false;
	}
}
