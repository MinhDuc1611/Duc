package com.minhduc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tacgia")
public class Tacgia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int matacgia;
	String tentacgia;
	String motatacgia;
	String hinhanh;
	
	public int getMatacgia() {
		return matacgia;
	}
	public void setMatacgia(int matacgia) {
		this.matacgia = matacgia;
	}
	public String getTentacgia() {
		return tentacgia;
	}
	public void setTentacgia(String tentacgia) {
		this.tentacgia = tentacgia;
	}
	public String getMotatacgia() {
		return motatacgia;
	}
	public void setMotatacgia(String motatacgia) {
		this.motatacgia = motatacgia;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
}
