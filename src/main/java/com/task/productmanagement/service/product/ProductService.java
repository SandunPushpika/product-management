package com.task.productmanagement.service.product;

import com.task.productmanagement.core.dto.request.ProductCreateRequest;
import com.task.productmanagement.core.model.ProductModel;
import com.task.productmanagement.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public ProductModel addProduct(ProductCreateRequest request) {

        ProductModel model = modelMapper.map(request, ProductModel.class);
        model.setCreatedAt(LocalDateTime.now());

        return productRepository.save(model);
    }
}
