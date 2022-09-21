package com.spring.buysell.serivces;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.buysell.models.Image;
import com.spring.buysell.models.Product;
import com.spring.buysell.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
//	private List<Product> products = new ArrayList<>();
//	private long ID = 0;
//	
//	{
//		products.add(new Product(++ID, "Asus ZenBook", "New", 30000, "Dnipro", "Olena"));
//		products.add(new Product(++ID, "Asus EEE", "Used", 2000, "Zaporizhya", "Zahar"));
//		
//	}
	
	private final ProductRepository productRepository;
	
//	public List<Product> list() {return products;}
	public List<Product> listProducts(String title) {
//		List<Product> products = productRepository.findAll();
		if(title != null) return productRepository.findByTitle(title);
		return productRepository.findAll();
		
	}
	
//	public void saveProduct(Product product) {
////		product.setID(++ID);
////		products.add(product);
//		log.info("Saving new {}", product);
//		productRepository.save(product);
//	}
	
	public void saveProduct(Product product, MultipartFile file1, 
			MultipartFile file2, MultipartFile file3) throws IOException {
		Image image1;
		Image image2;
		Image image3;
		
		if(file1.getSize() != 0) {
			image1 = toImageEntity(file1);
			image1.setPreviewImage(true);
			product.addImageToProduct(image1);
		}
		if(file2.getSize() != 0) {
			image2 = toImageEntity(file2);
			product.addImageToProduct(image2);
		}
		if(file3.getSize() != 0) {
			image3 = toImageEntity(file3);
			product.addImageToProduct(image3);
		}
//		log.info("Saving new {}", product);
		log.info("Saving new Product, Title: {}; Author: {}", product.getTitle(), product.getAuthor());
		Product productFromDB = productRepository.save(product);
		productFromDB.setPreviewImageId(productFromDB.getImages().get(0).getId());
		productRepository.save(product);
}
	
	private Image toImageEntity(MultipartFile file) throws IOException {
	// TODO Auto-generated method stub
	Image image = new Image();
	image.setName(file.getName());
	image.setOriginalFileName(file.getOriginalFilename());
	image.setContentType(file.getContentType());
	image.setSize(file.getSize());
	image.setBytes(file.getBytes());
	return image;
}

	public void deleteProduct(Long id) {
//		products.removeIf(product -> product.getID().equals(id));
		productRepository.deleteById(id);
	}
	
	public Product getProductById(Long id) {
//		for(Product product : products) {
//			if(product.getID().equals(id)) return product;
//		}
//		return null;
		
		return productRepository.findById(id).orElse(null);
	}

}
