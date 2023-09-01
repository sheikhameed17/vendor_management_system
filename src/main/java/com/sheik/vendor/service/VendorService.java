package com.sheik.vendor.service;



import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sheik.vendor.model.ProductModel;
import com.sheik.vendor.repository.ProductRepo;




@Service
public class VendorService {
@Autowired
public ProductRepo prepo;
public String saveProduct(ProductModel h) {
	prepo.save(h);
	return "Data is saved to database";
}
public List<ProductModel> getProduct()
{
	return prepo.findAll();
}
public ProductModel updateProduct(ProductModel pm)
{
	return prepo.saveAndFlush(pm);
}
 
public boolean updateProductif(int ProductId,ProductModel pm)
{
	if(prepo.existsById(ProductId)) {
		prepo.save(pm);
		return true;
	}
	return false;
}



public void deleteProduct(int product_id)
{    
	System.out.println("Deleted");
	prepo.deleteById(product_id);
}
public Optional<ProductModel> getUserId(int userId){
	Optional<ProductModel>product=prepo.findById(userId);
	
	if(product.isPresent()) {
		return product;
	}
	return null;
}

public List<ProductModel> sortByAsc(String name)
{
	return prepo.findAll(Sort.by(name).ascending());
}
public List<ProductModel> sortByDsc(String name)
{
	return prepo.findAll(Sort.by(name).descending());
}

//pagination
public List<ProductModel> pagination(int pageNu,int pageSize)
{
	Page<ProductModel> cont= prepo.findAll(PageRequest.of(pageNu, pageSize));
	return cont.getContent();
}
//sorting
public List<ProductModel> paginationAndSorting(int pagNu,int pageSize,String name)
{
	Page<ProductModel> cont1=prepo.findAll(PageRequest.of(pagNu, pageSize,Sort.by(name)));
	return cont1.getContent();
}
//get by Char
	public List<ProductModel> getDataByChar(String name)
	{
		return prepo.getByname(name);
	}
	//delete the data
	public int deleteById(int id)
	{
		return prepo.deleteId(id);
	}
	public ProductModel save(int prodId) {
		// TODO Auto-generated method stub
		return prepo.save(prodId);
	}


}