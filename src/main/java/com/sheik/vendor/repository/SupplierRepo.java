package com.sheik.vendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheik.vendor.model.SupplierModel;



public interface SupplierRepo extends JpaRepository<SupplierModel, Integer>{

}