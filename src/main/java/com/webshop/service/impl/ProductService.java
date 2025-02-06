package com.webshop.service.impl;

import com.webshop.converter.ProductConverter;
import com.webshop.dto.ProductDTO;
import com.webshop.entity.Category;
import com.webshop.entity.Product;
import com.webshop.repository.CategoryRepository;
import com.webshop.repository.ProductRepository;
import com.webshop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product productEntity = new Product();
        if (productDTO.getId() != null) {
            Optional<Product> oldProductEntityOpt = productRepository.findById(productDTO.getId());
            if(oldProductEntityOpt.isPresent()) {
                Product oldProductEntity = oldProductEntityOpt.get();
                productEntity = productConverter.toEntity(productDTO, oldProductEntity);
            }
        }else{
            productEntity = productConverter.toEntity(productDTO);
        }
            Category categoryEntity = categoryRepository.findOneByCode(productDTO.getCategoryCode());
            productEntity.setCategory(categoryEntity);
            productEntity = productRepository.save(productEntity);
            return productConverter.toDto(productEntity);
    }

    @Override
    public void delete(long[] ids) {
        for (long item : ids) {
            productRepository.deleteById(item);
        }
    }

    @Override
    public List<ProductDTO> findAll(Pageable pageable) {
        List<ProductDTO> results = new ArrayList<>();
        List<Product> entities = productRepository.findAll(pageable).getContent();
        for (Product item : entities) {
            ProductDTO productDTO = productConverter.toDto(item);
            results.add(productDTO);
        }
        return results;
    }

    @Override
    public int totalIten() {
        return (int) productRepository.count();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
    }

}
