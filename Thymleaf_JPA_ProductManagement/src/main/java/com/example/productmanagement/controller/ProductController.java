package com.example.productmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.productmanagement.entity.Product;
import com.example.productmanagement.service.ProductService;

//@RestController
@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
//	@GetMapping("/productlist")
//	public List<Product> findAll()
//	{
//		return  productservice.findAll();
//	}
	
	@GetMapping("/productlist")
	public String findAll(Model model,@Param("field") String field)
	{
		 List<Product> pro= productservice.findAll(field);
		 model.addAttribute("PRODUCT",pro);
		 model.addAttribute("field",field);
		return "proUI/product.html";
	}
	
	@GetMapping("/addProduct")
	public String productFrom(Model model)
	{
		model.addAttribute("PRODUCT",new Product());
		return "/proUI/productForm.html";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("PRODUCT") Product pro)
	{
	
		productservice.save(pro);
		return "redirect:/product/productlist";
		
	}
	
	@GetMapping("/updateForm")
	public String updateForm(@RequestParam("proId") int id,Model model)
	{
		Product pro =productservice.findById(id);
		model.addAttribute("PRODUCT",pro);
		return  "/proUI/productForm.html";
	}
	
	@GetMapping("/delete")
	public String deleteById(@RequestParam("proId") int id)
	{
		productservice.deleteById(id);
		return "redirect:/product/productlist";
		
	}
	
	
	
	
}
