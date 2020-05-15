package com.newmarketing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newmarketing.entity.DoituongEntity;
import com.newmarketing.reponsitory.DoituongReponsitory;

@Service
public class DoituongService {

	@Autowired
	DoituongReponsitory reponsitory;
	
	public List<DoituongEntity> getAll(){
		return reponsitory.findAll();
	}
}
