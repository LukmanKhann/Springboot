package org.jsp.userapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.userapp.dao.ProductDao;
import org.jsp.userapp.dao.UserDao;
import org.jsp.userapp.dto.Product;
import org.jsp.userapp.dto.ResponseStructure;
import org.jsp.userapp.dto.User;
import org.jsp.userapp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
 private ProductDao pdao;
	@Autowired
	private UserDao udao;
	
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product,int id) {
		Optional<User> recUser = udao.findById(id);
		ResponseStructure<Product> structure = new ResponseStructure<>();
		if(recUser.isPresent()) {
			User u = recUser.get();
			u.getProducts().add(product);
			product.setUsers(recUser.get());
			udao.updateUser(recUser.get());
			pdao.saveProduct(product);
			structure.setData(product);
			structure.setMessage("Product saved successfully");
			structure.setStatucCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product,int id) {
		Optional<User> recUser = udao.findById(id);
		ResponseStructure<Product> structure = new ResponseStructure<>();
		if(recUser.isPresent()) {
			product.setUsers(recUser.get());
			pdao.saveProduct(product);
			structure.setData(product);
			structure.setMessage("Product updated successfully");
			structure.setStatucCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	} 
	public ResponseEntity<ResponseStructure<Product>> findById (int id) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		Optional<Product> recProduct = pdao.findById(id);
		if(recProduct.isPresent()) {
			structure.setData(recProduct.get());
			structure.setMessage("Product Found");
			structure.setStatucCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<String>> deleteProduct(int id){
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Product> recProduct = pdao.findById(id);
		if(recProduct.isPresent()) {
			pdao.deleteProduct(id);
			structure.setData("product deleted successfully");
			structure.setMessage("product Found");
			structure.setStatucCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
			
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Product>>> findProductByUserId(int uid) {
		ResponseStructure<List<Product>> structure = new ResponseStructure<>();
		structure.setData(pdao.findProductByUserId(uid));
		structure.setMessage("Product found for user id ");
		structure.setStatucCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
	}
	
}
