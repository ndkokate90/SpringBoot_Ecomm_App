package com.nk.ProductApplication.controller;


import com.nk.ProductApplication.dto.CategoryDto;
import com.nk.ProductApplication.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getAllCategories()
    {
      return  categoryService.getAllCategories();
    }


    @PostMapping
    public ResponseEntity<CategoryDto> cerateCategory(@RequestBody CategoryDto categoryDto)
    {
      return new ResponseEntity<>(categoryService.cerateCategory(categoryDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id)
    {
      return categoryService.getCategoryById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id)
    {
        return categoryService.deleteCategory(id);
    }
}
