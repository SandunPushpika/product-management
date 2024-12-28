package com.task.productmanagement.repository;

import com.task.productmanagement.core.model.ProductModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    @Query(value = "select p from ProductModel p where p.price between ?1 and ?2")
    List<ProductModel> findAllProducts(int min, int max, Pageable pageable);

}
