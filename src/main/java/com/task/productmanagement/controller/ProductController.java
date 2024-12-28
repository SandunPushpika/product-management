package com.task.productmanagement.controller;

import com.task.productmanagement.core.dto.request.ProductCreateRequest;
import com.task.productmanagement.core.dto.response.ApiResponse;
import com.task.productmanagement.core.model.ProductModel;
import com.task.productmanagement.service.product.IProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createProduct(@Valid @RequestBody ProductCreateRequest productCreateRequest) {

        ProductModel model = productService.addProduct(productCreateRequest);
        ApiResponse response = new ApiResponse("Product added!", 201, model);

        return new ResponseEntity<>(response, HttpStatus.CREATED );
    }

    @GetMapping()
    public ResponseEntity<ApiResponse> getAllProducts(int pageNumber, int pageSize, String sortBy, int minPrice, int maxPrice) {

        List<ProductModel> models = productService.getProducts(pageNumber,pageSize,sortBy, minPrice, maxPrice);
        ApiResponse response = new ApiResponse("Success", 200, models);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
