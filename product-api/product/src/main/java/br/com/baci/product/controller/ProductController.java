package br.com.baci.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.baci.product.dto.ProductDTO;
import br.com.baci.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping    
    public ResponseEntity<List<ProductDTO>> getProducts(){
        List<ProductDTO> productDTOs = productService.getAll();
        return new ResponseEntity<>(productDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long productId, ResponseEntity responseEntity){
        List<ProductDTO> productDTOs = productService.getAll();
        return new ResponseEntity<>(productService.findById(productId), HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity getProductByCategory(@PathVariable("categoryId") Long categoryId){
        List<ProductDTO> productDTOs = productService.getProductByCategoryId(categoryId);
        return ResponseEntity.ok().body(productDTOs);
    }

    @GetMapping("/{productIdentifier}")
    public ResponseEntity findById(@PathVariable("productIdentifier") String productIdentifier){        
        return ResponseEntity.ok().body(productService.findByProductIdentifier(productIdentifier));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity newProduct(@Valid @RequestBody ProductDTO productDTO){
        productService.save(productDTO);
        return null;
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") long productId){
        productService.delete(productId);
    }
}