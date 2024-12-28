package com.task.productmanagement.service.product;

import com.task.productmanagement.core.dto.request.ProductCreateRequest;
import com.task.productmanagement.core.model.ProductModel;

import java.util.List;

public interface IProductService {
    ProductModel addProduct(ProductCreateRequest request);
    List<ProductModel> getProducts(int pageNumber, int pageSize, String sortBy, int minPrice, int maxPrice);
}
