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

@Entity(name="sach")
public class Sach {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		int masach;		
		String tensach;
		
		@OneToOne
		@JoinColumn(name="matheloai")
		Theloai theloai;
		
		String giatien;
		String mota;
		String hinhanh;
		
		@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
		@JoinColumn(name="masach")
		Set<Chitietsach> chitietsach;
		
		public Set<Chitietsach> getChitietsach() {
			return chitietsach;
		}
		public void setChitietsach(Set<Chitietsach> chitietsach) {
			this.chitietsach = chitietsach;
		}
		public int getMasach() {
			return masach;
		}
		public void setMasach(int masach) {
			this.masach = masach;
		}
		public String getTensach() {
			return tensach;
		}
		public void setTensach(String tensach) {
			this.tensach = tensach;
		}
		public Theloai getTheloai() {
			return theloai;
		}
		public void setTheloai(Theloai theloai) {
			this.theloai = theloai;
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
}
