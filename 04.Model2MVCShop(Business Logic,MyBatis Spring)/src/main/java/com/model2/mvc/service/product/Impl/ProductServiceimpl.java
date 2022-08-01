package com.model2.mvc.service.product.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.product.ProductDao;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.domain.Product;

@Service("productServiceImpl")
public class ProductServiceimpl implements ProductService{
	
	@Autowired
	@Qualifier("productDaoImpl")
	private ProductDao productDAO;
	public void setProductDao(ProductDao productDao) {
		this.productDAO = productDao;
	}
	
	public ProductServiceimpl() {
		System.out.println(this.getClass());
	}
	
	public void addProduct(Product product) throws Exception{
		productDAO.insertProduct(product);
	}
	
	public Product getProduct(int productNo) throws Exception{
		return productDAO.findProduct(productNo);
	}
	
	public Map<String, Object> getProductList(Search search) throws Exception{
		List<Product> list = productDAO.getProductList(search);
		int totalCount = productDAO.getTotalCount(search);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount));
		return map;
	}
	
	public void updateProduct(Product product) throws Exception{
		productDAO.updateProduct(product);
	}
	
}
