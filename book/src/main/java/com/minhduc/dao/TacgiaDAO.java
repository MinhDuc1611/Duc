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
import com.minhduc.entities.Tacgia;
import com.minhduc.implement.TacgiaImpl;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class TacgiaDAO implements TacgiaImpl{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Tacgia> listTacgia() {
		Session session = sessionFactory.getCurrentSession();
		List<Tacgia> tacgias = session.createQuery("from tacgia").getResultList();
		return tacgias;
	}

	@Override
	@Transactional
	public Tacgia TacGiaFromId(int matacgia) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from tacgia s where s.matacgia="+ matacgia;
		Tacgia tacgia = (Tacgia) session.createQuery(sql).getSingleResult();
		
		return tacgia;
	}

	@Override
	@Transactional
	public boolean ThemTacGia(Tacgia tacgia) {
		Session session = sessionFactory.getCurrentSession();
		int id = (Integer) session.save(tacgia);
		return false;
	}

	@Override
	@Transactional
	public boolean XoaTacGia(int matacgia) {
		Session session = sessionFactory.getCurrentSession();
		Tacgia tacgia = session.get(Tacgia.class, matacgia);
		session.createQuery("delete chitietsach where matacgia="+matacgia).executeUpdate();
		session.createQuery("delete tacgia where matacgia="+matacgia).executeUpdate();
		return false;
	}

	@Override
	public boolean CapNhatTacGia(Tacgia tacgia) {
		Session session = sessionFactory.getCurrentSession();
		session.update(tacgia);
		return false;
	}



}
