package com.minhduc.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="chitietsach")
public class Chitietsach {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int machitietsach;
	
	@OneToOne
	@JoinColumn(name="masach")
	Sach sach;
	
	@OneToOne
	@JoinColumn(name="matacgia")
	Tacgia tacgia;
	
	int soluong;
	String ngaynhap;
	
	public int getMachitietsach() {
		return machitietsach;
	}
	public void setMachitietsach(int machitietsach) {
		this.machitietsach = machitietsach;
	}
	public Sach getSach() {
		return sach;
	}
	public void setSach(Sach sach) {
		this.sach = sach;
	}
	public Tacgia getTacgia() {
		return tacgia;
	}
	public void setTacgia(Tacgia tacgia) {
		this.tacgia = tacgia;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(String ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
}
