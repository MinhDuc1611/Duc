package com.minhduc.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity(name="theloai")
public class Theloai {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int matheloai;	
	String tentheloai;
	
	@OneToMany
	@JoinColumn(name="matheloai")
	Set<Sach> sach;
	
	public Set<Sach> getSach() {
		return sach;
	}
	public void setSach(Set<Sach> sach) {
		this.sach = sach;
	}
	public int getMatheloai() {
		return matheloai;
	}
	public void setMatheloai(int matheloai) {
		this.matheloai = matheloai;
	}
	public String getTentheloai() {
		return tentheloai;
	}
	public void setTentheloai(String tentheloai) {
		this.tentheloai = tentheloai;
	}
	
}
