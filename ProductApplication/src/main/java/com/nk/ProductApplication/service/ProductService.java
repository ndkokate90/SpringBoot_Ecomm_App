package com.nk.ProductApplication.service;

import com.nk.ProductApplication.dto.ProductDto;
import com.nk.ProductApplication.entity.Category;
import com.nk.ProductApplication.entity.Product;
import com.nk.ProductApplication.mapper.ProductMapper;
import com.nk.ProductApplication.repository.CategoryRepository;
import com.nk.ProductApplication.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    public ProductDto createProduct(ProductDto productDto)
    {
       /*
       name, description, price, categoryId
       * */
      Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(()->new RuntimeException("Category Not found"));

        //Dto to Entity
       Product product = ProductMapper.toProductEntity(productDto,category);
          product = productRepository.save(product);

        // Entity to dto

        return ProductMapper.toProductDto(product);
    }

    public List<ProductDto> getAllProduct()
    {
      return productRepository.findAll().stream().map(ProductMapper::toProductDto).toList();
    }

    public ProductDto getProductById(Long id)
    {
      Product product =  productRepository.findById(id)
              .orElseThrow(()->new RuntimeException("Product not found!"));
      return ProductMapper.toProductDto(product);
    }

    public ProductDto updateProduct(Long id,ProductDto productDto)
    {
        Product product =  productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found!"));
       Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found!"));
             product.setName(productDto.getName());
             product.setDescription(productDto.getDescription());
             product.setPrice(productDto.getPrice());
             product.setCategory(category);
             productRepository.save(product);
             return ProductMapper.toProductDto(product);
    }

    public String deleteProductById(Long id)
    {
         productRepository.deleteById(id);
        return "Product "+ id + " has been deleted!";
    }

}
