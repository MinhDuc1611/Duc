package com.minhduc.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="muonsach")
public class Muonsach {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int mamuonsach;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="masach")
	Set<Sach> sach;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="madocgia")
	Docgia docgia;
	
	String ngaymuon;
	String ngaytra;
	
	
	public Set<Sach> getSach() {
		return sach;
	}
	public void setSach(Set<Sach> sach) {
		this.sach = sach;
	}
	public int getMamuonsach() {
		return mamuonsach;
	}
	public void setMamuonsach(int mamuonsach) {
		this.mamuonsach = mamuonsach;
	}
	public Docgia getDocgia() {
		return docgia;
	}
	public void setDocgia(Docgia docgia) {
		this.docgia = docgia;
	}
	public String getNgaymuon() {
		return ngaymuon;
	}
	public void setNgaymuon(String ngaymuon) {
		this.ngaymuon = ngaymuon;
	}
	public String getNgaytra() {
		return ngaytra;
	}
	public void setNgaytra(String ngaytra) {
		this.ngaytra = ngaytra;
	}

}
