package com.spring.buysell.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.buysell.models.Product;
import com.spring.buysell.serivces.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;
	
//	@GetMapping("/")
//	public String products(Model model) {
//		model.addAttribute("products", productService.list());	
//		return "products";
//	}
	
	@GetMapping("/")
	public String prods(@RequestParam(name="title", required=false) String title, Model model) {
		model.addAttribute("products", productService.listProducts(title));
		return "productsp";
	}
	
//	@PostMapping("/product/create")
//	public String createProduct(Product product) {
//		productService.saveProduct(product);
//		return "redirect:/";
//	}
	
	@PostMapping("/product/create")
	public String createProduct(@RequestParam(name="file1") MultipartFile file1, 
			@RequestParam(name="file2") MultipartFile file2, 
			@RequestParam(name="file3") MultipartFile file3, Product product) throws IOException{
		productService.saveProduct(product, file1, file2, file3);
		return "redirect:/";
	}
	
	@PostMapping("/product/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return "redirect:/";
	}
	
	@GetMapping("/product/{id}")
		public String producInfo(@PathVariable Long id, Model model) {
//			model.addAttribute("product", productService.getProductById(id));
			Product product = productService.getProductById(id);
			model.addAttribute("product", product);
			model.addAttribute("images", product.getImages());
			return "product-info";
		}
}
//add commit
//add commit
