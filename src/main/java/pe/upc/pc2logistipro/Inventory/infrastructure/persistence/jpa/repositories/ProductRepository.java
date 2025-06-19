package pe.upc.pc2logistipro.Inventory.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.pc2logistipro.Inventory.domain.model.aggregates.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long productId);
}
