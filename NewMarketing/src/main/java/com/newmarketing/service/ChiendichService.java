package com.newmarketing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newmarketing.entity.ChiendichEntity;
import com.newmarketing.reponsitory.ChiendichReponsitory;

@Service
public class ChiendichService {

	@Autowired
	ChiendichReponsitory reponsitory;
	
	public List<ChiendichEntity> getAll(){
		return reponsitory.findAll();
	}
	
	public ChiendichEntity Save(ChiendichEntity entity) {
		return reponsitory.save(entity);
	}
	
	public Optional<ChiendichEntity> finByid(Integer id) {
		return reponsitory.findById(id);
	}
	
	public void del(Integer id) {
		reponsitory.deleteById(id);
	}
}
