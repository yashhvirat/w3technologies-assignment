package com.w3technologies.service;

import org.springframework.data.domain.Page;

import com.w3technologies.model.Product;

public interface ProductService {

	Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
