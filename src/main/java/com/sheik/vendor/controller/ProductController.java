package com.sheik.vendor.controller;




import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sheik.vendor.model.ProductModel;
import com.sheik.vendor.service.VendorService;



@RestController
public class ProductController {
@Autowired
public VendorService pser;
@PostMapping("/postProduct")
public String postProduct(@RequestBody ProductModel pr ) {
pser.saveProduct(pr);
return "Record Added Successfully";
}
@GetMapping("/getProduct")
public List<ProductModel> getHotelInfo()
{
	return pser.getProduct();
}
@PutMapping("/updateProduct/{prodId}")
public ProductModel updateProductInfo(@PathVariable int prodId)
{
	return pser.save(prodId);
}

@PutMapping("/updateProductif/{id}")
public ResponseEntity<String> updateProductInfo(@PathVariable int id,@RequestBody ProductModel pm)
 {
	 boolean updated=pser.updateProductif(id,pm);
	 if(updated) {
		 return ResponseEntity.ok("Product with ID "+id+" updated successfully");
	 }
	 else {
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with ID"+id+"not found");
	 }
 }


@DeleteMapping("/deleteProduct/{id}")
public String removeProduct(@PathVariable("id")int id)
{
	pser.deleteProduct(id);
	return "Product with Id"+id+" is deleted";
}
@DeleteMapping("/user/{userId}")
public ResponseEntity<?> getUserId(@PathVariable int userId){
	  Optional <ProductModel> product=pser.getUserId(userId);
	  if(product != null) {
		  return ResponseEntity.ok(product);
	  }
	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not available with ID"+userId+"not found");
}
//sorting ascending
@GetMapping("/sortAsc/{name}")
public List<ProductModel> sortasc(@PathVariable("name")String prodname)
{
	  return pser.sortByAsc(prodname);
}
//sorting descending
@GetMapping("/sortDesc/{name}")
public List<ProductModel> sortdsc(@PathVariable("name")String name)
{
	  return pser.sortByDsc(name);
}

//pagination
@GetMapping("/pagination/{num}/{size}")
public List<ProductModel> pagination(@PathVariable("num") int num,@PathVariable("size") int size){
	return pser.pagination(num, size);
}
//pagination and sorting
@GetMapping("/pagination/{num}/{size}/{name}")
public List<ProductModel> paginationAndSorting(@PathVariable("num") int num,@PathVariable("size") int size,@PathVariable("name") String prodname){
	return pser.paginationAndSorting(num, size, prodname);
}
//Queries

//get data by char
@GetMapping("/getByName/{char}")
public List<ProductModel> getByName(@PathVariable("char") String name)
{
	return pser.getDataByChar(name);
}
//delete data
@DeleteMapping("/deleteRow/{id}")
public String deleteRow(@PathVariable("id") int id)
{
	return pser.deleteById(id)+" deleted";
}
}