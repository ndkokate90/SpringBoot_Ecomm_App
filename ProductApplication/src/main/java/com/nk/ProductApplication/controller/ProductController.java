package com.nk.ProductApplication.controller;

import com.nk.ProductApplication.dto.ProductDto;
import com.nk.ProductApplication.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

   private  ProductService productService;

   @PostMapping
   public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto)
   {
     return new ResponseEntity<>(productService.createProduct(productDto ), HttpStatus.CREATED);

   }

   @GetMapping
   public List<ProductDto> getAllProducts()
   {
      return productService.getAllProduct();
   }

   @GetMapping("/{id}")
   public ProductDto getProductById(@PathVariable Long id)
   {
      return productService.getProductById(id);
   }

   @PutMapping("/{id}")
   public ProductDto updateProduct(@PathVariable Long id,@RequestBody ProductDto productDto)
   {
   return productService.updateProduct(id,productDto);
   }

   @DeleteMapping("/{id}")
   public String deleteProduct(@PathVariable Long id)
   {
      return productService.deleteProductById(id);
   }

}
