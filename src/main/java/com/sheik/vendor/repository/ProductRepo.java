package com.sheik.vendor.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sheik.vendor.model.ProductModel;

import jakarta.transaction.Transactional;


public interface ProductRepo extends JpaRepository<ProductModel, Integer>{
	
	
	
	//native Query
		@Query(value = "select * from product",nativeQuery = true)
		public List<ProductModel> getAllRows();
		//get by char
		@Query (value = "select * from product where prodname like %?1%",nativeQuery = true)
		public List<ProductModel> getByname(@Param("name") String name);
		//delete using native query
		@Modifying
		@Transactional
		@Query(value = "delete from product where prodId=:no_id",nativeQuery = true)
		public int deleteId(@Param("no_id") int id);
		public ProductModel save(int prodId);
}
