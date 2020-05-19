package com.newmarketing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newmarketing.entity.TuvanEntity;
import com.newmarketing.reponsitory.TuvanReponsitory;

@Service
public class TuvanService {

	@Autowired
	TuvanReponsitory reponsitory;
	
	public List<TuvanEntity> getAll() {
		
		return reponsitory.findAll();
	}
	
	public TuvanEntity save(TuvanEntity entity) {
		
		return reponsitory.save(entity);
	}
	
	public Optional<TuvanEntity> getbyId(Integer id) {
		return reponsitory.findById(id);
	}
	
	public void remove(Integer matuvan) {
		
		reponsitory.deleteById(matuvan);
	}

}
