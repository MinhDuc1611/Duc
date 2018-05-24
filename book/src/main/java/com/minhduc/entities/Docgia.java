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

@Entity(name="docgia")
public class Docgia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int madocgia;
	String tendocgia;
	boolean gioitinh;
	String diachi;
	int sodienthoai;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="mamuonsach")
	Set<Muonsach> muonsach;

	public Set<Muonsach> getMuonsach() {
		return muonsach;
	}

	public void setMuonsach(Set<Muonsach> muonsach) {
		this.muonsach = muonsach;
	}

	public int getMadocgia() {
		return madocgia;
	}

	public void setMadocgia(int madocgia) {
		this.madocgia = madocgia;
	}

	public String getTendocgia() {
		return tendocgia;
	}

	public void setTendocgia(String tendocgia) {
		this.tendocgia = tendocgia;
	}

	public boolean isGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public int getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(int sodienthoai) {
		this.sodienthoai = sodienthoai;
	}



}
