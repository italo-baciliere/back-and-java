package br.com.baci.product.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.baci.product.controller.ProductNotFoundException;
import br.com.baci.product.dto.ProductDTO;
import br.com.baci.product.model.Product;
import br.com.baci.product.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    ProductRepository productRepository;

    public List<ProductDTO> getAll(){
        List<Product> produtos = productRepository.findAll();
        return produtos.stream()
                .map(ProductDTO::convert)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductByCategoryId(Long categoryId){
        List<Product> produtos = productRepository.getProductByCategory(categoryId);
        return produtos.stream()
               .map(ProductDTO::convert)
               .collect(Collectors.toList());
    }

    public ProductDTO findByProductIdentifier(String producIdentifier){
        Product product = productRepository.findByProductIdentifier(producIdentifier);
        if(product != null)
            return ProductDTO.convert(product);
        return null;
    }    
    
    public void save(ProductDTO productDTO){        
        productRepository.save(Product.convert(productDTO));
    }

    public void delete(long productId){
    // public void delete(long productId) throws ProductNotFoundException{
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()){
            productRepository.delete(product.get());
        }        
    }

    public ProductDTO findById(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        return null;
    }    

}