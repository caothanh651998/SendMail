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
@Table(name="chiendich")
public class ChiendichEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int machiendich;
	
	@Column(name="namecd")
	String namecd;
	
	@Column(name="content")
	String content;

	public int getMachiendich() {
		return machiendich;
	}

	public void setMachiendich(int machiendich) {
		this.machiendich = machiendich;
	}

	public String getNamecd() {
		return namecd;
	}

	public void setNamecd(String namecd) {
		this.namecd = namecd;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ChiendichEntity [machiendich=" + machiendich + ", namecd=" + namecd + ", content=" + content + "]";
	}

//	public ChiendichEntity(int machiendich, String namecd, String content) {
//		super();
//		this.machiendich = machiendich;
//		this.namecd = namecd;
//		this.content = content;
//	}
	
}
