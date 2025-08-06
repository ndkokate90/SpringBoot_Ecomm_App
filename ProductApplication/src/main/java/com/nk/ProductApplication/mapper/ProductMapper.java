package com.nk.ProductApplication.mapper;

import com.nk.ProductApplication.dto.ProductDto;
import com.nk.ProductApplication.entity.Category;
import com.nk.ProductApplication.entity.Product;

public class ProductMapper {

    //entity to dto
    public static ProductDto toProductDto(Product product)
    {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }

    //dto to entity
    public static Product toProductEntity(ProductDto productDto,Category category)
    {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);
         return  product;
    }
}
