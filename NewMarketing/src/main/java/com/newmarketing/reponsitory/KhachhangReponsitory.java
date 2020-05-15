package com.newmarketing.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.newmarketing.entity.DoituongEntity;
import com.newmarketing.entity.KhachangEntity;

public interface KhachhangReponsitory extends JpaRepository<KhachangEntity, Integer>{

	@Query(value ="SELECT * FROM khachang WHERE madoituong = ?1" ,nativeQuery = true)
	  List<KhachangEntity> findByMadoituong(DoituongEntity madoituong);
}
