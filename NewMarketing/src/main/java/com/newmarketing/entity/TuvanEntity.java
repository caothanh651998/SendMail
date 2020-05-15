package com.newmarketing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tuvan")
public class TuvanEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int matuvan;
	
	String tencongty;
	String tennguoilienhe;
	String sdt;
	String email;
	String diachi;
	public int getMatuvan() {
		return matuvan;
	}
	public void setMatuvan(int matuvan) {
		this.matuvan = matuvan;
	}
	public String getTencongty() {
		return tencongty;
	}
	public void setTencongty(String tencongty) {
		this.tencongty = tencongty;
	}
	public String getTennguoilienhe() {
		return tennguoilienhe;
	}
	public void setTennguoilienhe(String tennguoilienhe) {
		this.tennguoilienhe = tennguoilienhe;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
	@Override
	public String toString() {
		return "TuvanEntity [matuvan=" + matuvan + ", tencongty=" + tencongty + ", tennguoilienhe=" + tennguoilienhe
				+ ", sdt=" + sdt + ", email=" + email + ", diachi=" + diachi + "]";
	}

}
