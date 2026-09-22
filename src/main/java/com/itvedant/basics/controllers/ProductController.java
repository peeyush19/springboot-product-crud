/*
package com.itvedant.basics.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.basics.models.Product;
import com.itvedant.basics.services.ProductService;

@RestController
public class ProductController {
//	//@Autowired
//	private ProductService productService;

	private final ProductService productService;
	
	// constructor injection
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

		
	// 1. adding the product to database
		@PostMapping("/products")
		public ResponseEntity<?> addProduct(@RequestBody Product product) {
			// send the product object to service class
			Product dbProduct = productService.addProduct(product);
			return new ResponseEntity<>(dbProduct, HttpStatus.CREATED);
		}
		
		@GetMapping("/products")
		public ResponseEntity<?> getAllProducts(){
		Iterable<Product> allProducts = productService.getAllProducts();
			return new ResponseEntity<>(allProducts,HttpStatus.OK) ;
		}
		
		@GetMapping("/products/{id}")
		public ResponseEntity<?> getProductByID(@PathVariable int id) {
			Product requiredProduct = productService.getProductById(id);
			return new ResponseEntity<>(requiredProduct, HttpStatus.OK);
		}
		
		@DeleteMapping("/products/{id}")
		public ResponseEntity<?> deletePRoductById(@PathVariable int id) {
			productService.deleteProductById(id);
			return new ResponseEntity<>("Product deleted successfully", HttpStatus.NO_CONTENT);
		}
		
		
		  // 5. Update Product By ID
	    @PutMapping("/products/{id}")
	    public ResponseEntity<?> updateProductById(
	            @PathVariable int id,
	            @RequestBody Product product) {

	        Product updatedProduct =
	                productService.updateProductById(id, product);

	        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	    }

}
*/

package com.itvedant.basics.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.itvedant.basics.dto.ProductRequestDTO;
import com.itvedant.basics.dto.ProductResponseDTO;
import com.itvedant.basics.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    // Constructor Injection
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // CREATE PRODUCT
    @PostMapping
    public ProductResponseDTO addProduct(
         @Valid   @RequestBody ProductRequestDTO dto) {

        return productService.addProduct(dto);
    }

    // GET ALL PRODUCTS
    @GetMapping
    public List<ProductResponseDTO> getAllProducts() {

        return productService.getAllProducts();
    }

    // GET PRODUCT BY ID
    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(
            @PathVariable int id) {

        return productService.getProductById(id);
    }

    // UPDATE PRODUCT
    @PutMapping("/{id}")
    public ProductResponseDTO updateProductById(
            @PathVariable int id,
            @RequestBody ProductRequestDTO dto) {

        return productService.updateProductById(id, dto);
    }

    // DELETE PRODUCT
    @DeleteMapping("/{id}")
    public String deleteProductById(
            @PathVariable int id) {

        productService.deleteProductById(id);

        return "Product deleted successfully";
    }
}


