package com.webshop.controller.api;

import com.webshop.controller.api.output.ProductOutput;
import com.webshop.converter.ProductConverter;
import com.webshop.dto.ProductDTO;
import com.webshop.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ProductAPI {

    @Autowired
    private ProductService productService;


    @GetMapping("/api/product")
    public ProductOutput showProducts(@RequestParam("page") int page,
                                      @RequestParam("limit") int limit){
        ProductOutput result = new ProductOutput();
        result.setPage(page);
        Pageable pageable = PageRequest.of(page - 1, limit);
        result.setListResult(productService.findAll(pageable));
        result.setTotalPage((int) Math.ceil((double) (productService.totalIten()) / limit));
        return result;
    }

    @PostMapping(value = "/api/product")
    public ProductDTO createProduct(@RequestBody ProductDTO model) {
        return productService.save(model);
    }

//    @PostMapping(value = "/api/product")
//    public String createProduct() {
//        System.out.print("1234");
//        return  "Thêm sản phần tc";
//    }


    @GetMapping("/api/product/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {

        var productConverter = new ProductConverter();
        var acb = productService.getProductById(id);
        return productConverter.toDto(acb);
    }

    @PutMapping(value = "/api/product-{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO model, @PathVariable("id") long id)  {
        model.setId(id);
        return productService.save(model);
    }

    @DeleteMapping(value = "/api/product")
    public void deleteProduct(@RequestBody long[] ids) {
        productService.delete(ids);
    }

}
