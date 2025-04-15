package com.starbucks.starvive.product.infrastructure;

import com.starbucks.starvive.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

  Optional<Product> findByProductId(UUID productId);

}
