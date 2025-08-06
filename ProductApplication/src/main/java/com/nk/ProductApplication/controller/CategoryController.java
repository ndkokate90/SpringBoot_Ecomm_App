package com.nk.ProductApplication.controller;


import com.nk.ProductApplication.dto.CategoryDto;
import com.nk.ProductApplication.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> cerateCategory(@RequestBody CategoryDto categoryDto)
    {
      return new ResponseEntity<>(categoryService.cerateCategory(categoryDto), HttpStatus.CREATED);
    }

}
