package com.minhduc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minhduc.entities.Sach;
import com.minhduc.entities.Theloai;
import com.minhduc.implement.TheloaiImpl;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class TheloaiDAO implements TheloaiImpl{
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Theloai> listCategory(){
		Session session = sessionFactory.getCurrentSession();
		String sql = "from theloai";
		List<Theloai> theloais = session.createQuery(sql).getResultList();
		return theloais;
	}
}
