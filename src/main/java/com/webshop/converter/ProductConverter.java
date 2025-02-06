package com.webshop.converter;

import com.webshop.dto.ProductDTO;
import com.webshop.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
//    Chuyển đổi từ Entity sang DTO
    public Product toEntity(ProductDTO dto){
        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDescription(dto.getDescription());
        entity.setStock(dto.getStock());
        return entity;
    }

//    Chuyển đổi từ DTO sang Entity
    public ProductDTO toDto(Product entity){
        ProductDTO dto = new ProductDTO();
        if(entity.getId() != null){
            dto.setId(entity.getId());
        }
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDescription(entity.getDescription());
        dto.setStock(entity.getStock());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedDate(entity.getModifiedDate());
        dto.setModifiedBy(entity.getModifiedBy());
        return dto;
    }

    public Product toEntity(ProductDTO dto,Product entity){
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDescription(dto.getDescription());
        entity.setStock(dto.getStock());
        return entity;
    }
}
