package pe.upc.pc2logistipro.Inventory.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.pc2logistipro.Inventory.domain.model.aggregates.ProductReview;

import java.util.List;
import java.util.Optional;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {
    /**
     * Retrieves product reviews by product ID.
     *
     * @param productId the ID of the product for which to retrieve reviews
     * @return a list of product reviews associated with the specified product ID
     */
    List<ProductReview> findByProductId(Long productId);
    /**
     * Retrieves a product review by its ID.
     *
     * @param productReviewId the ID of the product review to retrieve
     * @return an Optional containing the product review if found, or empty if not found
     */
    Optional<ProductReview> findById(Long productReviewId);
}
