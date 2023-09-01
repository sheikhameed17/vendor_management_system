package com.sheik.vendor.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.sheik.vendor.model.InventoryModel;



public interface InventoryRepo extends JpaRepository<InventoryModel, Integer> {

}