package com.task.productmanagement.service.product;

import com.task.productmanagement.core.dto.request.ProductCreateRequest;
import com.task.productmanagement.core.model.ProductModel;
import com.task.productmanagement.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public List<ProductModel> getProducts(int pageNumber, int pageSize, String sortBy, int minPrice, int maxPrice) {

        String column[] = sortBy.split(",");

        List<ProductModel> models = productRepository.findAllProducts(minPrice, maxPrice, PageRequest.of(pageNumber, pageSize, Sort.by(column[1].equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, column[0]))).stream().toList();

        return models;
    }

}
