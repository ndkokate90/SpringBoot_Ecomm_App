package com.nk.ProductApplication.controller;

import com.nk.ProductApplication.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductController {

   private  ProductService productService;
}
