package com.mdv.appstore.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.mdv.appstore.model.dto.ProductDTO;
import com.mdv.appstore.model.request.ProductRequest;
import com.mdv.appstore.model.response.ApiResponse;
import com.mdv.appstore.service.ProductService;

@RestController
@RequestMapping("${app.api.base-url}/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse<Void> createProduct(@ModelAttribute @Valid ProductRequest product)
            throws IOException {
        productService.createProduct(product);
        return ApiResponse.success("Product created successfully");
    }

    @GetMapping
    public ApiResponse<List<ProductDTO>> findAll() {
        return ApiResponse.success(productService.findAll(), "Products fetched successfully");
    }

    @GetMapping("/{id}")
    public ApiResponse<ProductDTO> findById(@PathVariable("id") Long id) {
        return ApiResponse.success(productService.findById(id), "Product fetched successfully");
    }

    @PutMapping("/{id}")
    public ApiResponse<Void> updateProduct(
            @PathVariable("id") Long id, @RequestBody ProductRequest product) {
        productService.updateProduct(id, product);
        return ApiResponse.success("Product updated successfully");
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return ApiResponse.success("Product deleted successfully");
    }

    @PutMapping("/restore/{id}")
    public ApiResponse<Void> restoreProduct(@PathVariable("id") Long id) {
        productService.restoreProduct(id);
        return ApiResponse.success("Product restored successfully");
    }
}
