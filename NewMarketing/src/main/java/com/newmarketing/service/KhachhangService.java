package com.newmarketing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.newmarketing.entity.DoituongEntity;
import com.newmarketing.entity.KhachangEntity;
import com.newmarketing.reponsitory.KhachhangReponsitory;

@Service
public class KhachhangService {

	@Autowired
	KhachhangReponsitory reponsitory;
	
	public List<KhachangEntity> getAll(){
		return reponsitory.findAll();
	}
	public List<KhachangEntity> getOne(DoituongEntity madoituong ) {

		return reponsitory.findByMadoituong(madoituong);
    }
}
