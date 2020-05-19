package com.newmarketing.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tuvan")
public class TuvanEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int matuvan;
	
	@Column(name="namekh")
	String namekh;
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="madoituong")
//	DoituongEntity madoituong;
	
	@Column(name="mail")
	String mail;
	@Column(name="sdt")
	String sdt;
	@Column(name="diachi")
	String diachi;
	public int getMatuvan() {
		return matuvan;
	}
	public void setMatuvan(int matuvan) {
		this.matuvan = matuvan;
	}
	public String getNamekh() {
		return namekh;
	}
	public void setNamekh(String namekh) {
		this.namekh = namekh;
	}
//	public DoituongEntity getMadoituong() {
//		return madoituong;
//	}
//	public void setMadoituong(DoituongEntity madoituong) {
//		this.madoituong = madoituong;
//	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
//	@Override
//	public String toString() {
//		return "TuvanEntity [matuvan=" + matuvan + ", namekh=" + namekh + ", madoituong=" + madoituong + ", mail="
//				+ mail + ", sdt=" + sdt + ", diachi=" + diachi + "]";
//	}
	@Override
	public String toString() {
		return "TuvanEntity [matuvan=" + matuvan + ", namekh=" + namekh + ", mail=" + mail + ", sdt=" + sdt
				+ ", diachi=" + diachi + "]";
	}
	
}
