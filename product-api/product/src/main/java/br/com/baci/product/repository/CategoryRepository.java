package br.com.baci.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.baci.product.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{}