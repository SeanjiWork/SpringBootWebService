package com.webshop.service;

import com.webshop.dto.ProductDTO;
import com.webshop.entity.Product;
import com.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    ProductDTO save(ProductDTO productDTO);
    void delete(long[] ids);
    List<ProductDTO> findAll(Pageable pageable);
    int totalIten();

}
