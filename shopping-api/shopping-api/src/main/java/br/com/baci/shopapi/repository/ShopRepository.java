package br.com.baci.shopapi.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.baci.shopapi.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long>{
    List<Shop> findAllByUserIdentifier(String userIdentifier);
    List<Shop> findAllByTotalGreaterThan(Float total);
    // List<Shop> findAllByDateGreaterThanEquals(Date date);        
    List<Shop> findAllByDateGreaterThan(LocalDateTime date);		
}