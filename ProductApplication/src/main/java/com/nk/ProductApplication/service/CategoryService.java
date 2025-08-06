package com.nk.ProductApplication.service;

import com.nk.ProductApplication.dto.CategoryDto;
import com.nk.ProductApplication.entity.Category;
import com.nk.ProductApplication.mapper.CategoryMapper;
import com.nk.ProductApplication.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

     private CategoryRepository categoryRepository;

     //create category
    public CategoryDto cerateCategory(CategoryDto categoryDto)
    {
       Category category= CategoryMapper.toCategoryEntity(categoryDto);
      category = categoryRepository.save(category);
      return  CategoryMapper.toCategoryDto(category);
    }

}
