
package com.itvedant.basics.services;
import com.itvedant.basics.exceptions.ProductNotFoundException;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itvedant.basics.dto.ProductRequestDTO;
import com.itvedant.basics.dto.ProductResponseDTO;
import com.itvedant.basics.models.Product;
import com.itvedant.basics.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // Constructor Injection
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // CREATE PRODUCT
    public ProductResponseDTO addProduct(ProductRequestDTO dto) {

        Product product = new Product();

        product.setName(dto.getName());
        product.setCategory(dto.getCategory());
        product.setPrice(dto.getPrice());

        Product savedProduct = productRepository.save(product);

        return mapToDTO(savedProduct);
    }

    // GET ALL PRODUCTS
    public List<ProductResponseDTO> getAllProducts() {

        return productRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // GET PRODUCT BY ID
    public ProductResponseDTO getProductById(int id) {

        Product product = productRepository.findById(id)
        		.orElseThrow(() ->
        	    new ProductNotFoundException(
        	        "Product not found with id: " + id
        	    )
        	);

        return mapToDTO(product);
    }

    // UPDATE PRODUCT
    public ProductResponseDTO updateProductById(
            int id, ProductRequestDTO dto) {

        Product product = productRepository.findById(id)
        		.orElseThrow(() ->
        	    new ProductNotFoundException(
        	        "Product not found with id: " + id
        	    )
        	);

        product.setName(dto.getName());
        product.setCategory(dto.getCategory());
        product.setPrice(dto.getPrice());

        Product updatedProduct = productRepository.save(product);

        return mapToDTO(updatedProduct);
    }

    // DELETE PRODUCT
    public void deleteProductById(int id) {

        productRepository.deleteById(id);
    }

    // ENTITY TO RESPONSE DTO CONVERSION
    private ProductResponseDTO mapToDTO(Product product) {

        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getPrice()
        );
    }
}
