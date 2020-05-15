package com.newmarketing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doituong")
public class DoituongEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int madoituong;
	
	@Column(name="namedt")
	String namedt;

	public int getMadoituong() {
		return madoituong;
	}

	public void setMadoituong(int madoituong) {
		this.madoituong = madoituong;
	}

	public String getNamedt() {
		return namedt;
	}

	public void setNamedt(String namedt) {
		this.namedt = namedt;
	}

	@Override
	public String toString() {
		return "DoituongEntity [madoituong=" + madoituong + ", namedt=" + namedt + "]";
	}
	
}
