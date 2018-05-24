package com.minhduc.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="nhanvien")
public class Nhanvien {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int manhanvien;
	
	String hoten;
	String diachi;
	boolean gioitinh;
	String email;
	int sodienthoai;
	String tendangnhap;
	String matkhau;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="machucvu")
	Chucvu chucvu;

	public int getManhanvien() {
		return manhanvien;
	}

	public void setManhanvien(int manhanvien) {
		this.manhanvien = manhanvien;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public boolean isGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(int sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public String getTendangnhap() {
		return tendangnhap;
	}

	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public Chucvu getChucvu() {
		return chucvu;
	}

	public void setChucvu(Chucvu chucvu) {
		this.chucvu = chucvu;
	}
}
