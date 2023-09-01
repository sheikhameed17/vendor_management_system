package com.sheik.vendor.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.sheik.vendor.model.WarehouseModel;



public interface WarehouseRepo extends JpaRepository<WarehouseModel, Integer> {

}