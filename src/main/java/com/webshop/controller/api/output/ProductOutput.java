package com.webshop.controller.api.output;

import com.webshop.dto.ProductDTO;
import com.webshop.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductOutput {
    private int page;
    private int totalPage;
    private List<ProductDTO> listResult= new ArrayList<>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<ProductDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<ProductDTO> listResult) {
        this.listResult = listResult;
    }
}
