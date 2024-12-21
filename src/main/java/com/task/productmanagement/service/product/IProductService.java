package com.task.productmanagement.service.product;

import com.task.productmanagement.core.dto.request.ProductCreateRequest;
import com.task.productmanagement.core.model.ProductModel;

public interface IProductService {
    ProductModel addProduct(ProductCreateRequest request);
}
