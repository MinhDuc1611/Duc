package com.minhduc.entities;

import java.util.Set;

public class JSON_Sach {
	int masach;
	String tensach;
	String giatien;
	String mota;
	String hinhanh;
	Theloai theloai;
	Set<Chitietsach> chitietsach;
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public int getMasach() {
		return masach;
	}
	public void setMasach(int masach) {
		this.masach = masach;
	}
	public String getGiatien() {
		return giatien;
	}
	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public Theloai getTheloai() {
		return theloai;
	}
	public void setTheloai(Theloai theloai) {
		this.theloai = theloai;
	}
	public Set<Chitietsach> getChitietsach() {
		return chitietsach;
	}
	public void setChitietsach(Set<Chitietsach> chitietsach) {
		this.chitietsach = chitietsach;
	}
}
