package com.minhduc.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minhduc.entities.Chitietsach;
import com.minhduc.entities.Sach;
import com.minhduc.implement.SachImpl;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SachDAO implements SachImpl{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Sach> listBook(int firstBook) {
		Session session = sessionFactory.getCurrentSession();
		List<Sach> listSachs = (List<Sach>) session.createQuery("from sach").setFirstResult(firstBook).setMaxResults(100).getResultList();
		return listSachs;
	}
	
	
	@Transactional
	public Sach listBookFromId(int masach) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from sach s where s.masach="+ masach;
		Sach sach = (Sach) session.createQuery(sql).getSingleResult();
		
		return sach;
	}

	@Transactional
	public List<Sach> listBookFromCategoryId(int matheloai) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from sach s where s.theloai.matheloai="+matheloai;
		List<Sach> list = (List<Sach>)session.createQuery(sql).getResultList();
		return list;
	}

	@Transactional
	public boolean XoaSach(int masach) {
		Session session = sessionFactory.getCurrentSession();
		Sach sach = session.get(Sach.class, masach);
		session.createQuery("delete muonsach where masach="+masach).executeUpdate();
		session.createQuery("delete chitietsach where masach="+masach).executeUpdate();
		session.createQuery("delete sach where masach="+masach).executeUpdate();
		
		return false;
	}

	@Transactional
	public boolean ThemSach(Sach sach) {
		Session session = sessionFactory.getCurrentSession();
		int id = (Integer) session.save(sach);
		return false;
	}


	@Override
	@Transactional
	public boolean CapNhatSach(Sach sach) {
		Session session = sessionFactory.getCurrentSession();
		session.update(sach);
		return false;
	}
	

}
