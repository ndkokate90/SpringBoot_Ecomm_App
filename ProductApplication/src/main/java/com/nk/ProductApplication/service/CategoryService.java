package com.nk.ProductApplication.service;

import com.nk.ProductApplication.dto.CategoryDto;
import com.nk.ProductApplication.entity.Category;
import com.nk.ProductApplication.mapper.CategoryMapper;
import com.nk.ProductApplication.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

     private CategoryRepository categoryRepository;
     //get All category

    public List<CategoryDto> getAllCategories()
    {
      return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDto).toList();
    }
     //create category
    public CategoryDto cerateCategory(CategoryDto categoryDto)
    {
       Category category= CategoryMapper.toCategoryEntity(categoryDto);
      category = categoryRepository.save(category);
      return  CategoryMapper.toCategoryDto(category);
    }

    public CategoryDto getCategoryById(Long id)
    {
      Category category =  categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
      return CategoryMapper.toCategoryDto(category);
    }

    public String deleteCategory(Long id)
    {
        categoryRepository.deleteById(id);
        return "Category " + id +" deleted successfully!";
    }
}
